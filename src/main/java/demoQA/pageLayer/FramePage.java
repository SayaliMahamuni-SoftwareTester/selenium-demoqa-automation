package demoQA.pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import demoQA.utilities.ScrollUtils;
import demoQA.utilities.WaitUtils;

public class FramePage extends BasePage{

    // Frame locators
    private By frame1 = By.id("frame1");
    private By childFrame = By.xpath("//iframe[contains(@srcdoc,'Child')]");

    private By parentText = By.tagName("body");
    private By childText = By.tagName("p");

    public FramePage(WebDriver driver) {
    	super(driver);
    }

    public void waitForFramePage() {
        waitUtils.waitForVisibility(frame1);
    }

    public String getParentFrameText() {
        scrollUtils.scrollToElementCenter(driver.findElement(frame1));
        waitUtils.waitForFrameAndSwitch(frame1);
        waitUtils.waitForPresence(parentText);
        String text = driver.findElement(parentText).getText();
        driver.switchTo().defaultContent();
        return text;
    }
    public String getChildFrameText() {
        scrollUtils.scrollToElementCenter(driver.findElement(frame1));
        // Switch to parent frame safely
        waitUtils.waitForFrameAndSwitch(frame1);
        // Switch to child frame safely
        waitUtils.waitForFrameAndSwitch(childFrame);
        waitUtils.waitForPresence(childText);
        String text = driver.findElement(childText).getText();
        driver.switchTo().defaultContent();
        return text;
    }
}
