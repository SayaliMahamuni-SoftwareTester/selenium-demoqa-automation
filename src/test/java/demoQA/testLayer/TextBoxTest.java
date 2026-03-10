package demoQA.testLayer;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import demoQA.baseLayer.BaseTest;
import demoQA.baseLayer.DriverManager;
import demoQA.pageLayer.HomePage;
import demoQA.pageLayer.SubModulePage;
import demoQA.pageLayer.TextBoxPage;
import demoQA.testData.TextBoxData;
import demoQA.utilities.TestDataProviders;

public class TextBoxTest extends BaseTest {

HomePage homePage;
SubModulePage subModulePage;
TextBoxPage textBoxPage;
	
//@BeforeMethod
//public void setUpPage() {
//    homePage = new HomePage(DriverManager.getDriver());
//    homePage.clickOnElementsModule();
//
//    subModulePage = new SubModulePage(DriverManager.getDriver());
//    subModulePage.clickOnTextBoxModule();
//
//    textBoxPage = new TextBoxPage(DriverManager.getDriver()); // ✅ REQUIRED
//}

public TextBoxPage navigateToTextBox() {
	WebDriver driver = DriverManager.getDriver();

    HomePage homePage = new HomePage(driver);
    homePage.clickOnElementsModule();

    SubModulePage subModulePage = new SubModulePage(driver);
    subModulePage.clickOnTextBoxModule();

    return new TextBoxPage(driver);
}
@Test(description = "TC_001_TextBox_Validation", dataProvider = "textboxData", dataProviderClass = TestDataProviders.class)
public void runTextBoxTests(TextBoxData data) {
	navigateToTextBox();
 
    textBoxPage.fillTextboxForm(
        data.username,
        data.email,
        data.currentAddress,
        data.permanentAddress
    );

    // VALID CASE
    if (data.expectRegisteredEmail != null && !data.expectRegisteredEmail.isEmpty()) {
        String actual = textBoxPage.getRegisteredEmail();
        Assert.assertEquals(actual.trim(), data.expectRegisteredEmail);
    }

    // INVALID CASE
    if (data.expectEmailFieldClass != null && !data.expectEmailFieldClass.isEmpty()) {
        String actualClass = textBoxPage.getEmailFieldClass();
        Assert.assertEquals(actualClass.trim(), data.expectEmailFieldClass);
    }
}

}