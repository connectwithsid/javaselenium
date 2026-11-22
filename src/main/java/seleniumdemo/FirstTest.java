package seleniumdemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.time.Duration;
import org.openqa.selenium.TimeoutException;

public class FirstTest {

    public static void main(String[] args) {

WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();
driver.get("https://the-internet.herokuapp.com/?utm_source=chatgpt.com");
driver.manage().window().maximize();
String title = driver.getTitle();
Assert.assertEquals("The Internet", title);
System.out.println(title);
driver.findElement(By.linkText("Dropdown")).click();

WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement drop = wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdown")));
Select select = new Select(drop);
select.selectByVisibleText("Option 2");

Assert.assertEquals("Option 2", select.getFirstSelectedOption().getText());
}}