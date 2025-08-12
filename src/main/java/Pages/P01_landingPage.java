package Pages;

import Utils.LogUtil.LogClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P01_landingPage {

    //Variables
    AndroidDriver driver;


    //Constructor
    public P01_landingPage(AndroidDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By skip_btn = AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button");

    //methods actions
    @Step("Click on skip button to navigate to landing page")
    public P01_landingPage skipOnBoardingScreen() {
        driver.findElement(skip_btn).click();
        LogClass.info("Skip btn is clicked");
        return this;
    }


}
