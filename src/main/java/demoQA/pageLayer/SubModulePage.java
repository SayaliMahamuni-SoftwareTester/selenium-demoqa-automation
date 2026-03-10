package demoQA.pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demoQA.utilities.ScrollUtils;

public class SubModulePage extends BasePage{

    @FindBy(xpath = "(//li[@id='item-0'])[1]")
    private WebElement textBox;

    @FindBy(xpath = "//span[text()='Practice Form']")
    private WebElement practiceForm;
    
    @FindBy(xpath = "//span[text()='Alerts']")
    private WebElement alertMenu;
    
    @FindBy(xpath = "(//li[@id='item-3'])[2]")
    private WebElement frameMenu;
    
    @FindBy(xpath = "(//li[@id='item-2'])[3]")
    private WebElement datePicker;
    
    @FindBy(xpath = "//span[text()='Progress Bar']")
    private WebElement progressBar;
    
    @FindBy(xpath = "(//li[@id='item-8'])[2]")
    private WebElement selectMenu;
    
    @FindBy(xpath = "(//li[@id='item-7'])[1]")
    private WebElement uploadDownloadMenu;

    public SubModulePage(WebDriver driver) {
    	super(driver);
    	
    }

//    private void init() {
//        PageFactory.initElements(driver, this);
//    }

    public void clickOnTextBoxModule() {
       // init();
    	waitUtils.waitForVisibility(textBox);
        scrollUtils.scrollToElementCenter(textBox);
        clickUtils.safeClick(textBox);
    }

    public void clickOnPracticeFormModule() {
       // init();
    	waitUtils.waitForVisibility(practiceForm);
        scrollUtils.scrollToElementCenter(practiceForm);
        clickUtils.safeClick(practiceForm);
    }
    
    public void clickOnAlertModule() {
       // init();
    	waitUtils.waitForVisibility(alertMenu);
        scrollUtils.scrollToElementCenter(alertMenu);
        clickUtils.safeClick(alertMenu);
       
    }
    
    public void clickOnFrameModule() {
    	waitUtils.waitForVisibility(frameMenu);
        scrollUtils.scrollToElementCenter(frameMenu);
        clickUtils.safeClick(frameMenu);
    }

	public void clickOnDatePickerModule() {
		waitUtils.waitForVisibility(datePicker);
        scrollUtils.scrollToElementCenter(datePicker);
        clickUtils.safeClick(datePicker);
	}
	
	public void clickOnProgressBarModule() {
		waitUtils.waitForVisibility(progressBar);
        scrollUtils.scrollToElementCenter(progressBar);
        clickUtils.safeClick(progressBar);
	}

	public void clickOnSelectMenuModule() {
		waitUtils.waitForVisibility(selectMenu);
        scrollUtils.scrollToElementCenter(selectMenu);
        clickUtils.safeClick(selectMenu);
		
	}
	
	public void clickOnUploadDownloadMenuModule() {
		waitUtils.waitForVisibility(uploadDownloadMenu);
        scrollUtils.scrollToElementCenter(uploadDownloadMenu);
        clickUtils.safeClick(uploadDownloadMenu);
		
	}

	public WebElement getAlertModuleElement() {
	    return alertMenu;  // your @FindBy element
	}
}
