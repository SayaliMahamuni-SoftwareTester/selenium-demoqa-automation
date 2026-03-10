package demoQA.testLayer;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import demoQA.baseLayer.BaseTest;
import demoQA.baseLayer.DriverManager;
import demoQA.pageLayer.HomePage;
import demoQA.pageLayer.SelectMenuPage;
import demoQA.pageLayer.SubModulePage;
import demoQA.testData.SelectMenuData;
import demoQA.utilities.TestDataProviders;

public class SelectMenuTest extends BaseTest {

	HomePage homePage;
    SubModulePage subModulePage;
    SelectMenuPage selectMenuPage;

//    @BeforeMethod
//    public void setUpPage() {
//
//        homePage = new HomePage(DriverManager.getDriver());
//        homePage.clickOnWidgetsModule();
//
//        subModulePage = new SubModulePage(DriverManager.getDriver());
//        subModulePage.clickOnSelectMenuModule();
//
//        selectMenuPage = new SelectMenuPage(DriverManager.getDriver());
//        selectMenuPage.waitForSelectMenuPage();
//    }
    
    public SelectMenuPage navigateToSelectMenu() {
    	WebDriver driver = DriverManager.getDriver();

        HomePage homePage = new HomePage(driver);
        homePage.clickOnWidgetsModule();

        SubModulePage subModulePage = new SubModulePage(driver);
        subModulePage.clickOnSelectMenuModule();

        SelectMenuPage selectMenuPage = new SelectMenuPage(driver);
        selectMenuPage.waitForSelectMenuPage();

        return selectMenuPage;
    }

    @Test(description = "TC_014_Select_Menu_Functionality", dataProvider = "selectMenuData",dataProviderClass = TestDataProviders.class)
    	public void verifySelectMenuFunctionality(SelectMenuData data) {
    	
    	navigateToSelectMenu();

    	    selectMenuPage.selectValue(data.getSelectValue());
    	    selectMenuPage.selectOne(data.getSelectOne());
    	    selectMenuPage.selectOldStyle(data.getOldStyle());
    	    selectMenuPage.selectMultiValues(data.getMultiSelect());
    	    selectMenuPage.selectCars(data.getCars());

    	    Assert.assertTrue(
    	            selectMenuPage.getSelectedValueText()
    	                    .contains(data.getSelectValue().split(",")[0]),
    	            "Select Value dropdown failed"
    	    );
    	}

}
