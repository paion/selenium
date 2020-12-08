package pom.login;

import base.Base;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class LoginTest extends Base{

    public LoginPage logPage = new LoginPage(driver);

    @Test
    public void testLogin(){
        logPage.login();
    }

}
