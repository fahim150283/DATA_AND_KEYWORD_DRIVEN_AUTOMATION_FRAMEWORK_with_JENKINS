package Rough;

import org.testng.annotations.Test;

public class TestPropertiesRough extends Base.TestBase {

    @Test
    public void testPropertiesRough() {
        System.out.println("Hello World");
    }

    @Test
    public void DemoTest() {

        for (int i = 1; i < excel.getRowCount("test_suite"); i++) {
            String value1 = excel.getCellData("test_suite", i, 0);
            String value2 = excel.getCellData("test_suite", i, 1);
            System.out.println("Read value: " + value1 + " - " + value2);
        }
    }

}

