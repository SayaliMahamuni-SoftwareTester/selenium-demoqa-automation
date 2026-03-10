package demoQA.pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demoQA.utilities.JSUtils;
import demoQA.utilities.ScrollUtils;
import demoQA.utilities.WaitUtils;

public class PracticeFormPage extends BasePage{

    public PracticeFormPage(WebDriver driver) {
    	super(driver);
    }

    // ========== Locators ==========

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "userEmail")
    private WebElement email;

    // Radio Button (label click)
    @FindBy(xpath = "//label[text()='Female']")
    private WebElement femaleGenderRadio;

    @FindBy(id = "userNumber")
    private WebElement mobile;

    @FindBy(id = "subjectsInput")
    private WebElement subjects;

    // Checkbox (label click)
    @FindBy(xpath = "//label[text()='Music']")
    private WebElement musicHobbyCheckbox;

    @FindBy(id = "uploadPicture")
    private WebElement uploadPicture;

    @FindBy(id = "currentAddress")
    private WebElement currentAddress;

    @FindBy(id = "state")
    private WebElement state;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "submit")
    private WebElement submitBtn;

    // ========== Page Load ==========

    public void waitForPracticeFormPage() {
        
        waitUtils.waitForVisibility(By.id("firstName"));
    }

    // ========== Actions ==========

    public void fillForm(
            String fName,
            String lName,
            String emailValue,
            String mobileValue,
            String subjectValue,
            String filePath,
            String address,
            String stateValue,
            String cityValue) {

        firstName.clear();
        firstName.sendKeys(fName);

        lastName.clear();
        lastName.sendKeys(lName);

        email.clear();
        email.sendKeys(emailValue);

        // ✅ Select Gender (Radio Button)
        scrollUtils.scrollToElementCenter(femaleGenderRadio);
        //JSUtils.clickByJS(driver, femaleGenderRadio);
        clickUtils.safeClick(femaleGenderRadio);

        mobile.clear();
        mobile.sendKeys(mobileValue);

        subjects.sendKeys(subjectValue);
        subjects.sendKeys("\n");

        // ✅ Select Hobby (Checkbox)
        scrollUtils.scrollToElementCenter(musicHobbyCheckbox);
//        JSUtils.clickByJS(driver, musicHobbyCheckbox);
        clickUtils.safeClick(musicHobbyCheckbox);

        uploadPicture.sendKeys(filePath);

        currentAddress.clear();
        currentAddress.sendKeys(address);

        scrollUtils.scrollToElementCenter(state);
        state.click();
        driver.findElement(By.xpath("//div[text()='" + stateValue + "']")).click();

        city.click();
        driver.findElement(By.xpath("//div[text()='" + cityValue + "']")).click();
    }

    public void submitForm() {
        scrollUtils.scrollToElementCenter(submitBtn);
//        JSUtils.clickByJS(driver, submitBtn);
        clickUtils.safeClick(submitBtn);
    }

    // ========== Assertions ==========

    /**
     * For VALID scenarios → modal should appear
     */
    public boolean isSuccessModalDisplayed() {
        try {
            return waitUtils.waitForVisibility(By.id("example-modal-sizes-title-lg")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * For INVALID scenarios → form should stay on same page
     */
    public boolean isStillOnFormPage() {
        return driver.getCurrentUrl().contains("automation-practice-form");
    }
}
