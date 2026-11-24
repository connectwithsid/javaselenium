package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;

public class HomePageTest extends BaseClass {
    // Practising Git commit and push

    @Test(groups = {"regression"})
    public void verifyRegisterNavigation() {

        HomePage homePage = new HomePage(getDriver());

        homePage.clickMyAccount();
        homePage.clickRegister();

        Assert.assertTrue(getDriver().getCurrentUrl().contains("register"));
    }
}