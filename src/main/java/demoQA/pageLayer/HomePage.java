package demoQA.pageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "(//div[@class='card-up'])[1]")
    private WebElement elements;

    @FindBy(xpath = "(//div[@class='card-up'])[2]")
    private WebElement forms;

    @FindBy(xpath = "(//div[@class='card-up'])[3]")
    private WebElement alertFrameWindows;
    
    @FindBy(xpath = "(//div[@class='card-up'])[4]")
    private WebElement widgets;

    public HomePage(WebDriver driver) {
    	super(driver);
    }

    public void clickOnElementsModule() {
    	waitUtils.waitForVisibility(elements);
        scrollUtils.scrollToElementCenter(elements);
        clickUtils.safeClick(elements);
    }

    public void clickOnFormsModule() {
    	waitUtils.waitForVisibility(forms);
        scrollUtils.scrollToElementCenter(forms);
        clickUtils.safeClick(forms);
    }

    public void clickOnAlertFormModule() {
    	waitUtils.waitForVisibility(alertFrameWindows);
        scrollUtils.scrollToElementCenter(alertFrameWindows);
        clickUtils.safeClick(alertFrameWindows);
    }

	public void clickOnWidgetsModule() {
		waitUtils.waitForVisibility(widgets);
		scrollUtils.scrollToElementCenter(widgets);
		clickUtils.safeClick(widgets);
	}
}
