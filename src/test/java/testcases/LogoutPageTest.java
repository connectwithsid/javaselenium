package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.ConfigReader;

public class LogoutPageTest extends BaseClass {

    @Test(groups = {"regression"})
    public void verifyUserLogout() {

        ConfigReader config = new ConfigReader();

        // Home Page
        HomePage homePage = new HomePage(getDriver());

        homePage.clickMyAccount();
        homePage.clickLogin();

        // Login
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.enterEmail(config.getEmail());
        loginPage.enterPassword(config.getPassword());
        loginPage.clickLogin();

       // Logout
       homePage = new HomePage(getDriver());

       homePage.clickMyAccount();
       homePage.clickLogout();

        // Logout Page
        LogoutPage logoutPage = new LogoutPage(getDriver());

        Assert.assertEquals(
                logoutPage.getLogoutHeading(),
                "Account Logout"
        );

        logoutPage.clickContinue();
    }
}