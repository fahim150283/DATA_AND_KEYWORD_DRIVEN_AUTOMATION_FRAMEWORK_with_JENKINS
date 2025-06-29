package TestCases;

import Base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankManagerLoginTest extends TestBase {

    @Test(priority = 1)
    public void loginTest() {
        logger.info("Login test started");
        try {
            driver.findElement(By.cssSelector(OR.getProperty("bmlBtn_css"))).click();
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void FailAssertionTest() {
        logger.info("checking add customer button");
        Assert.assertTrue(isElementPresent(By.cssSelector("buttonm")), "Add customer button is not present");
        logger.info("checking add customer button completed");
    }
}
