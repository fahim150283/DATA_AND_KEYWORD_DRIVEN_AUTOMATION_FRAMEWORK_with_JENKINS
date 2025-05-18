package Utilities;

import com.aventstack.extentreports.ExtentReports;

import java.io.File;

public class ExtentManager {
    private static ExtentReports extent;

    public static synchronized ExtentReports getInstance() {
        if (extent == null) {
            extent = new ExtentReports();
            extent.createTest(System.getProperty("user.dir") + "/target/surefire-reports/html/extentReport.html");
            extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));
        }
        return extent;
    }
}
