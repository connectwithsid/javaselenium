package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void type(WebElement element, String text) {
        WaitUtility.waitForVisibility(driver, element);
        element.clear();
        element.sendKeys(text);
    }

    protected void click(WebElement element) {
        WaitUtility.waitForElementToBeClickable(driver, element);
        element.click();
    }

    protected String getText(WebElement element) {
        WaitUtility.waitForVisibility(driver, element);
        return element.getText();
    }

    protected boolean isDisplayed(WebElement element) {
        WaitUtility.waitForVisibility(driver, element);
        return element.isDisplayed();
    }
}