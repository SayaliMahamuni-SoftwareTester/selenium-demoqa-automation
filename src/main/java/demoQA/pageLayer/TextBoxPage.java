package demoQA.pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demoQA.utilities.JSUtils;
import demoQA.utilities.WaitUtils;

/**
 * Page object for the DemoQA Text Box page.
 *
 * Uses PageFactory for element definitions but relies on WaitUtils / JSUtils for robust interactions.
 */
public class TextBoxPage extends BasePage{

    // Locators / PageFactory elements
    @FindBy(xpath = "(//li[@id='item-0'])[1]")
    private WebElement textBoxMenu;

    @FindBy(id = "userName")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@type='email' or @id='userEmail']")
    private WebElement emailInput;

    @FindBy(id = "currentAddress")
    private WebElement addressTextarea;

    @FindBy(id = "permanentAddress")
    private WebElement permanentAddressTextarea;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(id = "email")
    private WebElement registeredEmail;

    @FindBy(id = "name")
    private WebElement registeredName;

    @FindBy(id = "currentAddress")
    private WebElement registeredCurrentAddress; // Note: on the result panel the id is the same but used as output text

    // Constructor
    public TextBoxPage(WebDriver driver) {
    	super(driver);
    }

    // Utility: scroll into view and click using JS helper
    private void jsScrollAndClick(WebElement element) {
        JSUtils.scrollIntoView(driver, element);
//        JSUtils.clickByJS(driver, element);
        clickUtils.safeClick(element);
    }

    // Click the Text Box menu (if you navigate via the left menu)
    public void clickOnTextboxMenu() {
        jsScrollAndClick(textBoxMenu);
        // wait for the username input to be visible after navigation
        waitUtils.waitForVisibility(By.id("userName"));
    }

    public void fillTextboxForm(String username, String email,
            String currentAddress, String permanentAddress) {

waitUtils.waitForVisibility(By.id("userName"));

usernameInput.clear();
usernameInput.sendKeys(username);

emailInput.clear();
emailInput.sendKeys(email);

addressTextarea.clear();
addressTextarea.sendKeys(currentAddress);

permanentAddressTextarea.clear();
permanentAddressTextarea.sendKeys(permanentAddress);

jsScrollAndClick(submitButton);
}


    // -------- Getters for assertions --------

    // Returns the displayed "Email:..." text after submit, e.g. "Email:sayali@123example.com"
    public String getRegisteredEmail() {
        // Ensure visibility before reading
        waitUtils.waitForVisibility(By.xpath("//p[@id='email']"));
        return registeredEmail.getText();
    }

    // Returns the displayed "Name:..." text after submit, e.g. "Name:Sayali Mahamuni"
    public String getRegisteredName() {
        waitUtils.waitForVisibility(By.xpath("//p[@id='name']"));
        return registeredName.getText();
    }

    // Returns the class attribute of the email input (useful to assert validation styling)
    public String getEmailFieldClass() {
        // Wait for presence/visibility of the input before reading attribute
        waitUtils.waitForVisibility(By.xpath("//input[@type='email' or @id='userEmail']"));
        // prefer getAttribute for broad compatibility
        return emailInput.getAttribute("class");
    }
}