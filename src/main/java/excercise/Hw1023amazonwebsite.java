package excercise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Hw1023amazonwebsite {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        amznwebsite();
    }


    public static void amznwebsite() throws InterruptedException {
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

        //WebElement element123 = driver.findElement(By.partialLinkText("a-button a-button-dropdown a-button-small sortOrderDropdown"));//linkText("Featured"));
        //WebElement element123 =
        driver.findElement(By.cssSelector("[class='a-button-text a-declarative']")).click();
////span[@class='a-dropdown-prompt']
        //Select sel = new Select(element123);


        /*List<WebElement> options = sel.getOptions();
        List<String> originallist = new ArrayList();
        for (WebElement webElement: options) {
            originallist.add(webElement.getText());n
        }
        System.out.println(originallist);*/


        driver.findElement(By.xpath(".//a[contains(text(),'Price - High to Low')]")).click();
        waitForPage();
        Thread.sleep(1000);
        String item = "[class='a-row'] [class='a-row dealDetailContainer']";
        String priceCSS = ".dealPriceText";
        List<WebElement> elements = driver.findElements(By.cssSelector(item));
        String price = elements.get(0).findElement(By.cssSelector(priceCSS)).getText().replace("$", "").split(" - ")[0];
        Double priceValue = Double.parseDouble(price);
        assert priceValue <= 25.00;
        for (int i = 0; i < elements.size()-1; i++) {
            String price1 = elements.get(i).findElement(By.cssSelector(priceCSS)).getText().replace("$", "").split(" - ")[0];
            Double priceValue1  = Double.parseDouble(price1);
            String price2 = elements.get(i + 1 ).findElement(By.cssSelector(priceCSS)).getText().replace("$", "").split(" - ")[0];
            Double priceValue2  = Double.parseDouble(price2);
            System.out.println(String.valueOf(i).concat(" - ").concat(price1).concat(" and ").concat(price2));
            assert priceValue1 >= priceValue2;
            //System.out.println(price1 + " and " + price2);

        }
//        String price1 = driver.findElements(By.cssSelector(item)).get(0).findElement(By.cssSelector(priceCSS)).getText();
//        System.out.println(price1);
//        Double priceValue1 = Double.parseDouble(price1);
//        assert priceValue1 <= 25.00;
//
//        String price2 = driver.findElements(By.cssSelector(item)).get(1).findElement(By.cssSelector(priceCSS)).getText();
//        assert priceValue1 >= Double.parseDouble(price2);
//        String price3 = driver.findElements(By.cssSelector(item)).get(1).findElement(By.cssSelector(priceCSS)).getText();


        //driver.findElement(By.xpath(".//span[contains(text(),'Glitter Gel Pens, 100 Color Glitter Pen Set, 30% More Ink Neon Glitt...')]")).click();
        //driver.findElement(By.xpath(".//span[@id='a-autoid-0-announce']")).click();
        // driver.findElement(By.xpath(".//a[@id='quantity_1']")).click();
        //driver.findElement(By.xpath(".//input[@class='a-button-input attach-dss-atc']")).click();
        // driver.findElement(By.xpath(".//span[@class='a-button a-button-primary attach-primary-button attach-button-large']")).click();
        // driver.findElement(By.xpath(".//input[@type='email']")).sendKeys("farukshovon@gmail.com");
        // driver.findElement(By.xpath(".//input[@id='continue']")).click();
        //driver.quit();

    }

    public static void waitForPage() {
        WebDriverWait wait = new WebDriverWait(driver, 5);

        Boolean isTrue = wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wdriver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete")
                        /*&& ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete")*/;
            }
        });
        System.out.println(isTrue);
        assert isTrue == true;
    }
}

