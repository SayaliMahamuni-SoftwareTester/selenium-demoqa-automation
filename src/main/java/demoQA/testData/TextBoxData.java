package demoQA.testData;

public class TextBoxData {
    public String testId;
    public String username;
    public String email;
    public String currentAddress;
    public String permanentAddress;
    public String expectRegisteredEmail;
    public String expectEmailFieldClass;

    @Override
    public String toString() {
        return "TextBoxData{" +
                "testId='" + testId + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", currentAddress='" + currentAddress + '\'' +
                ", permanentAddress='" + permanentAddress + '\'' +
                ", expectRegisteredEmail='" + expectRegisteredEmail + '\'' +
                ", expectEmailFieldClass='" + expectEmailFieldClass + '\'' +
                '}';
    }
}