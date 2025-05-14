package Rough;

import Utilities.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;

public class TestPropertiesRough {

    public static ExcelReader excel;

    static {
        try {
            excel = new ExcelReader(System.getProperty("user.dir") + "/src/test/resources/Excel/CustomerData.xlsx");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {

        Properties config = new Properties();
        Properties OR = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Properties/config.properties");
        config.load(fis);
        fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Properties/OR.properties");
        OR.load(fis);

        System.out.println(config.getProperty("browser"));
        System.out.println(OR.getProperty("bmlBtn"));
    }

    @Test(dataProvider = "CustomerData1")
    public void test(String firstName, String lastName, String postCode) {
        System.out.print(firstName+" ");
        System.out.print(lastName+" ");
        System.out.print(postCode);
        System.out.println();
    }

    @DataProvider(name = "CustomerData1")
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

