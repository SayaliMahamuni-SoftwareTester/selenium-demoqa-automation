package demoQA.testUtils;

import org.testng.annotations.DataProvider;

import demoQA.baseLayer.ConfigReader;

public class BrowserDataProvider {

    @DataProvider(name = "browserData", parallel = true)
    public static Object[][] getBrowserData() {

        String[] browsers = ConfigReader.getBrowsers();
        Object[][] data = new Object[browsers.length][1];

        for (int i = 0; i < browsers.length; i++) {
            data[i][0] = browsers[i].trim();
        }
        return data;
    }
}
