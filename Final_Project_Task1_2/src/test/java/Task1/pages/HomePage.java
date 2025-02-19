package Task1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a")
    private WebElement signInButton;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    public void clickSignInLink(){
        signInButton.click();
    }
}
