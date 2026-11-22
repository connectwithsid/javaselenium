
package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getExtentReports() {

        if (extent == null) {

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter("test-output/ExtentReport.html");

            sparkReporter.config().setDocumentTitle("Automation Test Report");
            sparkReporter.config().setReportName("OpenCart Automation Test Results");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            ConfigReader config = new ConfigReader();

            extent.setSystemInfo("Project Name", "OpenCart");
            extent.setSystemInfo("Automation Tool", "Selenium WebDriver");
            extent.setSystemInfo("Testing Framework", "TestNG");
            extent.setSystemInfo("Browser", config.getBrowser());
            extent.setSystemInfo("Operating System", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("Tester", "QA Engineer");

        }

        return extent;
    }
}
