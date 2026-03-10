package demoQA.testLayer;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import demoQA.baseLayer.BaseTest;
import demoQA.baseLayer.DriverManager;
import demoQA.pageLayer.HomePage;
import demoQA.pageLayer.ProgressBarPage;
import demoQA.pageLayer.SubModulePage;

public class ProgressBarTest extends BaseTest {

	HomePage homePage;
	SubModulePage subModulePage;
	ProgressBarPage progressBarPage;

//	@BeforeMethod
//	public void setUpPage() {
//
//	    homePage = new HomePage(DriverManager.getDriver());
//	    homePage.clickOnWidgetsModule();
//
//	    subModulePage = new SubModulePage(DriverManager.getDriver());
//	    subModulePage.clickOnProgressBarModule();
//
//	    progressBarPage = new ProgressBarPage(DriverManager.getDriver());
//	    progressBarPage.waitForProgressBarPage();
//	}
	
	public ProgressBarPage navigateToProgressBar(){
		WebDriver driver = DriverManager.getDriver();

	    HomePage homePage = new HomePage(driver);
	    homePage.clickOnWidgetsModule();

	    SubModulePage subModulePage = new SubModulePage(driver);
	    subModulePage.clickOnProgressBarModule();

	    ProgressBarPage progressBarPage = new ProgressBarPage(driver);
	    progressBarPage.waitForProgressBarPage();

	    return progressBarPage;
	}

    @Test(description = "TC_011_Progress_Complete_Successfully")
    public void verifyProgressCompletesSuccessfully() {
    	progressBarPage = navigateToProgressBar();

        progressBarPage.startProgressAndWaitForCompletion();

        Assert.assertTrue(
                progressBarPage.isProgressCompleted(),
                "Progress did not reach 100%"
        );
    }

    @Test(description = "TC_012_Progress_Stop_Midway")
    public void verifyProgressStopsMidway() {
    	progressBarPage = navigateToProgressBar();

        progressBarPage.stopProgressMidway();

        Assert.assertTrue(
                progressBarPage.isStartButtonVisible(),
                "Progress did not stop properly"
        );
    }

    @Test(description = "TC_013_Progress_Reset_After_Completion")
    public void verifyProgressResetsAfterCompletion() {
    	progressBarPage = navigateToProgressBar();

        progressBarPage.startProgressAndWaitForCompletion();
        progressBarPage.clickResetButton();

        Assert.assertTrue(
                progressBarPage.isProgressReset(),
                "Progress did not reset to 0"
        );
    }

}
