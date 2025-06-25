package Listeners;

import Base.TestBase;
import Utilities.ScreenshotUtil;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import static Base.TestBase.*;

public class CustomListeners implements ITestListener {
    public static Logger logger = LogManager.getLogger("org.example");

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        logger.info("Login test completed");
        Reporter.log(result.getName() + " - Test is passed");
        test.log(LogStatus.PASS, result.getName().toUpperCase() + " - Test is passed");
        rep.endTest(test);
        rep.flush();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        System.setProperty("org.uncommons.reportng.escape-output", "false");

        result.getInstance();
        String screenshotName = result.getName().toUpperCase() + ".png";
        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, screenshotName);

        logger.error(result.getName() + " - Test Failed. Screenshot captured at: " + screenshotPath);

        Reporter.log("<br>");
        Reporter.log("<strong>" + result.getName() + " - Test Failed:</strong> <a href='file://" + screenshotPath + "'> View Screenshot</a><br>");
        Reporter.log("<br>");

        test.log(LogStatus.FAIL, result.getName().toUpperCase() + " - Test is failed. Screenshot captured at: " + screenshotPath + " - With the exception: " + result.getThrowable());
        test.log(LogStatus.FAIL, test.addScreenCapture(screenshotName));
        rep.endTest(test);
        rep.flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        logger.info("Login test skipped");
        Reporter.log(result.getName() + " - Test is skipped");
        test.log(LogStatus.SKIP, result.getName().toUpperCase() + " - Test is skipped");
        rep.endTest(test);
        rep.flush();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        test = rep.startTest(result.getName().toUpperCase());
    }
}