package TestCases;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import static Utils.DataUtils.ReadPropertyFile.getPropertyKey;

public class TestBase {

    AndroidDriver driver;
    AppiumDriverLocalService appiumService;
    UiAutomator2Options options;


    //Configuration
    @BeforeSuite
    public void runServer() {
        appiumService = new AppiumServiceBuilder()
                .withAppiumJS(new File(getPropertyKey("mainJsPath")))
                .withIPAddress(getPropertyKey("ipAddress"))
                .usingPort(Integer.parseInt(getPropertyKey("port")))
                .build();


//        if (!appiumService.isRunning() || appiumService == null) {
//            Assert.assertNotNull(appiumService);
//            appiumService.start();
//        }
    }


    @BeforeClass
    public void setOptions() throws URISyntaxException, MalformedURLException {
        options = new UiAutomator2Options();
        options.setDeviceName(getPropertyKey("deviceName"));
        options.setApp(getPropertyKey("appPath"));
        options.setAppWaitActivity(getPropertyKey("activityStart"));

        driver = new AndroidDriver(new URI(getPropertyKey("appiumLocalHost")).toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @AfterSuite
    public void stopServer() {

        if (appiumService.isRunning() && appiumService != null) {
            appiumService.stop();
        }
    }


}
