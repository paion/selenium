package ebatesobjcucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbatesCucumber {
    public WebDriver driver;


    public EbatesCucumber(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "")
    public WebElement username;

    @FindBy(xpath = "")
    public WebElement password;

    @FindBy (xpath = "")
    public WebElement loginclick;

    @FindBy (xpath = "")
    public WebElement clicklogout;

    @FindBy (xpath = "")
    public WebElement closedriver;





}
