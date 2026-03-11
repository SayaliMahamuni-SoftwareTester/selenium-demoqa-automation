# DemoQA Selenium Automation Framework

## Project Overview
This project is an automation testing framework developed to test the DemoQA web application using Selenium WebDriver and Java.  
The framework follows the Page Object Model (POM) design pattern to improve code reusability and maintainability.

The purpose of this project is to demonstrate automation testing skills including UI testing, framework design, and test execution using TestNG.

---

## Tools & Technologies Used
- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- Eclipse IDE
- Git & GitHub

---

## Framework Features
- Page Object Model design pattern
- Reusable utility classes
- TestNG annotations and test execution
- Explicit waits for synchronization
- Modular test structure
- Easy maintenance and scalability

---

## Project Structure

## Project Structure

DemoQA-Selenium-Automation
│
├── src
│   └── test
│       ├── java
│       │   ├── demoQA.baseLayer
│       │   │   ├── BasePage.java
│       │   │   ├── BaseTest.java
│       │   │   ├── ConfigReader.java
│       │   │   └── DriverManager.java
│       │   │
│       │   ├── demoQA.pageLayer
│       │   │   ├── HomePage.java
│       │   │   ├── SubModulePage.java
│       │   │   ├── AlertPage.java
│       │   │   └── PracticeFormPage.java
│       │   │
│       │   ├── demoQA.testLayer
│       │   │   ├── HomeTest.java
│       │   │   ├── AlertTest.java
│       │   │   └── PracticeFormTest.java
│       │   │
│       │   └── demoQA.utilities
│       │       ├── WaitUtils.java
│       │       ├── ScrollUtils.java
│       │       ├── JSUtils.java
│       │       └── TestDataReader.java
│       │
│       └── resources
│           └── config.properties
│
├── Screenshots
├── extent-reports
├── test-output
│
├── testng.xml
├── pom.xml
└── README.md
---

## Automated Modules
The following modules from the DemoQA application are automated:

- Elements Module
- Forms Module
- Alerts Module
- Practice Form Validation
- UI Element Interaction

---

## How to Run the Project

1. Clone the repository from GitHub
2. Import the project into Eclipse as a Maven project
3. Update Maven dependencies
4. Run the TestNG test classes

---

## Author
**Sayali Mahamuni**

Software Tester | Manual & Automation Testing  
Skills: Selenium WebDriver, Java, TestNG, SQL, API Testing, Git, Maven

---

## GitHub Repository
DemoQA Selenium Automation Framework
