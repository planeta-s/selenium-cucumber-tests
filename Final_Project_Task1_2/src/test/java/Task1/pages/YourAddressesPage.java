package Task1.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAddressesPage {
    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/a")
    private WebElement createNewAddress;

    @FindBy(className = "address-body")
    private WebElement firstAddress;

    public YourAddressesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickCreateNewAddress() {
        createNewAddress.click();
    }

    public String getFirstAddress() {
        try {
            return firstAddress.getText();
        } catch (NoSuchElementException ex) {
            return null;
        }
    }
}
