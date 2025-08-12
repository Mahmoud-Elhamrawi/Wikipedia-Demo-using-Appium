package Pages;

import Utils.LogUtil.LogClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class P03_viewListPage {

    //Variables
    AndroidDriver driver;

    //Constructor
    public P03_viewListPage(AndroidDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By assertOnTextSelection = AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title");
    private final By goto_btn = AppiumBy.id("org.wikipedia.alpha:id/buttonView");
    private final By gotoLayout= AppiumBy.className("android.widget.LinearLayout");
    private final By backToSavedPage_btn = AppiumBy.accessibilityId("Navigate up");

    //Methods
    @Step("Click on goto button")
    public P03_viewListPage clickOnGotoButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(gotoLayout));
        driver.findElement(goto_btn).click();
        LogClass.info("goto button is clicked");
        return this;
    }

    @Step("Click on back to saved page button")
    public P02_searchPage clickOnBackToSavedPageButton() {
        driver.findElement(backToSavedPage_btn).click();
        LogClass.info("back to saved page button is clicked");
        return new P02_searchPage(driver);
    }


    //Verification
    public P03_viewListPage assertOnViewListPage(String expectedText) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(assertOnTextSelection));
        Assert.assertEquals(driver.findElement(assertOnTextSelection).getText(), expectedText);
        return this;
    }

}
