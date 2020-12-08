package pom.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends LoginPageLocators{

    public WebDriver driver;


    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void login(){
        //TODO: do login

        clicksign.click();
        emailclick.sendKeys("farukshovon@gmail.com");
        aftremailcontinue.click();
        passwordenter.sendKeys("Slsdtf@21");
        signtosubmit.click();
        System.out.println(driver.getTitle());
    }


}
