package base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Base {
    public WebDriver driver;


    public Base() {
      if (driver == null) {
            System.setProperty("webdriver.chrome.driver",
                    "/Users/omarfaruk/IdeaProjects/Paionvaisekenium/src/main/resources/driver/chromedriver");
            driver = new ChromeDriver();
        }
    }

    //@BeforeGroups
    public void dosome(){

    }
    //@Parameters({"driver"})
    @BeforeClass
    public void openHomePage() {
       /* if (driver == null) {
            if (paralelbrowser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver",
                        "/Users/omarfaruk/IdeaProjects/Paionvaisekenium/src/main/resources/driver/chromedriver");
                driver = new ChromeDriver();

            } else if (paralelbrowser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "/Users/omarfaruk/IdeaProjects/Paionvaisekenium/src/main/resources/driver/geckodriver");

                driver = new FirefoxDriver();
            }
        }*/
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.get("http://www.amazon.com");
    }


    @AfterClass
    public void closeDriver() {
        driver.close();
    }
}
