package demoQA.pageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import demoQA.utilities.ClickUtils;
import demoQA.utilities.DropdownUtils;
import demoQA.utilities.JSUtils;
import demoQA.utilities.ScrollUtils;
import demoQA.utilities.WaitUtils;

public class BasePage {

    protected WebDriver driver;
    protected WaitUtils waitUtils;
    protected ScrollUtils scrollUtils;
    protected JSUtils jsUtils;
    protected DropdownUtils dropdownUtils;
    protected ClickUtils clickUtils;

    public BasePage(WebDriver driver) {
        this.driver = driver;

        // Initialize PageFactory
        PageFactory.initElements(driver, this);
        
        PageFactory.initElements(driver, this);
        // Initialize utilities using the same driver instance
        this.waitUtils = new WaitUtils(driver);
        this.scrollUtils = new ScrollUtils(driver);
        this.jsUtils = new JSUtils();           // static methods ok
        this.dropdownUtils = new DropdownUtils(); // static methods or instance ok
        this.clickUtils = new ClickUtils(driver);
    }
}
