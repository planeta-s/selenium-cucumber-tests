package Task1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddressCreationPage {
    @FindBy(id = "field-alias")
    private WebElement alias;
    @FindBy(id = "field-address1")
    private WebElement address;
    @FindBy(id = "field-city")
    private WebElement city;
    @FindBy(id = "field-postcode")
    private WebElement postalCode;
    @FindBy(id = "field-id_country")
    private WebElement country;
    @FindBy(id = "field-phone")
    private WebElement phone;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/footer/button")
    private WebElement saveButton;

    private final WebDriverWait wait;

    public AddressCreationPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        PageFactory.initElements(driver, this);
    }

    public void fillAliasField(String alias){
        this.alias.clear();
        this.alias.sendKeys(alias);
    }
    public void fillAddressField(String address){
        this.address.clear();
        this.address.sendKeys(address);
    }
    public void fillCityField(String city){
        this.city.clear();
        this.city.sendKeys(city);
    }
    public void fillPostalCodeField(String zipPostalCode){
        postalCode.clear();
        postalCode.sendKeys(zipPostalCode);
    }
    public void chooseCountry(){
        country.click();
    }
    public void fillPhoneField(String phone){
        this.phone.clear();
        this.phone.sendKeys(phone);
    }

    public void clickSaveButton() {
        saveButton.click();
    }
}
