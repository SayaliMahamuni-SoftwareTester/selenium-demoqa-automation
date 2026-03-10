package demoQA.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

    	if (extent == null) {

            String timestamp =
                    new SimpleDateFormat("yyyyMMdd_HHmmss")
                            .format(new Date());

            String reportFolder =
                    System.getProperty("user.dir")
                            + File.separator + "extent-reports";

            File folder = new File(reportFolder);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String reportPath =
                    reportFolder + File.separator
                            + "ExtentReport_" + timestamp + ".html";

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter(reportPath);

            reporter.config()
                    .setReportName("DemoQA Automation Report");

            reporter.config()
                    .setDocumentTitle("Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(reporter);

            extent.setSystemInfo("Project", "DemoQA");
            extent.setSystemInfo("Tester", "Sayali");
            extent.setSystemInfo("Environment", "QA");

        }

        return extent;
    }
}
