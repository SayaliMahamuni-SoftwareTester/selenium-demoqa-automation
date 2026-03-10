package demoQA.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ClickUtils {

    private WebDriver driver;
    private WebDriverWait wait;

    public ClickUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void safeClick(WebElement element) {
        try {
            // Wait until clickable
            wait.until(ExpectedConditions.elementToBeClickable(element));

            // Scroll element into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

            try {
                element.click(); // Try normal click
            } catch (ElementClickInterceptedException e) {
                // If blocked, hide common overlays and retry
                hideStickyBanners();
                try {
                    element.click(); // Try again
                } catch (ElementClickInterceptedException ex) {
                    // As last resort, click with JS
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                }
            }
        } catch (TimeoutException te) {
            throw new RuntimeException("Element not clickable: " + element, te);
        }
    }

    private void hideStickyBanners() {
        try {
            ((JavascriptExecutor) driver)
                    .executeScript("let el = document.getElementById('fixedban'); if(el) el.style.display='none';");
        } catch (Exception e) {
            // ignore if banner not found
        }
    }
}
