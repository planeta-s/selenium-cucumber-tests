package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage {
    @FindBy(name = "confirm-addresses")
    private WebElement addressContinue;
    @FindBy(xpath = "//*[@id=\"js-delivery\"]/button")
    private WebElement shippingContinue;
    @FindBy(xpath = "//*[@id=\"payment-option-1\"]")
    private WebElement payByCheckOption;
    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement agreeToTermsCheckBox;
    @FindBy(xpath = "//*[@id=\"payment-confirmation\"]/div[1]/button")
    private WebElement placeOrderButton;

    private final WebDriver driver;

    public CheckOutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void confirmAddress(){
        addressContinue.click();
    }

    public void confirmShipping(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(shippingContinue));
        wait.until(ExpectedConditions.elementToBeClickable(shippingContinue));
        shippingContinue.click();
    }
    public void choosePayByCheckOption(){
        payByCheckOption.findElement(By.xpath("//*[@id=\"payment-option-1\"]"));
        payByCheckOption.click();
    }
    public void acceptTerms(){
        agreeToTermsCheckBox.findElement(By.xpath("//*[@id=\"conditions_to_approve[terms-and-conditions]\"]"));
        agreeToTermsCheckBox.click();
    }
    public void clickPlaceOrderButton(){
        placeOrderButton.findElement(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button"));
        placeOrderButton.click();
    }
}
