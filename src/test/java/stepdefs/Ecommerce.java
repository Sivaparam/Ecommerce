package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BagPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.ProductPage;
import pages.placeOrderPage;

import java.util.concurrent.TimeUnit;

public class Ecommerce {
    WebDriver driver;
    HomePage home;
    ProductPage prod;
    BagPage bag;
    CheckOutPage checkOut;
    placeOrderPage placeOrder;

    @Given("user is on home page of eCommerce {string}")
    public void userIsOnHomePageOfECommerce(String site) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        home = new HomePage(driver);
        driver.get(site);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        home.close_PopUp();
    }

    //    @Given("user is on home page of eCommerce site")
//    public void user_is_on_home_page_of_e_commerce_site() throws InterruptedException {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        home = new HomePage(driver);
//        driver.get("https://www.gap.com/");
//
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        home.close_PopUp();
//
//    }
    @When("user searches for {string} in search bar")
    public void userSearchesForInSearchBar(String prod) {
        home.search_Product(prod);
    }

//    @When("user searches for product in search bar")
//    public void user_searches_for_product_in_search_bar() {
//        home.search_Product();
//    }

    @When("user selects the nth item from search results")
    public void user_selects_the_nth_item_from_search_results() {
        prod = new ProductPage(driver);
        prod.selectProduct();
    }

    @When("user adds the item to cart")
    public void user_adds_the_item_to_cart() throws InterruptedException {
        bag = new BagPage(driver);


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        bag.selectSize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        bag.addToBag();
    }

    @When("user clicks on checkout")
    public void user_clicks_on_checkout() throws InterruptedException {
        checkOut = new CheckOutPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        checkOut.clickCheckOut();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        checkOut.clickCheck();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        checkOut.guestCheckOut();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        checkOut.enterEmail();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        checkOut.guestCheckOut2();

    }

    @When("user provides payment options")
    public void user_provides_payment_options() throws InterruptedException {
        placeOrder = new placeOrderPage(driver);
        placeOrder.enterName();
        placeOrder.enterAddress();
        placeOrder.enterPhone();
        placeOrder.saveAndCtn();
        placeOrder.clickSuggAdd();

    }

    @Then("purchase confirmation page is displayed")
    public void purchase_confirmation_page_is_displayed() {
        System.out.println("Order placed successfully");
        driver.quit();
    }
}




