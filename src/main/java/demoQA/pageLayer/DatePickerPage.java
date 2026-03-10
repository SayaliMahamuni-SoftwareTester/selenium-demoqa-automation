package demoQA.pageLayer;

import demoQA.utilities.JSUtils;
import demoQA.utilities.WaitUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DatePickerPage extends BasePage{
    
    @FindBy(id = "datePickerMonthYearInput")
    private WebElement dateInput;

    @FindBy(xpath="//select[@class='react-datepicker__month-select']")
    private WebElement monthDropdown;

    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    private WebElement yearDropdown;

    public DatePickerPage(WebDriver driver) {
    	super(driver);
        
    }   
    
    public void waitForWidgetsPage() {
    	waitUtils.waitForVisibility(By.id("datePickerMonthYearInput"));
		
	}

    // ===== Enterprise Calendar Method =====
    public String selectDateFromCalendar(String month, String year, String day) {

        JSUtils.scrollIntoView(driver, dateInput);
//        JSUtils.clickByJS(driver, dateInput);
        clickUtils.safeClick(dateInput);

        waitUtils.waitForVisibility(By.xpath("//select[@class='react-datepicker__month-select']"));

        // Select month
        Select monthSelect = new Select(monthDropdown);
        monthSelect.selectByVisibleText(month);

        // Select year
        Select yearSelect = new Select(yearDropdown);
        yearSelect.selectByVisibleText(year);

        // Handle invalid day safely
        try {
            WebElement dayElement = driver.findElement(
                    By.xpath("//div[contains(@class,'react-datepicker__day') " +
                            "and not(contains(@class,'outside-month')) " +
                            "and text()='" + day + "']")
            );

//            JSUtils.clickByJS(driver, dayElement);
            clickUtils.safeClick(dayElement);

        } catch (NoSuchElementException e) {
            return "INVALID_DAY";
        }

        return dateInput.getAttribute("value");
    }

	
}
