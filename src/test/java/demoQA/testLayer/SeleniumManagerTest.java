package demoQA.testLayer;

import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumManagerTest {
    public static void main(String[] args) {
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://demoqa.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
