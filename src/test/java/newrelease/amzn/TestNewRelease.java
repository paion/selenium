package newrelease.amzn;

import base.Base;
import org.testng.annotations.Test;
import pom.login.LoginPage;

public class TestNewRelease extends Base {
    public NewRelease NR = new NewRelease(driver);

    @Test
    public void nrtest(){
        NR.nrelease();
    }



}
