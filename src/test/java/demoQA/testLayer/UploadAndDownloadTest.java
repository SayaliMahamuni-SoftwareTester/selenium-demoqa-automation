package demoQA.testLayer;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import demoQA.baseLayer.BaseTest;
import demoQA.baseLayer.DriverManager;
import demoQA.pageLayer.HomePage;
import demoQA.pageLayer.SubModulePage;
import demoQA.pageLayer.UploadAndDownloadPage;

public class UploadAndDownloadTest extends BaseTest {

	HomePage homePage;
	SubModulePage subModulePage;
	UploadAndDownloadPage uploadDownloadPage;
		
//	@BeforeMethod
//	public void setUpPage() {
//	    homePage = new HomePage(DriverManager.getDriver());
//	    homePage.clickOnElementsModule();
//
//	    subModulePage = new SubModulePage(DriverManager.getDriver());
//	    subModulePage.clickOnUploadDownloadMenuModule();
//
//	    uploadDownloadPage = new UploadAndDownloadPage(DriverManager.getDriver()); //  REQUIRED
//	    uploadDownloadPage.waitForUploadAndDownloadPage();
//	}

	public UploadAndDownloadPage navigateToUploadAndDownload() {
		WebDriver driver = DriverManager.getDriver();

	    HomePage homePage = new HomePage(driver);
	    homePage.clickOnElementsModule();

	    SubModulePage subModulePage = new SubModulePage(driver);
	    subModulePage.clickOnUploadDownloadMenuModule();

	    UploadAndDownloadPage uploadDownloadPage =
	            new UploadAndDownloadPage(driver);

	    uploadDownloadPage.waitForUploadAndDownloadPage();

	    return uploadDownloadPage;
	}
    @Test(description = "TC_015_File_Upload")
    public void verifyFileUpload() {
    	navigateToUploadAndDownload();

        //String filePath = System.getProperty("C:\\Users\\Admin\\Downloads\\profile.jpg");

        String filePath = System.getProperty("user.home") + "\\Downloads\\profile.jpg";

        uploadDownloadPage.uploadFile(filePath);

        String uploadedFileName = uploadDownloadPage.getUploadedFileName();

        Assert.assertTrue(uploadedFileName.contains("profile.jpg"),
                "Uploaded file name is incorrect!");
    }

    @Test(description = "TC_016_File_Download")
    public void verifyFileDownload() {
    	navigateToUploadAndDownload();

        uploadDownloadPage.clickDownload();

        String downloadLocation = System.getProperty("user.home") 
                                  + "\\Downloads\\sampleFile.jpeg";

        File downloadedFile = new File(downloadLocation);

        int waitTime = 0;
        while (!downloadedFile.exists() && waitTime < 10) {
            try {
                Thread.sleep(1000);
                waitTime++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Assert.assertTrue(downloadedFile.exists(),
                "Downloaded file not found!");
        
        DriverManager.getDriver().get("about:blank");


    }
    

}
