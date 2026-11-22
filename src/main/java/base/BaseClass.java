package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import factory.DriverFactory;
import utilities.ConfigReader;

public class BaseClass {

    ConfigReader config = new ConfigReader();

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setup(String browser) {

        System.out.println("===== BASECLASS SETUP EXECUTED =====");
        System.out.println("===== Browser: " + browser + " =====");

        WebDriver driver = DriverFactory.initializeBrowser(browser);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(config.getUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    protected WebDriver getDriver() {
        return DriverFactory.getDriver();
    }
}