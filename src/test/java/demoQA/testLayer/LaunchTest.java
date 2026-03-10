package demoQA.testLayer;

import org.testng.annotations.Test;
import demoQA.baseLayer.BaseTest;
import demoQA.baseLayer.DriverManager;

public class LaunchTest extends BaseTest {

    @Test
    public void verifyDemoQALaunch() {

    	System.out.println("Browser : " + getBrowserName());
        System.out.println("Title : " + DriverManager.getDriver().getTitle());
    }
}
