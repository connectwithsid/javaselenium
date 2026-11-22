package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.SearchPage;

public class SearchPageTest extends BaseClass {

    @Test(groups = {"smoke", "regression"})
    public void verifyProductSearch() {

        SearchPage searchPage = new SearchPage(getDriver());

        searchPage.enterSearchText("iPhone");
        searchPage.clickSearch();

        Assert.assertTrue(searchPage.isIphoneDisplayed(),
                "iPhone product is not displayed in search results.");
    }

    @Test(groups = {"regression"})
    public void verifyInvalidProductSearch() {

        SearchPage searchPage = new SearchPage(getDriver());

        searchPage.enterSearchText("xyzabc123");
        searchPage.clickSearch();

        Assert.assertTrue(searchPage.isNoProductMessageDisplayed(),
                "No product message is not displayed.");
    }

    @Test(groups = {"regression"})
    public void verifyEmptyProductSearch() {

        SearchPage searchPage = new SearchPage(getDriver());

        searchPage.enterSearchText("");
        searchPage.clickSearch();

        Assert.assertTrue(searchPage.isNoProductMessageDisplayed(),
                "No product message is not displayed for empty search.");
    }

    @Test(groups = {"regression"})
    public void verifyPartialProductSearch() {

        SearchPage searchPage = new SearchPage(getDriver());

        searchPage.enterSearchText("iPh");
        searchPage.clickSearch();

        Assert.assertTrue(searchPage.isIphoneDisplayed(),
                "iPhone product is not displayed for partial search.");
    }
}