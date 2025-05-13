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

    @DataProvider(name = "CustomerData")
    public Object[][] getCustomerData() {

        String sheetName = "CustomerData";
        int rows = excel.getRowCount("CustomerData");
        int columns = excel.getColumnCount("CustomerData");
        Object[][] data = new Object[rows - 1][columns];

        for (int rowNum = 1; rowNum < rows; rowNum++) {
            for (int colNum = 0; colNum < columns; colNum++) {
                data[rowNum - 1][colNum] = excel.getCellData(sheetName, colNum, rowNum);
                System.out.println(data[rowNum - 1][colNum]);
            }
        }
        return data;
    }
}
