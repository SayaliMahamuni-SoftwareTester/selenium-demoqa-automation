package demoQA.pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UploadAndDownloadPage extends BasePage{

    // Constructor
    public UploadAndDownloadPage(WebDriver driver) {
        super(driver);
    }

    // Elements
    @FindBy(id = "uploadFile")
    private WebElement chooseFileBtn;

    @FindBy(id = "uploadedFilePath")
    private WebElement uploadedFilePath;

    @FindBy(linkText = "Download")
    private WebElement downloadBtn;
    
    public void waitForUploadAndDownloadPage() {
        waitUtils.waitForVisibility(By.id("downloadButton"));
    }

    // ================== Actions ==================

    public void uploadFile(String filePath) {
        waitUtils.waitForVisibility(By.id("uploadFile"));
        chooseFileBtn.sendKeys(filePath);
    }

    public String getUploadedFileName() {
        waitUtils.waitForVisibility(By.id("uploadedFilePath"));
        return uploadedFilePath.getText();
    }

    public void clickDownload() {
        scrollUtils.scrollToElement(downloadBtn);
        waitUtils.waitForClickable(By.id("downloadButton"));
//        jsUtils.clickByJS(driver, downloadBtn);
        clickUtils.safeClick(downloadBtn);
    }

    public boolean isDownloadButtonDisplayed() {
        return waitUtils.waitForVisibility(By.id("downloadButton")).isDisplayed();
    }
}
