package Task1.steps;

import Task1.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class AddNewAddressSteps {
    private WebDriver driver;


    @Before
    public void openBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void closeBrowser() {
        if (driver != null){
            driver.close();
        }
    }

    @Given("the user is logged in as a registered user")
    public void theUserIsLoggedInAsARegisteredUser() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php");

        HomePage homePage = new HomePage(driver);
        homePage.clickSignInLink();

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.fillOutEmailAddressField("hisal569151@facais.com");
        authenticationPage.fillOutPasswordField("password123");

        authenticationPage.clickSignInButton();
    }

    @When("the user clicks on the Addresses button")
    public void theUserClicksOnTheAddressesButton() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickAddressesLink();

        YourAddressesPage yourAddressesPage = new YourAddressesPage(driver);
        yourAddressesPage.clickCreateNewAddress();
    }

    @And("the user fills the address form with {string}, {string}, {string}, {string},{string}")
    public void theUserFillsTheAddressFormWith(String alias, String address, String city, String zipPostalCode, String phone) {
        AddressCreationPage addressCreationPage = new AddressCreationPage(driver);
        addressCreationPage.fillAliasField(alias);
        addressCreationPage.fillAddressField(address);
        addressCreationPage.fillCityField(city);
        addressCreationPage.fillPostalCodeField(zipPostalCode);
        addressCreationPage.chooseCountry();
        addressCreationPage.fillPhoneField(phone);
    }

    @And("the user clicks Save button")
    public void theUserClicksSaveButton() {
        AddressCreationPage addressCreationPage = new AddressCreationPage(driver);
        addressCreationPage.clickSaveButton();
    }

    @Then("a new address should be added")
    public void aNewAddressShouldBeAdded() {
        YourAddressesPage yourAddressesPage = new YourAddressesPage(driver);
        String firstAddress = yourAddressesPage.getFirstAddress();
        assertTrue(firstAddress.contains("Home"));
        assertTrue(firstAddress.contains("Buhar Zhyrau 8"));
        assertTrue(firstAddress.contains("Almaty"));
        assertTrue(firstAddress.contains("100401"));
        assertTrue(firstAddress.contains("123456789"));
    }

}
