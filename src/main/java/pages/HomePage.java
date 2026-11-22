package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Login")
    private WebElement loginLink;

    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement myAccount;

    @FindBy(linkText = "Register")
    private WebElement registerLink;

    @FindBy(linkText = "Logout")
    private WebElement lnkLogout;

    public void clickLogin() {
    click(loginLink);
    }
   public void clickMyAccount() {
    click(myAccount);
    }

   public void clickRegister() {
    click(registerLink);
}
    public void clickLogout() {
    click(lnkLogout);
    }
}