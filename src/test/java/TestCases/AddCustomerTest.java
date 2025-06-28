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
        Click("addCustBtn");
        logger.info("click on add customer button completed");

        // enter first name
        Type("firstName", firstName);
        logger.info("enter first name completed");

        // enter last name
        Type("lastName", lastName);
        logger.info("enter last name completed");

        // enter post code
        Type("postCode", postCode);
        logger.info("enter post code completed");

        // click on add customer submit button
        Click("addCustSubmit");
        logger.info("click on add customer button completed");
        driver.switchTo().alert().accept();
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
