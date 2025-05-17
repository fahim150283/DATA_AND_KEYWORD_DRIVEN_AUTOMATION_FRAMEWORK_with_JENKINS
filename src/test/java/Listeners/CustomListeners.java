package Listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import static Base.TestBase.*;
import Utilities.ScreenshotUtil;

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

        Object testClass = result.getInstance();
        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName());
        logger.error(result.getName() + " - Test Failed. Screenshot captured at: " + screenshotPath);

        Reporter.log("<br><strong>Test Failed:</strong> " + result.getName());
        Reporter.log("<br><a href='" + screenshotPath + "' target='_blank'>Click here to view screenshot</a><br>");
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