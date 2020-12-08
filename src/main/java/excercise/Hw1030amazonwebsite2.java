package excercise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Hw1030amazonwebsite2 {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        amznwebsite2();
    }

    public static void amznwebsite2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "/Users/omarfaruk/IdeaProjects/Paionvaisekenium/src/main/resources/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
        driver.findElement(By.xpath("//a[text()='Holiday Deals']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Arts, Crafts & Sewing')]")).click();
        driver.findElement(By.cssSelector("[data-value='-25']")).click();

        driver.findElement(By.cssSelector("[class='a-button-text a-declarative']")).click();

        driver.findElement(By.xpath(".//a[contains(text(),'Price - Low to High')]")).click();

        waitForPage();
        Thread.sleep(1000);
        String item = "[class='a-row'] [class='a-row dealDetailContainer']";
        String priceCSS = ".dealPriceText";
        List<WebElement> elements = driver.findElements(By.cssSelector(item));
        String price = elements.get(0).findElement(By.cssSelector(priceCSS)).getText().replace("$", "").split(" - ")[0];
        Double priceValue = Double.parseDouble(price);
        assert priceValue >= 25.00;
        for (int i = 0; i < elements.size()-1; i++) {
            String price1 = elements.get(i).findElement(By.cssSelector(priceCSS)).getText().replace("$", "").split(" - ")[0];
            Double priceValue1  = Double.parseDouble(price1);
            String price2 = elements.get(i + 1 ).findElement(By.cssSelector(priceCSS)).getText().replace("$", "").split(" - ")[0];
            Double priceValue2  = Double.parseDouble(price2);
            System.out.println(String.valueOf(i).concat(" - ").concat(price1).concat(" and ").concat(price2));
            assert priceValue1 >= priceValue2;
            //System.out.println(price1 + " and " + price2);
        }
    }

    public static void waitForPage() {
        WebDriverWait wait = new WebDriverWait(driver, 5);

        Boolean isTrue = wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wdriver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");

            }
        });
        System.out.println(isTrue);
        assert isTrue == true;
        //driver.close();
        //driver.quit();

    }
}
//*&& ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete")