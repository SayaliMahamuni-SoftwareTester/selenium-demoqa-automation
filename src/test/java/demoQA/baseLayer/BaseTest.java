package demoQA.baseLayer;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import demoQA.utilities.ExtentManager;
import demoQA.utilities.ScreenshotUtils;

public class BaseTest {

    protected static ExtentReports extent;
    protected static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    // ===============================
    // Load Config + Initialize Report
    // ===============================
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        ConfigReader.loadConfig();
        extent = ExtentManager.getInstance();
    }

    // ===============================
    // Setup Before Each Test
    // ===============================
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method, ITestContext context) {

        // Create Extent Test
        test.set(extent.createTest(method.getName()));

        // Determine browser (Priority: JVM > testng.xml > config > default)
        String browser = System.getProperty("browser");

        if (browser == null || browser.trim().isEmpty()) {
            browser = context.getCurrentXmlTest().getParameter("browser");
        }

        if (browser == null || browser.trim().isEmpty()) {
            browser = ConfigReader.getProperty("browser");
        }

        if (browser == null || browser.trim().isEmpty()) {
            browser = "chrome";
        }

        // Initialize Driver
        DriverManager.initDriver(browser);
        WebDriver driver = DriverManager.getDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        // Get URL
        String url = System.getProperty("url");
        if (url == null || url.trim().isEmpty()) {
            url = ConfigReader.getProperty("url");
        }

        if (url == null || url.trim().isEmpty()) {
            throw new RuntimeException("URL not provided.");
        }

        driver.get(url);

        // Wait for page load complete
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(d -> ((JavascriptExecutor) d)
                        .executeScript("return document.readyState")
                        .equals("complete"));
    }

    // ===============================
    // Tear Down After Each Test
    // ===============================
    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {

        WebDriver driver = DriverManager.getDriver();

        try {

            String screenshotPath = ScreenshotUtils.captureScreenshot(
                    driver,
                    result.getName()
            );

            if (result.getStatus() == ITestResult.FAILURE) {

                test.get()
                        .fail(result.getThrowable())
                        .addScreenCaptureFromPath(screenshotPath);

            } else if (result.getStatus() == ITestResult.SUCCESS) {

                test.get()
                        .pass("Test Passed")
                        .addScreenCaptureFromPath(screenshotPath);

            } else if (result.getStatus() == ITestResult.SKIP) {

                test.get()
                        .skip("Test Skipped")
                        .addScreenCaptureFromPath(screenshotPath);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DriverManager.quitDriver();
        }
    }
    // ===============================
    // Flush Report After Suite
    // ===============================
    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        if (extent != null) {
            extent.flush();
        }
    }

    // ===============================
    // Get Browser Name
    // ===============================
    public String getBrowserName() {
        return DriverManager.getBrowserName();
    }

    // ===============================
    // Get Extent Test (for logging in pages if needed)
    // ===============================
    public static ExtentTest getTest() {
        return test.get();
    }
}