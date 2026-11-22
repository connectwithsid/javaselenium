
package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import base.BaseClass;
import factory.DriverFactory;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.ExcelUtility;
import utilities.ExtentTestListener;

import java.io.IOException;

public class LoginPageTest extends BaseClass {

   @Test(groups = {"smoke", "regression"},retryAnalyzer = utilities.RetryAnalyzer.class)
   public void verifyValidLogin() {

        ConfigReader config = new ConfigReader();
        WebDriver driver = DriverFactory.getDriver();

        ExtentTestListener.logStep("Opening My Account menu");

        HomePage homePage = new HomePage(driver);
        homePage.clickMyAccount();

        ExtentTestListener.logStep("Clicking Login option");
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage(driver);

        ExtentTestListener.logStep("Entering valid email");
        loginPage.enterEmail(config.getEmail());

        ExtentTestListener.logStep("Entering valid password");
        loginPage.enterPassword(config.getPassword());

        ExtentTestListener.logStep("Clicking Login button");
        loginPage.clickLogin();

        ExtentTestListener.logStep("Verifying My Account page");
        Assert.assertEquals(driver.getTitle(), "My Account");
    }

    @DataProvider(name = "excelLoginData", parallel = false)
    public Object[][] excelLoginData() throws IOException {

        String filePath = "src/testdata/LoginTestData.xlsx";

        return ExcelUtility.readExcelData(filePath);
    }

 @Test(dataProvider = "excelLoginData", groups = {"regression"})
public void verifyInvalidLogin(String email, String password) {

    WebDriver driver = DriverFactory.getDriver();

    ExtentTestListener.logStep("Opening My Account menu");

    HomePage homePage = new HomePage(driver);
    homePage.clickMyAccount();

    ExtentTestListener.logStep("Clicking Login option");
    homePage.clickLogin();

    LoginPage loginPage = new LoginPage(driver);

    ExtentTestListener.logStep("Entering invalid email");
    loginPage.enterEmail(email);

    ExtentTestListener.logStep("Entering invalid password");
    loginPage.enterPassword(password);

    ExtentTestListener.logStep("Clicking Login button");
    loginPage.clickLogin();

    ExtentTestListener.logStep("Verifying warning message");

    Assert.assertTrue(
            loginPage.getWarningMessage().contains("Warning"),
            "Warning message was not displayed."
    );
}
}
