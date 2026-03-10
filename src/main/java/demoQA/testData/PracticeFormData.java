package demoQA.testData;

public class PracticeFormData {

    public String testId;
    public String firstName;
    public String lastName;
    public String email;
    public String mobile;
    public String subject;
    public String filePath;
    public String currentAddress;
    public String state;
    public String city;
    public boolean expectSuccess;

    @Override
    public String toString() {
        return "PracticeFormData{" +
                "testId='" + testId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", subject='" + subject + '\'' +
                ", filePath='" + filePath + '\'' +
                ", currentAddress='" + currentAddress + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", expectSuccess=" + expectSuccess +
                '}';
    }
}
