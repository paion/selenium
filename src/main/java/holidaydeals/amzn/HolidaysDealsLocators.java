package holidaydeals.amzn;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HolidaysDealsLocators {

    @FindBy(xpath = "//a[text()='Holiday Deals']")
    public WebElement clickholidaydels;
    @FindBy(xpath = "//span[contains(text(),'Arts, Crafts & Sewing')]")
    public WebElement checkbox;
    @FindBy (xpath = "//a[text()='Under $25']")
    public WebElement dollarvalue;
    @FindBy (xpath = "//span[@class='a-button-text a-declarative']")
    public WebElement dropdown;
    @FindBy (xpath = "//a[contains(text(),'Price - High to Low')]")
    public WebElement pricesorting;

}
