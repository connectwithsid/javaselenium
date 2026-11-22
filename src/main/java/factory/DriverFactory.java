package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initializeBrowser(String browser) {

        WebDriver webDriver = null;

        if (browser.equalsIgnoreCase("chrome")) {
            webDriver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("edge")) {

    System.setProperty(
        "webdriver.edge.driver",
        "C:\\Users\\Sudhir\\Downloads\\msedgedriver.exe"
    );

    webDriver = new EdgeDriver();
}
        else {
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        driver.set(webDriver);

        return driver.get();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {

        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}