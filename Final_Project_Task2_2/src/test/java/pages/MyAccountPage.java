package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    @FindBy(xpath = "//*[@id=\"wrapper\"]/div/nav/ol/li[1]/a/span")
    private WebElement homeLink;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickHomeLink(){
        homeLink.click();
    }

}
