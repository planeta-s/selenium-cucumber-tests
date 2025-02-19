package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a")
    private WebElement signInButton;
    @FindBy(xpath = "//*[@id=\"content\"]/section/div/div[2]/article/div/div[2]/h3")
    private WebElement hummingbirdPrintedSweater;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void clickSignInLink(){
        signInButton.click();
    }

    public void clickHummingbirdPrintedSweater(){
        hummingbirdPrintedSweater.click();
    }

}
