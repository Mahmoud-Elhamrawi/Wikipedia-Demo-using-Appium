package TestCases;

import Pages.P01_landingPage;
import Pages.P02_searchPage;
import Pages.P03_viewListPage;
import io.qameta.allure.Description;
import org.testng.annotations.*;
import Listener.testNGlistener;

import static Utils.DataUtils.ReadPropertyFile.getPropertyKey;


@Listeners(testNGlistener.class)
public class End2endFlow extends TestBase {


    @Description("Skip boarding page by clicking on skip button")
    @Test(priority = 1)
    public void skipBoardingPage() {
        new P01_landingPage(driver)
                .skipOnBoardingScreen();
    }

    @Description("Search for a term and add to list")
    @Test(priority = 2, dependsOnMethods = "skipBoardingPage")
    public void SearchTest() {
        new P02_searchPage(driver)
                .clickOnSearchInput()
                .enterTextOnSearch(getPropertyKey("searchTerm"))
                .assertOnSearchPage(getPropertyKey("assertText"))
                .clickOnFirstResult()
                .skipWindow()
                .assertOnTextSelection(getPropertyKey("assertText"))
                .assertOnContentSelection(getPropertyKey("assertContent"))
                .clickOnSaveButton()
                .assertOnSaveAction(getPropertyKey("saveAction"))
                .clickOnAddToListButton()
                .typeNewList(getPropertyKey("typeTextList_Inp"))
                .clickOnViewListButton();


    }

    @Description("Add item to list")
    @Test(priority = 3, dependsOnMethods = "SearchTest")
    public void addItemToList() {
        new P03_viewListPage(driver)
                .clickOnGotoButton()
                .assertOnViewListPage(getPropertyKey("assertText"))
                .clickOnBackToSavedPageButton();
    }

    @Description("Remove item from list")
    @Test(priority = 4, dependsOnMethods = "addItemToList")
    public void removeFromList() {
        new P02_searchPage(driver)
                .clickOnSaveButtonToRemove()
                .clickOnRemoveButton()
                .assertOnRemoveToast(getPropertyKey("toastRemove"));

    }

}
