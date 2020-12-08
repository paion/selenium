package holidaydeals.amzn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HolidayDealsPage extends HolidaysDealsLocators {
    public WebDriver driver;


    public HolidayDealsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void login(){
        //TODO: do login
        clickholidaydels.click();
        checkbox.click();
        dollarvalue.click();
        dropdown.click();
        pricesorting.click();
        System.out.println(driver.getTitle());
    }


}
