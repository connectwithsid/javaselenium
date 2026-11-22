package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='content']/h1")
    private WebElement lblLogoutHeading;

    @FindBy(linkText = "Continue")
    private WebElement btnContinue;

    public String getLogoutHeading() {
        return getText(lblLogoutHeading);
    }

    public void clickContinue() {
        click(btnContinue);
    }
}