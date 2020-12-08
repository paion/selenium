package newrelease.amzn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class NewRelease extends NewReleaseLocaor {


    public WebDriver driver;


    public NewRelease(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void nrelease(){
        //TODO: do login
        clicknewrelease.click();
        clickdeviceandacc.click();
        clickdevice.click();
        clickscreenp.click();
        clicksecscreenp.click();


        System.out.println(driver.getTitle());
    }
}
