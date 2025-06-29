package Utilities;

import Utilities.ScreenshotUtil;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class CustomSoftAssert {
    private SoftAssert softAssert;
    private WebDriver driver;
    private com.relevantcodes.extentreports.ExtentTest test;
    private List<String> failureScreenshots;

    public CustomSoftAssert(WebDriver driver, com.relevantcodes.extentreports.ExtentTest test) {
        this.softAssert = new SoftAssert();
        this.driver = driver;
        this.test = test;
        this.failureScreenshots = new ArrayList<>();
    }

    public void assertTrue(boolean condition, String message) {
        if (!condition) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, message + ".png");
            test.log(LogStatus.FAIL, message + test.addScreenCapture(screenshotPath));
            failureScreenshots.add(screenshotPath);
        } else {
            test.log(LogStatus.PASS, message);
        }
        softAssert.assertTrue(condition, message);
    }

    public void assertEquals(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, message + ".png");
            test.log(LogStatus.FAIL, message + " | Expected: " + expected + " but got: " + actual + test.addScreenCapture(screenshotPath));
            failureScreenshots.add(screenshotPath);
        } else {
            test.log(LogStatus.PASS, message);
        }
        softAssert.assertEquals(actual, expected, message);
    }

    public void assertAll() {
        softAssert.assertAll();
    }

    public List<String> getFailureScreenshots() {
        return failureScreenshots;
    }
}
