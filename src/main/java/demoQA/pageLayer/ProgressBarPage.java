package demoQA.pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProgressBarPage extends BasePage {

    // ---------------- LOCATORS ----------------

    @FindBy(xpath = "//div[@role='progressbar']")
    private WebElement progressBar;

    @FindBy(xpath = "//button[text()='Start']")
    private WebElement startButton;

    @FindBy(xpath = "//button[text()='Stop']")
    private WebElement stopButton;
    
    @FindBy(xpath = "//button[text()='Reset']")
    private WebElement resetButton;

    private By progressBarBy = By.xpath("//div[@id='progressBar']");

    // ---------------- CONSTRUCTOR ----------------

    public ProgressBarPage(WebDriver driver) {
        super(driver);
    }

    // ---------------- PAGE LOAD ----------------

    public void waitForProgressBarPage() {
        waitUtils.waitForVisibility(By.xpath("//div[@id='progressBar']"));
    }

    // ---------------- BUSINESS METHODS ----------------

    public void startProgress() {
        scrollUtils.scrollToElement(startButton);
//        jsUtils.clickByJS(driver, startButton);
        clickUtils.safeClick(startButton);
    }

    public void stopProgress() {
//        jsUtils.clickByJS(driver, stopButton);
    	clickUtils.safeClick(stopButton);
    }

    public void startProgressAndWaitForCompletion() {
        startProgress();

        waitUtils.waitUntilAttributeEquals(progressBar, "aria-valuenow", "100");

        // EXTRA SAFETY WAIT
        waitUtils.waitForVisibility(By.xpath("//button[text()='Reset']"));
    }


    public void stopProgressMidway() {
        startProgress();
        waitUtils.waitUntilAttributeNotEquals(progressBar, "aria-valuenow", "0");
        stopProgress();
    }

    public void resetProgress() {
        stopProgress();
    }
    
    public void clickResetButton() {

    	waitUtils.waitForVisibility(By.xpath("//button[text()='Reset']"));
        waitUtils.waitForClickable(By.xpath("//button[text()='Reset']"));

//        jsUtils.clickByJS(driver, resetButton);
        clickUtils.safeClick(resetButton);

        // Wait until progress becomes 0 again
        waitUtils.waitUntilAttributeEquals(progressBar, "aria-valuenow", "0");
    }


    // ---------------- VERIFICATIONS ----------------

    public boolean isProgressCompleted() {
        return progressBar.getAttribute("aria-valuenow").equals("100");
    }

    public boolean isProgressReset() {
        return progressBar.getAttribute("aria-valuenow").equals("0");
    }

    public boolean isStartButtonVisible() {
        return startButton.isDisplayed();
    }

    public String getProgressBarColor() {
        return progressBar.getCssValue("background-color");
    }
}
