package Listener;

import Utils.LogUtil.LogClass;
import org.testng.*;

import java.io.File;
import java.io.IOException;

import static Utils.Allure.AllureClass.addLogToAllure;
import static Utils.DataUtils.ReadPropertyFile.loadPropertyFile;
import static Utils.FileUtil.FileClass.cleanDirectory;

public class testNGlistener implements IExecutionListener, ITestListener, IInvokedMethodListener {


    File logsPath = new File("test-outputs/logs/");
    File allurePath = new File("test-outputs/target/allure-results/");

    @Override
    public void onExecutionStart() {
        LogClass.info("Execution started");
        loadPropertyFile();

        cleanDirectory(logsPath);
        LogClass.info("Previous Logs directory cleaned");

        cleanDirectory(allurePath);
        LogClass.info("Previous Allure directory cleaned");

    }


    @Override
    public void onExecutionFinish() {
        LogClass.info("Execution finished");

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        //do nothing
        if (method.isTestMethod()) {
            addLogToAllure();
        }

    }


    @Override
    public void onTestStart(ITestResult result) {
        LogClass.info("Test Case ", result.getName(), "started");
    }


    @Override
    public void onTestSuccess(ITestResult result) {
        LogClass.info("Test Case ", result.getName(), "passed");
    }


    @Override
    public void onTestFailure(ITestResult result) {
        LogClass.error("Test Case ", result.getName(), "failed");
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        LogClass.info("Test Case ", result.getName(), "skipped");
    }


    @Override
    public void onStart(ITestContext context) {
        LogClass.info("Test Suite ", context.getName(), "started");
    }


    @Override
    public void onFinish(ITestContext context) {
        LogClass.info("Test Suite ", context.getName(), "finished");
    }


}
