package stepdefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;


public class SearchSteps {
    private final WebDriver driver = new ChromeDriver();

//    @Given("I am on the Google search page")
//    public void i_visit_google() {
//        driver.get("https://www.google.com");
//    }

//    @Given("^I am on the (.*)$")
//    public void test1(String a) {
//        driver.get("https://www.google.com");
//    }

    @Given("I am on the (.*) to test")
    public void test2(String a) {
        driver.get("https://www.google.com");
    }
    @When("I search for {string} text")
    public void search_for(String query) {
        WebElement element = driver.findElement(By.name("q"));
        // Enter something to search for
        element.sendKeys(query);
        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();
    }

    @Then("the page title should start with {string}")
    public void checkTitle(String titleStartsWith) {
        // Google's search is rendered dynamically with JavaScript
        // Wait for the page to load timeout after ten seconds
        new WebDriverWait(driver,10L).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("titleStartsWith");
            }
        });
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
