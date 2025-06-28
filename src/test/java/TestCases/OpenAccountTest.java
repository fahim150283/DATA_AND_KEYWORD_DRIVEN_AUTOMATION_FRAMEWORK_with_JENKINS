package TestCases;

import Base.TestBase;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class OpenAccountTest extends TestBase {

    @Test(dataProviderClass = TestBase.class, dataProvider = "dp")
    public void openAccountTest(String customer, String currency) {

        //click bank manager login at first
        Click("bmlBtn_css");

        // click on open account button
        Click("openAccBtn_xpath");
//        test.log(LogStatus.INFO, "click on open account button completed");

//        // click on  customer dropdown and select customer
//        Click("custDropDown_css");
//
//
//        // select currency
//        Click("currencyDropDown_xpath");
//
//
//
//        driver.switchTo().alert().accept();
    }
}
