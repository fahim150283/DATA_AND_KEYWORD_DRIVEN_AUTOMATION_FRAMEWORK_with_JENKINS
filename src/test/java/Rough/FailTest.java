package Rough;

import Base.TestBase;
import Utilities.CustomSoftAssert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FailTest extends TestBase {
    @Test()
    public void FailAssertionTest() {
        CustomSoftAssert softAssert = new CustomSoftAssert(driver, test);

        softAssert.assertTrue(isElementPresent(By.cssSelector("buttonm")), "Add customer button is not present");

        driver.get("http://zero.webappsecurity.com/index.html");
        softAssert.assertEquals(driver.getTitle(), "halum", "Title is not as expected");

        driver.navigate().back();

        softAssert.assertAll(); // <--- this will report all collected failures together
    }
}
