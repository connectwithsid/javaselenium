package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.StaleElementReferenceException;

public class WaitUtility {

    private static final int EXPLICIT_WAIT = 10;

    public static void waitForVisibility(WebDriver driver, WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {

    WebDriverWait wait = new WebDriverWait(
            driver, Duration.ofSeconds(EXPLICIT_WAIT));

    wait.ignoring(StaleElementReferenceException.class);

    wait.until(ExpectedConditions.elementToBeClickable(element));
}
}