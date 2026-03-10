package demoQA.testLayer;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import demoQA.baseLayer.BaseTest;
import demoQA.baseLayer.DriverManager;
import demoQA.pageLayer.AlertPage;
import demoQA.pageLayer.HomePage;
import demoQA.pageLayer.SubModulePage;
import demoQA.testData.AlertPageData;
import demoQA.utilities.TestDataProviders;

public class AlertTest extends BaseTest {

	HomePage homePage;
    SubModulePage subModulePage;
    AlertPage alertPage;

    
//    @BeforeMethod
//    public void setUpPage() {
//
//    	
//        homePage = new HomePage(DriverManager.getDriver());
//        homePage.clickOnAlertFormModule();
//
//        subModulePage = new SubModulePage(DriverManager.getDriver());
//        subModulePage.clickOnAlertModule();
//
//        alertPage = new AlertPage(DriverManager.getDriver());
//        alertPage.waitForAlertPage();
//    }
    
    public AlertPage navigateToAlerts() {
    	
        	WebDriver driver = DriverManager.getDriver();

            HomePage homePage = new HomePage(driver);
            homePage.clickOnAlertFormModule();

            SubModulePage subModulePage = new SubModulePage(driver);
            subModulePage.clickOnAlertModule();

            AlertPage alertPage = new AlertPage(driver);
            alertPage.waitForAlertPage();

            return alertPage;
    }
    
    @Test(description = "TC_002_Simple_Alert")
    public void verifySimpleAlert() {
    	alertPage = navigateToAlerts();
        alertPage.handleSimpleAlert();
    }

    @Test(description = "TC_003_Timer_Alert")
    public void verifyTimerAlert() {
    	alertPage = navigateToAlerts();
        alertPage.handleTimerAlert();
    }

    @Test(description = "TC_004_Confirm_Alert", dataProvider = "alertData", dataProviderClass = TestDataProviders.class)
    public void verifyConfirmAlert(AlertPageData data) {
    	alertPage = navigateToAlerts();

        if (data.alertType.equalsIgnoreCase("CONFIRM")) {
            alertPage.handleConfirmAlert(data.action);
        }
    }


    @Test(description = "TC_005_Prompt_Alert", dataProvider = "alertData", dataProviderClass = TestDataProviders.class)
    public void verifyPromptAlert(AlertPageData data) {
    	alertPage = navigateToAlerts();

        if (data.alertType.equalsIgnoreCase("PROMPT")) {

            alertPage.handlePromptAlert(data.inputText, data.action);

            // Case 1: DISMISS or EMPTY input → Result should NOT appear
            if (data.action.equalsIgnoreCase("DISMISS") 
                    || data.inputText == null 
                    || data.inputText.isEmpty()) {

                Assert.assertFalse(alertPage.isPromptResultDisplayed(),
                        "Prompt result should NOT be displayed.");

            } 
            // Case 2: ACCEPT with valid input → Result should appear
            else {

                Assert.assertTrue(alertPage.isPromptResultDisplayed(),
                        "Prompt result should be displayed.");

                Assert.assertEquals(alertPage.getPromptResult(), data.expectedResult);
            }
        }
    }

}