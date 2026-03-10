package demoQA.utilities;

import demoQA.testData.AlertPageData;
import demoQA.testData.DatePickerData;
import demoQA.testData.PracticeFormData;
import demoQA.testData.SelectMenuData;
import demoQA.testData.TextBoxData;

import org.testng.annotations.DataProvider;

import java.util.List;

public class TestDataProviders {

    @DataProvider(name = "textboxData", parallel = false)
    public static Object[][] textboxDataProvider() {
        List<TextBoxData> dataList = TestDataReader.readJsonList("testdata/textbox.json", TextBoxData.class);
        Object[][] out = new Object[dataList.size()][1];
        for (int i = 0; i < dataList.size(); i++) {
            out[i][0] = dataList.get(i);
        }
        return out;
    }
    
 // -------- Practice Form Data --------
    @DataProvider(name = "practiceFormData", parallel = false)
    public static Object[][] practiceFormDataProvider() {

        List<PracticeFormData> dataList = TestDataReader.readJsonList("testdata/practiceFormData.json", PracticeFormData.class);

        Object[][] out = new Object[dataList.size()][1];
        for (int i = 0; i < dataList.size(); i++) {
            out[i][0] = dataList.get(i);
        }
        return out;
    }
    
    @DataProvider(name = "alertData", parallel = false)
    public static Object[][] alertPageDataProvider() {

        List<AlertPageData> dataList = TestDataReader.readJsonList("testdata/alertPageData.json", AlertPageData.class);

        Object[][] out = new Object[dataList.size()][1];
        for (int i = 0; i < dataList.size(); i++) {
            out[i][0] = dataList.get(i);
        }
        return out;
    }
    
    @DataProvider(name = "datePickerData", parallel = false)
    public static Object[][] datePickerDataProvider() {

        List<DatePickerData> dataList =
                TestDataReader.readJsonList("testdata/datePickerData.json", DatePickerData.class);

        Object[][] out = new Object[dataList.size()][1];

        for (int i = 0; i < dataList.size(); i++) {
            out[i][0] = dataList.get(i);
        }

        return out;
    }
    
 // -------- Select Menu Data --------
    @DataProvider(name = "selectMenuData", parallel = false)
    public static Object[][] selectMenuDataProvider() {

        List<SelectMenuData> dataList =TestDataReader.readJsonList("testdata/selectMenuData.json",SelectMenuData.class);

        Object[][] out = new Object[dataList.size()][1];

        for (int i = 0; i < dataList.size(); i++) {
            out[i][0] = dataList.get(i);
        }

        return out;
    }

}