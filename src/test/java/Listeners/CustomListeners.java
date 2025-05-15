package Listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

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

        Reporter.log(result.getName() + " - Test is failed.<br>");
        Reporter.log("Taking screenshot of failed test case.<br>");
        Reporter.log("<a target=\"_blank\" href=\"Screenshots/Attack-On-Titan-Featured-And-Social-Media-Image.jpg>Click to see screenshot</a>");
        Reporter.log("<br>");
        Reporter.log("<a target=\"_blank\" href=\"Screenshots/Attack-On-Titan-Featured-And-Social-Media-Image.jpg>Click to see screenshot</a>");
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