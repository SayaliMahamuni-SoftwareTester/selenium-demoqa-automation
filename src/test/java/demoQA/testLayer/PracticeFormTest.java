package demoQA.testLayer;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import demoQA.baseLayer.BaseTest;
import demoQA.baseLayer.DriverManager;
import demoQA.pageLayer.HomePage;
import demoQA.pageLayer.PracticeFormPage;
import demoQA.pageLayer.SubModulePage;
import demoQA.testData.PracticeFormData;

public class PracticeFormTest extends BaseTest {

    HomePage homePage;
    SubModulePage subModulePage;
    PracticeFormPage practiceFormPage;

//    @BeforeMethod
//    public void setUpPage() {
//
//        homePage = new HomePage(DriverManager.getDriver());
//        homePage.clickOnFormsModule();
//
//        subModulePage = new SubModulePage(DriverManager.getDriver());
//        subModulePage.clickOnPracticeFormModule();
//
//        practiceFormPage = new PracticeFormPage(DriverManager.getDriver());
//        practiceFormPage.waitForPracticeFormPage(); // ⭐ CRITICAL
//    }
    
    public PracticeFormPage navigateToPracticeForm() {
    	WebDriver driver = DriverManager.getDriver();

        HomePage homePage = new HomePage(driver);
        homePage.clickOnFormsModule();

        SubModulePage subModulePage = new SubModulePage(driver);
        subModulePage.clickOnPracticeFormModule();

        PracticeFormPage practiceFormPage = new PracticeFormPage(driver);
        practiceFormPage.waitForPracticeFormPage();

        return practiceFormPage;
    }

    @Test(description = "TC_016_Practice_Form", dataProvider = "practiceFormData",dataProviderClass = demoQA.utilities.TestDataProviders.class)
    public void runPracticeFormTests(PracticeFormData data) {
    	practiceFormPage = navigateToPracticeForm();

        practiceFormPage.fillForm(
                data.firstName,
                data.lastName,
                data.email,
                data.mobile,
                data.subject,
                data.filePath,
                data.currentAddress,
                data.state,
                data.city
        );

        practiceFormPage.submitForm();

        // ===== Assertions =====

        if (data.expectSuccess) {

            Assert.assertTrue(
                    practiceFormPage.isSuccessModalDisplayed(),
                    "Expected success modal but not displayed. TestId: " + data.testId
            );

        } else {

            Assert.assertFalse(
                    practiceFormPage.isSuccessModalDisplayed(),
                    "Success modal SHOULD NOT appear for invalid data. TestId: " + data.testId
            );

            Assert.assertTrue(
                    practiceFormPage.isStillOnFormPage(),
                    "User should remain on form page for invalid data. TestId: " + data.testId
            );
        }
    }
}
