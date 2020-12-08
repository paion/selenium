package excercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class Hw1012_new {
    public static void main(String[] args) throws Exception {

        raukten();

    }
    public static void raukten() throws Exception {

        System.setProperty("webdriver.chrome.driver",
                "/Users/omarfaruk/IdeaProjects/Paionvaisekenium/src/main/resources/driver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("incognito");
        options.addArguments("--disable-popup-blocking");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.get("https://www.rakuten.com/");
        driver.getCurrentUrl();
        driver.findElement(By.xpath("//p[@id='header_sign_in']")).click();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("farukshovon@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Sony0987");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        try {
            WebElement cashBackPopUpClose = driver.findElement(By.xpath("//span[contains(@class, 'pad-15')]"));
            if (cashBackPopUpClose.isDisplayed() || cashBackPopUpClose.isEnabled()) {
                cashBackPopUpClose.click();
            }
        } catch (Exception ex) {
            System.out.println("cashBackPopUpClose element not found");
            //ex.printStackTrace();
        }
        try {
            WebElement popupClose = driver.findElement(By.xpath("//span[@data-amp-modal_type='Button']"));
            if (popupClose.isDisplayed() || popupClose.isEnabled()) {
                popupClose.click();
            }
        } catch (Exception ex) {
            System.out.println("popupClose element not found");
            //ex.printStackTrace();
        }

        // driver.findElement(By.xpath("//span[@class='fa-times pointer absolute
        // f-gry-dk2 close-video f-18']")).click();
        Actions act = new Actions(driver);
        WebElement dropDownButtonForMyAccount = driver.findElement(By.xpath("//a[@data-navigation-id='22832']"));
        WebElement signOut = driver.findElement(By.xpath("//a[text()='Sign Out']"));
        act.moveToElement(dropDownButtonForMyAccount).perform();
        signOut.click();
        //Thread.sleep(3000);
        driver.quit();

    }

}
