package TestCases;

import Base.TestBase;
import Utilities.CustomSoftAssert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BankManagerLoginTest extends TestBase {
    Utilities.CustomSoftAssert softAssert = new Utilities.CustomSoftAssert(driver, test);

    @Test(priority = -1)
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
        CustomSoftAssert softAssert = new CustomSoftAssert(driver, test);

        logger.info("checking add customer button");
        softAssert.assertTrue(isElementPresent(By.cssSelector("buttonm")), "Add customer button is not present");

        driver.get("http://zero.webappsecurity.com/index.html");
        softAssert.assertEquals(driver.getTitle(), "halum", "Title is not as expected");

        logger.info("checking add customer button completed");

        softAssert.assertAll(); // <--- this will report all collected failures together
    }

}
