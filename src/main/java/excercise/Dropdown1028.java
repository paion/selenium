package excercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Dropdown1028 {
    public static void main(String[]args) {

        dropdown();
}
    public static void dropdown(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/omarfaruk/IdeaProjects/Paionvaisekenium/src/main/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        // driver.findElement(By.xpath(".//a[text()='Holiday Deals']")).click();
        //driver.findElement(By.xpath(".//span[contains(text(),'Arts, Crafts & Sewing')]")).click();
        //driver.findElement(By.xpath(".//a[contains(text(),'Under $25')]")).click();


        WebElement element123 = driver.findElement(By.id("select-demo"));
        Select sel = new Select(element123);


        List<WebElement> options = sel.getOptions();

        List<String> originallist = new ArrayList();

        for (WebElement e: options) {
            originallist.add(e.getText());
        }
        //System.out.println(originallist);
        Collections.sort(originallist);

    }
}