package newrelease.amzn;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewReleaseLocaor {


    @FindBy(xpath = "//a[text()='New Releases']")
    public WebElement clicknewrelease;
    @FindBy(xpath = "//a[text()='Amazon Devices & Accessories']")
    public WebElement clickdeviceandacc;
    @FindBy(xpath = "//a[text()='Amazon Device Accessories']")
    public WebElement clickdevice;
    @FindBy(xpath = "//a[text()='Screen Protectors']")
    public WebElement clickscreenp;
    @FindBy(xpath = "//span[text()='Screen Protectors']")
    public WebElement clicksecscreenp;
}
