package demoQA.testLayer;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import demoQA.baseLayer.BaseTest;
import demoQA.baseLayer.DriverManager;
import demoQA.pageLayer.HomePage;
import demoQA.pageLayer.SubModulePage;

public class HomeTest extends BaseTest {

	private HomePage homePage;
    private SubModulePage subModulePage;


    @BeforeMethod
    public void initPages() {
        homePage = new HomePage(DriverManager.getDriver());
        subModulePage = new SubModulePage(DriverManager.getDriver());
    }

//    public void navigateToModules() {
//    	homePage = new HomePage(DriverManager.getDriver());
//        subModulePage = new SubModulePage(DriverManager.getDriver());
//    }

    @Test
    public void verifyTextBoxModuleNavigation() {
    	
        homePage.clickOnElementsModule();
        subModulePage.clickOnTextBoxModule();
    }

    @Test
    public void verifyFormModuleNavigation() {
    	
        homePage.clickOnFormsModule();
        subModulePage.clickOnPracticeFormModule();
    }

    @Test
    public void verifyAlertModuleNavigation() {
    	
        homePage.clickOnAlertFormModule();
        subModulePage.clickOnAlertModule();
    }

    @Test
    public void verifyWidgetModule1() {
    	
        homePage.clickOnWidgetsModule();
        subModulePage.clickOnDatePickerModule();
    }

    @Test
    public void verifyWidgetModule2() {
       
        homePage.clickOnWidgetsModule();
        subModulePage.clickOnProgressBarModule();
    }
}
