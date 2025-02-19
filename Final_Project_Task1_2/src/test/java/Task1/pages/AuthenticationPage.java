package Task1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage {
    @FindBy(xpath = "//*[@id=\"field-email\"]")
    private WebElement emailField;
    @FindBy(xpath = "//*[@id=\"field-password\"]")
    private WebElement passwordField;
    @FindBy(id = "submit-login")
    private WebElement signInButton;

    public AuthenticationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillOutEmailAddressField(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void fillOutPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSignInButton() {
        signInButton.click();
    }
}
