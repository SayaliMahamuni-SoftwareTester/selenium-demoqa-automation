package demoQA.baseLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final ThreadLocal<String> browserName = new ThreadLocal<>();

    private DriverManager() {}

    public static void initDriver(String browser) {

        if (browser == null || browser.trim().isEmpty()) {
            browser = "chrome";
        }

        browserName.set(browser.toLowerCase());

        switch (browser.toLowerCase()) {

            case "chrome":
                driver.set(new ChromeDriver());
                break;

            case "firefox":
                driver.set(new FirefoxDriver());
                break;

            case "edge":
                driver.set(new EdgeDriver());
                break;

            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }
    }

    // 🔥 DO NOT THROW EXCEPTION HERE
    public static WebDriver getDriver() {
        return driver.get();   // can return null safely
    }

    public static String getBrowserName() {
        return browserName.get();
    }

    public static void quitDriver() {

        WebDriver currentDriver = driver.get();

        if (currentDriver != null) {
            try {
                currentDriver.quit();
            } catch (Exception e) {
                System.out.println("Driver already closed.");
            }
        }

        driver.remove();
        browserName.remove();
    }
}
