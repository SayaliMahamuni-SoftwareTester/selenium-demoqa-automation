package demoQA.testLayer;

import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import demoQA.baseLayer.BaseTest;
import demoQA.baseLayer.DriverManager;
import demoQA.pageLayer.FramePage;
import demoQA.pageLayer.HomePage;
import demoQA.pageLayer.SubModulePage;
public class FrameTest extends BaseTest{
	
	HomePage homePage;
    SubModulePage subModulePage;  
    FramePage framePage; 
    
//    @BeforeMethod
//    public void setUpPage() {
//        homePage = new HomePage(DriverManager.getDriver());
//        homePage.clickOnAlertFormModule();
//        subModulePage = new SubModulePage(DriverManager.getDriver());
//        subModulePage.clickOnFrameModule();
//        framePage = new FramePage(DriverManager.getDriver());
//        framePage.waitForFramePage();       
//    }
    
    public FramePage navigateToFrame() {
    	WebDriver driver = DriverManager.getDriver();

        HomePage homePage = new HomePage(driver);
        homePage.clickOnAlertFormModule();

        SubModulePage subModulePage = new SubModulePage(driver);
        subModulePage.clickOnFrameModule();

        FramePage framePage = new FramePage(driver);
        framePage.waitForFramePage();

        return framePage;
    }
    
    
        @Test(description = "TC_006_Parent_Frame_Content")
        public void verifyParentFrameContent() {
        	framePage = navigateToFrame();
        	String parentFrameText = framePage.getParentFrameText();
        	Assert.assertTrue(parentFrameText.contains("Parent frame"), "Parent frame text not found!");
        }        
        @Test(description = "TC_007_Child_Frame_Content")
        public void verifyChildFrameContent() {
        	framePage = navigateToFrame();
        	String childFrameText = framePage.getChildFrameText();
        	Assert.assertTrue(childFrameText.contains("Child Iframe"), "Child frame text not found!");
        }     
        @Test(description = "TC_008_Switch_Back_To_Default__Content")
        public void verifySwitchBackToDefaultContent() {
        	framePage = navigateToFrame();
            framePage.getParentFrameText();
            String pageTitle = DriverManager.getDriver().getTitle();
            Assert.assertTrue(pageTitle.contains("DEMOQA"));
        }
        @Test(description = "TC_009_Invalid_Frame_Handling")
        public void verifyInvalidFrameHandling() {
        	framePage = navigateToFrame();
            Assert.assertThrows(NoSuchFrameException.class, () -> {
            	DriverManager.getDriver().switchTo().frame("invalidFrame");
            });
        }
}
