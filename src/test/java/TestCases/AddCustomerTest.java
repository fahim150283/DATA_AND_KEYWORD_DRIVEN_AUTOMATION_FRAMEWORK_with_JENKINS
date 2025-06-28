package TestCases;

import Base.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddCustomerTest extends TestBase {

    @Test(dataProviderClass = TestBase.class, dataProvider = "dp")
    public void addCustomerTest(String firstName, String lastName, String postCode) {
        logger.info("checking add customer functionality");

        // click on add customer button
        Click("addCustBtn_css");
        logger.info("click on add customer button completed");

        // enter first name
        Type("firstName_css", firstName);
        logger.info("enter first name completed");

        // enter last name
        Type("lastName_xpath", lastName);
        logger.info("enter last name completed");

        // enter post code
        Type("postCode_css", postCode);
        logger.info("enter post code completed");

        // click on add customer submit button
        Click("addCustSubmit_css");
        logger.info("click on add customer button completed");
        driver.switchTo().alert().accept();
    }


}
