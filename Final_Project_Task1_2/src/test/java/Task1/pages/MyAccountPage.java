package Task1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    @FindBy(xpath = "//*[@id=\"footer_account_list\"]/li[4]/a")
    private WebElement addresses;

    @FindBy(xpath = "//*[@id=\"wrapper\"]/div/nav/ol/li[1]/a/span")
    private WebElement homeLink;


    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void clickAddressesLink(){
        addresses.click();
    }

    public void clickHomeLink(){
        homeLink.click();
    }
}
