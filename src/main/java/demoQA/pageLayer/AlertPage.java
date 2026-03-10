package demoQA.pageLayer;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demoQA.utilities.JSUtils;
import demoQA.utilities.ScrollUtils;
import demoQA.utilities.WaitUtils;

public class AlertPage extends BasePage{

    private Alert alt;

    // ========== Locators ==========

    @FindBy(id = "alertButton")
    private WebElement simpleAlertButton;

    @FindBy(id = "timerAlertButton")
    private WebElement timerAlertButton;

    @FindBy(id = "confirmButton")
    private WebElement confirmButton;

    @FindBy(id = "promtButton")
    private WebElement promptButton;

    @FindBy(id = "confirmResult")
    private WebElement confirmResult;

    @FindBy(xpath="//span[@id='promptResult']")
    private WebElement promptResult;

    // ========== Constructor ==========

    public AlertPage(WebDriver driver) {
    	super(driver);
    }
    
 // ========== Page Load ==========

    public void waitForAlertPage() {
        waitUtils.waitForVisibility(By.id("promtButton"));
    }

 // SIMPLE ALERT
    public void handleSimpleAlert() {
    	scrollUtils.scrollToElementCenter(simpleAlertButton);
//        JSUtils.clickByJS(driver, simpleAlertButton);
    	clickUtils.safeClick(simpleAlertButton);

        waitUtils.waitForAlert();
        driver.switchTo().alert().accept();
    }

    // TIMER ALERT
    public void handleTimerAlert() {
    	scrollUtils.scrollToElementCenter(timerAlertButton);
//        JSUtils.clickByJS(driver, timerAlertButton);
        clickUtils.safeClick(timerAlertButton);
        waitUtils.waitForAlert();
        driver.switchTo().alert().accept();
    }

    // CONFIRM ALERT
    public void handleConfirmAlert(String action) {
    	scrollUtils.scrollToElementCenter(confirmButton);
//        JSUtils.clickByJS(driver, confirmButton);
    	clickUtils.safeClick(confirmButton);
        waitUtils.waitForAlert();

        if(action.equalsIgnoreCase("ok")) {
            driver.switchTo().alert().accept();
        } else {
            driver.switchTo().alert().dismiss();
        }
    }

    public void handlePromptAlert(String inputText, String action) {

        scrollUtils.scrollToElementCenter(promptButton);
//        JSUtils.clickByJS(driver, promptButton);
        clickUtils.safeClick(promptButton);

        waitUtils.waitForAlert();
        Alert alert = driver.switchTo().alert();

        if (inputText != null && !inputText.isEmpty()) {
            alert.sendKeys(inputText);
        }

        switch (action.toUpperCase()) {
            case "ACCEPT":
                alert.accept();
                break;
            case "DISMISS":
                alert.dismiss();
                break;
            default:
                throw new IllegalArgumentException("Invalid action: " + action);
        }
    }

    public String getPromptResult() {

        if (promptResult.isDisplayed()) {
            return promptResult.getText();
        }
        return "";
    }
    
    public boolean isPromptResultDisplayed() {
        try {
            return promptResult.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


}