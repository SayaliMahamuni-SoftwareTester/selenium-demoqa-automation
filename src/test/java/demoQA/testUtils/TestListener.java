package demoQA.testUtils;

import demoQA.baseLayer.DriverManager;
import demoQA.utilities.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.testng.*;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("STARTED: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("PASSED: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("FAILED: " + result.getMethod().getMethodName());
        System.out.println("Reason: " + result.getThrowable());

        // Get driver for the current thread
        WebDriver driver = DriverManager.getDriver();

        if (driver != null) {
            try {
                String path = ScreenshotUtils.captureScreenshot(
                        driver,
                        result.getMethod().getMethodName()
                );
                System.out.println("Screenshot saved at: " + path);
            } catch (Exception e) {
                System.err.println("Screenshot capture failed: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.err.println("Driver is null. Screenshot not taken.");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("SKIPPED: " + result.getMethod().getMethodName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("===== SUITE STARTED =====");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("===== SUITE FINISHED =====");
    }
}
