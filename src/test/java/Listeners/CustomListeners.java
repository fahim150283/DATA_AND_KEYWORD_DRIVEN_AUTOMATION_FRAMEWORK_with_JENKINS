package Listeners;

import Utilities.ScreenshotUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import static Base.TestBase.driver;

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
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        System.setProperty("org.uncommons.reportng.escape-output", "false");

        result.getInstance();
        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName());
//        String screenshotPath = "https://www.google.com";
        logger.error(result.getName() + " - Test Failed. Screenshot captured at: " + screenshotPath);

        Reporter.log("<br>");
        Reporter.log("<strong>" + result.getName() + " - Test Failed:</strong> <a href='file://" + screenshotPath + "'> View Screenshot</a><br>");
        Reporter.log("<br>");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }
}