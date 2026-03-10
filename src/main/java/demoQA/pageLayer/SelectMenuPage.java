package demoQA.pageLayer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectMenuPage extends BasePage {

    @FindBy(id = "withOptGroup")
    private WebElement selectValueContainer;

    @FindBy(id = "react-select-2-input")
    private WebElement selectValueInput;

    @FindBy(id = "selectOne")
    private WebElement selectOneContainer;

    @FindBy(id = "react-select-3-input")
    private WebElement selectOneInput;

    @FindBy(id = "oldSelectMenu")
    private WebElement oldStyleSelect;

    @FindBy(id = "react-select-4-input")
    private WebElement multiSelectInput;

    @FindBy(id = "cars")
    private WebElement standardMultiSelect;

    private By selectValueBy = By.id("react-select-2-input");

    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    public void waitForSelectMenuPage() {
        waitUtils.waitForVisibility(selectValueBy);
    }

    public void selectValue(String value) {
        scrollUtils.scrollToElement(selectValueContainer);
//        jsUtils.clickByJS(driver, selectValueContainer);
        clickUtils.safeClick(selectValueContainer);
        waitUtils.waitForVisibility(By.id("react-select-2-input"));
        selectValueInput.sendKeys(value);
        selectValueInput.sendKeys(Keys.ENTER);
    }

    public void selectOne(String value) {
        scrollUtils.scrollToElement(selectOneContainer);
//        jsUtils.clickByJS(driver, selectOneContainer);
        clickUtils.safeClick(selectOneContainer);
        waitUtils.waitForVisibility(By.id("react-select-3-input"));
        selectOneInput.sendKeys(value);
        selectOneInput.sendKeys(Keys.ENTER);
    }

    public void selectOldStyle(String value) {
        scrollUtils.scrollToElement(oldStyleSelect);
        dropdownUtils.selectByVisibleText(oldStyleSelect, value);
    }

    public void selectMultiValues(List<String> values) {
        for (String value : values) {
            scrollUtils.scrollToElement(multiSelectInput);
            multiSelectInput.sendKeys(value);
            multiSelectInput.sendKeys(Keys.ENTER);
        }
    }

    public void selectCars(List<String> cars) {
        scrollUtils.scrollToElement(standardMultiSelect);
        dropdownUtils.selectMultipleByVisibleText(standardMultiSelect, cars);
    }

    public String getSelectedValueText() {
        return selectValueContainer.getText();
    }
}
