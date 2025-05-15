package TestCases;

import Base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddCustomerTest extends TestBase {

    @Test(dataProvider = "CustomerData")
    public void addCustomerTest(String firstName, String lastName, String postCode) {
        logger.info("checking add customer functionality");

        // click on add customer button
        driver.findElement(By.cssSelector(OR.getProperty("addCustBtn"))).click();
        logger.info("click on add customer button completed");

        // enter first name
        driver.findElement(By.cssSelector(OR.getProperty("firstName"))).sendKeys(firstName);
        logger.info("enter first name completed");

        // enter last name
        driver.findElement(By.cssSelector(OR.getProperty("lastName"))).sendKeys(lastName);
        logger.info("enter last name completed");

        // enter post code
        driver.findElement(By.cssSelector(OR.getProperty("postCode"))).sendKeys(postCode);
        logger.info("enter post code completed");

        // click on add customer submit button
        driver.findElement(By.cssSelector(OR.getProperty("addCustSubmit"))).click();
        logger.info("click on add customer button completed");
        driver.switchTo().alert().accept();
    }

    @Test(dataProvider = "CustomerData")
    public void addCustomerTest1(String firstName, String lastName, String postCode) {
        logger.info("checking add customer functionality");
        Assert.fail();
    }

    @DataProvider(name = "CustomerData")
    public Object[][] getCustomerData() {
        String sheetname = "CustomerData";
        int rows = excel.getRowCount(sheetname);
        int cols = excel.getColumnCount(sheetname);
        Object[][] data = new Object[rows - 1][cols];

        for (int row = 1; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                data[row - 1][col] = excel.getCellData(sheetname, row, col);
            }
        }
        return data;
    }
}
