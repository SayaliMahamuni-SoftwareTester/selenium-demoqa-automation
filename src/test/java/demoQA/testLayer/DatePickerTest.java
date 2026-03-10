package demoQA.testLayer;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import demoQA.baseLayer.BaseTest;
import demoQA.baseLayer.DriverManager;
import demoQA.pageLayer.DatePickerPage;
import demoQA.pageLayer.HomePage;
import demoQA.pageLayer.SubModulePage;
import demoQA.testData.DatePickerData;
import demoQA.utilities.TestDataProviders;

public class DatePickerTest extends BaseTest {
	
	HomePage homePage;
    SubModulePage subModulePage;
    DatePickerPage datePicker;

//    @BeforeMethod
//    public void setUpPage() {
//
//        homePage = new HomePage(DriverManager.getDriver());
//        homePage.clickOnWidgetsModule();
//
//        subModulePage = new SubModulePage(DriverManager.getDriver());
//        subModulePage.clickOnDatePickerModule();
//
//        datePicker = new DatePickerPage(DriverManager.getDriver());
//        datePicker.waitForWidgetsPage();
//    }
    
    public DatePickerPage navigateToDatePicker() {
    	WebDriver driver = DriverManager.getDriver();

        HomePage homePage = new HomePage(driver);
        homePage.clickOnWidgetsModule();

        SubModulePage subModulePage = new SubModulePage(driver);
        subModulePage.clickOnDatePickerModule();

        DatePickerPage datePickerPage = new DatePickerPage(driver);
        datePickerPage.waitForWidgetsPage();

        return datePickerPage;
    }

    @Test(description = "TC_010_Date_Picker", dataProvider = "datePickerData", dataProviderClass = TestDataProviders.class)
    public void verifyDatePicker(DatePickerData data) {
    	navigateToDatePicker();

    	DatePickerPage datePickerPage = new DatePickerPage(DriverManager.getDriver());

        System.out.println("Running Test: " + data.getTestId());

        String actualDate = datePickerPage.selectDateFromCalendar(
                data.getMonth(),
                data.getYear(),
                data.getDay()
        );

        System.out.println("Actual Date: " + actualDate);

        if (data.isExpectValid()) {

            Assert.assertTrue(
                    actualDate.contains(data.getYear()),
                    "Year mismatch for TestId: " + data.getTestId()
            );

        } else {

            Assert.assertEquals(
                    actualDate,
                    "INVALID_DAY",
                    "Invalid date should not be selectable. TestId: " + data.getTestId()
            );
        }
    }
}
