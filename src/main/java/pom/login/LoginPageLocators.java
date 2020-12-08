package pom.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocators {

    @FindBy(xpath = "//span[text()='Account & Lists']")
    public WebElement clicksign;
    @FindBy(xpath = "//input[@type='email']")
    public WebElement emailclick;
    @FindBy(xpath = "//input[@id='continue']")
    public WebElement aftremailcontinue;
    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordenter;
    @FindBy(xpath = "//input[@id='signInSubmit']")
    public WebElement signtosubmit;

}
