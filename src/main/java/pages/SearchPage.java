package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[contains(@name, 'search')]")
    private WebElement searchBox;

    @FindBy(xpath = "//i[contains(@class, 'fa fa-search')]")
    private WebElement searchButton;

    @FindBy(xpath = "//a[contains(text(), 'iPhone')]")
    private WebElement iphoneProduct;

    @FindBy(xpath = "//p[normalize-space()='There is no product that matches the search criteria.']")
    private WebElement noProductMessage;


    public void enterSearchText(String productName) {
        type(searchBox, productName);
    }

    public void clickSearch() {
        click(searchButton);
    }

    public boolean isIphoneDisplayed() {
        return iphoneProduct.isDisplayed();
    }
    public boolean isNoProductMessageDisplayed() {
    return noProductMessage.isDisplayed();
}

}
