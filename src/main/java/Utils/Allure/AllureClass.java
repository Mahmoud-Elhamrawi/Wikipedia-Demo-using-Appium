package Utils.Allure;

import Utils.LogUtil.LogClass;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static Utils.FileUtil.FileClass.getLastFile;
import static Utils.LogUtil.LogClass.logPath;

public class AllureClass {
    //add log to allure
    public static void addLogToAllure() {
        try {
            File logsPath = getLastFile(logPath);
            Allure.addAttachment("Last Log", Files.readString(logsPath.toPath()));
            LogClass.info("Add log to allure");
        } catch (Exception e) {
            LogClass.error("Fail to add log to allure", e.getMessage());
        }

    }



}
