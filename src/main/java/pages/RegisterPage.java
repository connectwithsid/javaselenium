package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.WaitUtility;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-firstname")
    private WebElement txtFirstName;

    @FindBy(id = "input-lastname")
    private WebElement txtLastName;

    @FindBy(id = "input-email")
    private WebElement txtEmail;

    @FindBy(id = "input-telephone")
    private WebElement txtTelephone;

    @FindBy(id = "input-password")
    private WebElement txtPassword;

    @FindBy(id = "input-confirm")
    private WebElement txtConfirmPassword;

    @FindBy(name = "agree")
    private WebElement chkPrivacyPolicy;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement btnContinue;


   public void enterFirstName(String firstName) {
    type(txtFirstName, firstName);
}

public void enterLastName(String lastName) {
    type(txtLastName, lastName);
}

public void enterEmail(String email) {
    type(txtEmail, email);
}

public void enterTelephone(String telephone) {
    type(txtTelephone, telephone);
}

public void enterPassword(String password) {
    type(txtPassword, password);
}

public void enterConfirmPassword(String confirmPassword) {
    type(txtConfirmPassword, confirmPassword);
}

public void acceptPrivacyPolicy() {
    click(chkPrivacyPolicy);
}

public void clickContinue() {
    click(btnContinue);
}

}