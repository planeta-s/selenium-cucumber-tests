package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[2]/div[1]/div[2]/div/span[2]")
    private WebElement discount;
    @FindBy(xpath = "//*[@id=\"group_1\"]")
    private WebElement sizeDropDownElement;
    @FindBy(xpath = "//*[@id=\"quantity_wanted\"]")
    private WebElement quantityChangeField;
    @FindBy(xpath = "//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button")
    private WebElement addToCartButton;
    @FindBy(xpath = "//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")
    private  WebElement proceedToCheckoutLink;
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getDiscountOf20PercentBanner() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.visibilityOf(discount));
            return discount.getText();
        } catch (Exception e) {
            throw new AssertionError("Discount element is not visible on the page.", e);
        }
    }

    public void selectSize(String size) {
        Select sizeSelect = new Select(sizeDropDownElement);
        sizeSelect.selectByVisibleText(size);
    }

    public void setQuantity(int quantity) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        quantityChangeField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        quantityChangeField.sendKeys(Keys.BACK_SPACE);

        wait.until(ExpectedConditions.textToBePresentInElementValue(quantityChangeField, ""));

        quantityChangeField.sendKeys(String.valueOf(quantity));

    }

    public void clickAddToCartButton(){
        addToCartButton.click();
    }

    public void clickProceedToCheckoutButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutLink));
        proceedToCheckoutLink.click();
    }



}


