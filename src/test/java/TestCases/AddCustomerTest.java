package TestCases;

import Base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddCustomerTest extends TestBase {

    @Test(dataProvider = "CustomerData")
    public void addCustomerTest() {
        logger.info("checking add customer button");
        Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn"))), "Add customer button is not present");
        logger.info("checking add customer button completed");
    }

    @DataProvider(name = "CustomerData")
    public Object[][] getCustomerData() {
        Object[][] data = new Object[1][1];
        data[0][0] = "John Doe";
        return data;
    }
}
