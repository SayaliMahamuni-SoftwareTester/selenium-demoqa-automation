package demoQA.testData;

public class AlertPageData {

    public String testId;
    public String alertType;     // PROMPT / CONFIRM / SIMPLE (future scalable)
    public String inputText;     // Used only for prompt
    public String action;        // ACCEPT or DISMISS
    public String expectedResult;

    @Override
    public String toString() {
        return "AlertPageData{" +
                "testId='" + testId + '\'' +
                ", alertType='" + alertType + '\'' +
                ", inputText='" + inputText + '\'' +
                ", action='" + action + '\'' +
                ", expectedResult='" + expectedResult + '\'' +
                '}';
    }
}
