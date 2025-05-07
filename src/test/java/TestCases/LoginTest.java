package TestCases;

import Base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginTest() {
        logger.info("Login test started");
        try {
            driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        logger.info("Login test completed");
    }

    @Test
    public void loginTest2() {
        logger.info("Login test started");
        System.out.println("jhakanaka deho dolana");
        logger.info("Login test completed");
        logger.debug("Login test failed");
        logger.error("Login test failed");
        Assert.fail("Login test failed");
    }
}
