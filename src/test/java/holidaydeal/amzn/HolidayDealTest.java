package holidaydeal.amzn;

import base.Base;
import holidaydeals.amzn.HolidayDealsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HolidayDealTest extends Base {
    HolidayDealsPage holidayDealsPage = new HolidayDealsPage(driver);

    /*@BeforeMethod
    public void setup() {
        driver.get("http://www.amazon.com");
    }*/

    @Test()
    public void hoildaydealtest() {
        holidayDealsPage.login();
    }


}
