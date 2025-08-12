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

public class P02_searchPage {
    //variable
    AndroidDriver driver;

    //constructor
    public P02_searchPage(AndroidDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By search_input = AppiumBy.id("org.wikipedia.alpha:id/search_container");
    private final By search_text = AppiumBy.id("org.wikipedia.alpha:id/search_src_text");
    private final By assertOnSearchPage = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"org.wikipedia.alpha:id/page_list_item_title\" and @text=\"Test automation\"]");
    private final By closeWindow_win = AppiumBy.accessibilityId("Close");
    private final By assertOnTextSelection = AppiumBy.xpath("(//android.widget.TextView[@text=\"Test automation\"])[1]");
    private final By assertOnContentSelection = AppiumBy.xpath("//android.widget.TextView[@text=\" (separate from the software being tested) for controlling the execution of tests and comparing actual outcome with predicted.\"]");
    private final By save_btn = AppiumBy.id("org.wikipedia.alpha:id/page_save");
    private final By assertOnSaveAction = AppiumBy.id("org.wikipedia.alpha:id/snackbar_text");
    private final By addToList_btn = AppiumBy.id("org.wikipedia.alpha:id/snackbar_action");
    private final By typeTextList_Inp = AppiumBy.id("org.wikipedia.alpha:id/text_input");
    private final By okList_btn = AppiumBy.id("android:id/button1");
    private final By viewList_Btn = AppiumBy.id("org.wikipedia.alpha:id/snackbar_action");

    private final By save_Btn = AppiumBy.accessibilityId("Save");
    private final By remove_Btn = AppiumBy.xpath("(//android.widget.LinearLayout[@resource-id=\"org.wikipedia.alpha:id/content\"])[3]");
    private final By assertOnRemove_Toast = AppiumBy.id("org.wikipedia.alpha:id/snackbar_text");


    @Step("Click on search input")
    public P02_searchPage clickOnSearchInput() {
        driver.findElement(search_input).click();
        LogClass.info("search input is clicked");
        return this;
    }

    @Step("Enter text on search input")
    public P02_searchPage enterTextOnSearch(String text) {
        driver.findElement(search_text).sendKeys(text);
        LogClass.info("text is entered : ", text);
        return this;
    }

    @Step("click on first result")
    public P02_searchPage clickOnFirstResult() {
        driver.findElement(assertOnSearchPage).click();
        LogClass.info("first result is clicked");
        return this;
    }

    @Step("skip window")
    public P02_searchPage skipWindow() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(closeWindow_win));
        driver.findElement(closeWindow_win).click();
        LogClass.info("window is skipped");
        return this;
    }

    @Step("click on save button")
    public P02_searchPage clickOnSaveButton() {
        driver.findElement(save_btn).click();
        LogClass.info("save button is clicked");
        return this;
    }

    @Step("click on add to list button")
    public P02_searchPage clickOnAddToListButton() {
        driver.findElement(addToList_btn).click();
        LogClass.info("add to list button is clicked");
        return this;
    }

    @Step("enter text on list input")
    public P02_searchPage typeNewList(String text) {
        driver.findElement(typeTextList_Inp).sendKeys(text);
        driver.findElement(okList_btn).click();
        LogClass.info("text is entered : ", text, "list is created");
        return this;
    }

    @Step("click on view list button")
    public P03_viewListPage clickOnViewListButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(viewList_Btn));
        driver.findElement(viewList_Btn).click();
        LogClass.info("view list button is clicked");
        return new P03_viewListPage(driver);
    }

    @Step("click on save button to remove")
    public P02_searchPage clickOnSaveButtonToRemove() {
        driver.findElement(save_Btn).click();
        LogClass.info("save button is clicked");
        return this;
    }

    @Step("click on remove button")
    public P02_searchPage clickOnRemoveButton() {
        driver.findElement(remove_Btn).click();
        LogClass.info("remove button is clicked");
        return this;
    }

    //verification
    @Step("Assert on search page")
    public P02_searchPage assertOnSearchPage(String expectedText) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(assertOnSearchPage));
        driver.findElement(assertOnSearchPage).isDisplayed();
        Assert.assertEquals(driver.findElement(assertOnSearchPage).getText(), expectedText);
        LogClass.info("Assert on search page is passed :", expectedText);
        return this;
    }

    @Step("Assert on text selection")
    public P02_searchPage assertOnTextSelection(String expectedText) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(assertOnTextSelection));
        Assert.assertEquals(driver.findElement(assertOnTextSelection).getText(), expectedText);
        LogClass.info("Assert on text selection is passed :", expectedText);
        return this;
    }

    @Step("Assert on content selection")
    public P02_searchPage assertOnContentSelection(String expectedText) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(assertOnContentSelection));
        Assert.assertTrue(driver.findElement(assertOnContentSelection).getText().contains(expectedText));
        LogClass.info("Assert on content selection is passed :", expectedText);
        return this;
    }

    @Step("Assert on save action")
    public P02_searchPage assertOnSaveAction(String expectedText) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(assertOnSaveAction));
        Assert.assertEquals(driver.findElement(assertOnSaveAction).getText(), expectedText);
        LogClass.info("Assert on save action is passed :", expectedText);
        return this;
    }

    @Step("Assert on remove toast")
    public P02_searchPage assertOnRemoveToast(String expectedText) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(assertOnRemove_Toast));
        Assert.assertEquals(driver.findElement(assertOnRemove_Toast).getText(), expectedText);
        LogClass.info("Assert on remove toast is passed :", expectedText);
        return this;
    }
}
