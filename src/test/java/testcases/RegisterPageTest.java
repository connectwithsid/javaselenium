
package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.RegisterPage;
import utilities.RandomDataGenerator;
import utilities.ExtentTestListener;

public class RegisterPageTest extends BaseClass {

   @Test(groups = {"smoke", "regression"})
    public void verifyUserRegistration() {

        ExtentTestListener.logStep("Opening My Account menu");

        HomePage homePage = new HomePage(getDriver());

        homePage.clickMyAccount();

        ExtentTestListener.logStep("Clicking Register option");
        homePage.clickRegister();

        RegisterPage registerPage = new RegisterPage(getDriver());

        ExtentTestListener.logStep("Entering first name");
        registerPage.enterFirstName(RandomDataGenerator.generateFirstName());

        ExtentTestListener.logStep("Entering last name");
        registerPage.enterLastName(RandomDataGenerator.generateLastName());

        String email = RandomDataGenerator.generateEmail();

        ExtentTestListener.logStep("Entering email");
        registerPage.enterEmail(email);

        ExtentTestListener.logStep("Entering telephone number");
        registerPage.enterTelephone(RandomDataGenerator.generatePhoneNumber());

        String password = RandomDataGenerator.generatePassword();

        ExtentTestListener.logStep("Entering password");
        registerPage.enterPassword(password);

        ExtentTestListener.logStep("Confirming password");
        registerPage.enterConfirmPassword(password);

        ExtentTestListener.logStep("Accepting privacy policy");
        registerPage.acceptPrivacyPolicy();

        ExtentTestListener.logStep("Clicking Continue");
        registerPage.clickContinue();

        ExtentTestListener.logStep("Verifying account creation");
        Assert.assertEquals(
                getDriver().getTitle(),
                "Your Account Has Been Created!"
        );
    }
}
