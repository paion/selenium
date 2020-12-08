package excercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Driverinitiate {

        public static void main (String[]args) {

            testdriver();

        }
        public static void testdriver() {
            System.setProperty("webdriver.chrome.driver",
                    "/Users/omarfaruk/IdeaProjects/Paionvaisekenium/src/main/resources/driver/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.facebook.com/");
            System.out.println("Page title is : " + driver.getTitle());
            //assert "Facebook - Log In or Sign Up".equals(driver.getTitle());
            driver.close();
            driver.quit();

        }
    }




