package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.io.IOException;

public class PurchaseProcessSteps {
    private WebDriver driver;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.close();
        }
    }


    @Given("the user is logged in as an existing user")
    public void theUserIsLoggedInAsAnExistingUser() {
        HomePage homePage = new HomePage(driver);
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        homePage.clickSignInLink();

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.fillOutEmailAddressField("vovan89375@rencr.com");
        authenticationPage.fillOutPasswordField("password123");
        authenticationPage.clickSignInButton();

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickHomeLink();

    }

    @And("the user chooses Hummingbird Printed Sweater")
    public void theUserChoosesHummingbirdPrintedSweater() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickHummingbirdPrintedSweater();
        Thread.sleep(3000);
    }

    @And("the user checks if the discount is {int}%")
    public void theUserChecksIfTheDiscountIs(int discountPercentage) throws InterruptedException {
        ProductPage productPage = new ProductPage(driver);
        String expectedDiscountText = "SAVE " + discountPercentage + "%";
        Assert.assertEquals(expectedDiscountText, productPage.getDiscountOf20PercentBanner());
    }

    @When("the user chooses size {string}")
    public void theUserChoosesSize(String size) {
        ProductPage productPage = new ProductPage(driver);
        productPage.selectSize(size);
    }

    @And("the user chooses quantity (\\d+)$")
    public void theUserChoosesQuantityQuantity(int quantity) throws InterruptedException {
        ProductPage productPage = new ProductPage(driver);
        productPage.setQuantity(quantity);
    }

    @And("the user add the product to the cart")
    public void theUserAddTheProductToTheCart() {
        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCartButton();
    }

    @And("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        ProductPage productPage = new ProductPage(driver);
        productPage.clickProceedToCheckoutButton();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickProceedToCheckoutButton();
    }

    @And("the user confirms the shipping address")
    public void theUserConfirmsTheShippingAddress() {
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.confirmAddress();
    }

    @And("the user chooses Pick up in store shipping method")
    public void theUserChoosesPickUpInStoreShippingMethod() {
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.confirmShipping();
    }

    @And("the user selects Pay by Check payment option")
    public void theUserSelectsPayByCheckPaymentOption() {
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.choosePayByCheckOption();
    }

    @And("the user places the order")
    public void theUserPlacesTheOrder() {
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.acceptTerms();
        checkOutPage.clickPlaceOrderButton();
    }

    @Then("screenshot should be taken with the order confirmation and the payment amount")
    public void screenshotShouldBeTakenWithTheOrderConfirmationAndThePaymentAmount() throws IOException {
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        orderConfirmationPage.takeScreenshot(driver, "OrderConfirmationPage");
    }
}
