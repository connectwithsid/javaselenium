
package utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ISuiteResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import factory.DriverFactory;

public class ExtentTestListener implements ITestListener, ISuiteListener {

    private static ExtentReports extent =
            ExtentReportManager.getExtentReports();

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        String browser = result.getTestContext()
                .getCurrentXmlTest()
                .getParameter("browser");

        ExtentTest extentTest = extent.createTest(
                browser.toUpperCase() + " - "
                + result.getMethod().getMethodName()
        );

        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        long executionTime =
                result.getEndMillis() - result.getStartMillis();

        test.get().pass("Test Passed");
        test.get().info("Execution Time: " + executionTime + " ms");

        test.remove();
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.get().fail(result.getThrowable());

        long executionTime =
                result.getEndMillis() - result.getStartMillis();

        test.get().info("Execution Time: " + executionTime + " ms");

        WebDriver driver = DriverFactory.getDriver();

        if (driver != null) {

            try {
                String timestamp = new SimpleDateFormat(
                        "yyyyMMdd_HHmmss_SSS"
                ).format(new Date());

                String screenshotName =
                        result.getMethod().getMethodName()
                        + "_" + timestamp + ".png";

                String screenshotPath =
                        "screenshots/" + screenshotName;

                File source = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

                Files.createDirectories(Paths.get("screenshots"));

                Files.copy(
                        source.toPath(),
                        Paths.get(screenshotPath),
                        StandardCopyOption.REPLACE_EXISTING
                );

                test.get().addScreenCaptureFromPath(
                        "../" + screenshotPath
                );

            } catch (Exception e) {
                test.get().fail(
                        "Screenshot capture failed: " + e.getMessage()
                );
            }
        }

        test.remove();
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        long executionTime =
                result.getEndMillis() - result.getStartMillis();

        test.get().skip("Test Skipped");

        test.get().info("Execution Time: " + executionTime + " ms");

        test.remove();
    }

    public static void logStep(String message) {
        test.get().info(message);
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    // Flush report only after the complete suite finishes
   @Override
public void onFinish(ISuite suite) {

    int passed = 0;
    int failed = 0;
    int skipped = 0;

    for (Map.Entry<String, ISuiteResult> entry
            : suite.getResults().entrySet()) {

        ITestContext context = entry.getValue().getTestContext();

        passed += context.getPassedTests().size();
        failed += context.getFailedTests().size();
        skipped += context.getSkippedTests().size();
    }

    int total = passed + failed + skipped;

    extent.setSystemInfo("Suite Name", suite.getName());
    extent.setSystemInfo("Total Test Invocations", String.valueOf(total));
    extent.setSystemInfo("Passed Tests", String.valueOf(passed));
    extent.setSystemInfo("Failed Tests", String.valueOf(failed));
    extent.setSystemInfo("Skipped Tests", String.valueOf(skipped));

    extent.flush();
}
}
