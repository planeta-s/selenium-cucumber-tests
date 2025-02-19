package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a")
    private WebElement proceedToCheckoutButton;

    public ShoppingCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }
}
