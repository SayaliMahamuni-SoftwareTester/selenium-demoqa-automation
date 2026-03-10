package demoQA.testData;

public class DatePickerData {

    private String testId;
    private String month;
    private String year;
    private String day;
    private boolean expectValid;

    public String getTestId() {
        return testId;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getDay() {
        return day;
    }

    public boolean isExpectValid() {
        return expectValid;
    }

    @Override
    public String toString() {
        return "DatePickerData{" +
                "testId='" + testId + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                ", day='" + day + '\'' +
                ", expectValid=" + expectValid +
                '}';
    }
}
