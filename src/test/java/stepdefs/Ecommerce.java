package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BagPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.ProductPage;
import pages.placeOrderPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Ecommerce {
    WebDriver driver;
    HomePage home;
    ProductPage prod;
    BagPage bag;
    CheckOutPage checkOut;
    placeOrderPage placeOrder;

//    WebDriver driver = new ChromeDriver();
    @Given("user is on home page of eCommerce site")
    public void user_is_on_home_page_of_e_commerce_site() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        home = new HomePage(driver);
        driver.get("https://www.gap.com/");
//        home.launch_HomePage();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        home.close_PopUp();
//        driver.get("https://www.gap.com/");
        //close any pop up window that appears

//        WebElement ele = driver.findElement(By.className("sitewide-9pwq9q"));
//        if(ele != null)
//            ele.click();
//        else
//            System.out.println("popup button is null");

    }
    @When("user searches for product in search bar")
    public void user_searches_for_product_in_search_bar() {
        home.search_Product();
//        driver.findElement(By.name("searchText")).sendKeys("Womens Dress");
//        driver.findElement(By.name("searchText")).sendKeys(Keys.ENTER);
    }
    @When("user selects the nth item from search results")
    public void user_selects_the_nth_item_from_search_results() {
        prod = new ProductPage(driver);
        prod.selectProduct();
        //get list of items displayed and iterator for product
//        List<WebElement> allProducts = driver.findElements(By.className("css-1ohx80u"));
      //get the select items from list (index starts with 0)
//        WebElement prod = allProducts.get(0);
        //click on the item
//        prod.click();
    }
    @When("user adds the item to cart")
    public void user_adds_the_item_to_cart() throws InterruptedException {
        bag = new BagPage(driver);
        //Thread.sleep(1000);
        bag.promoPop();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        bag.selectSize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        bag.addToBag();
//        //select size
//        Thread.sleep(3000);
//        driver.findElement(By.className("promoDrawer__handlebar__icon")).click();
//        driver.findElement(By.id("variant-1-sizeDimension1-L")).click();

        //click add to bag
    //        driver.findElement(By.id("AddToBagFromBuyBox_add-to-bag__button")).click();
        //  quick add to cart
//        WebElement addToBag = prod.findElement(By.id("cat-product-image-440624002"));
//        if(addToBag !=null)
//            addToBag.click();
//        else
//            System.out.println("Add to bag button is null");
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
        //click on checkout button from the pop up
//        Thread.sleep(2000);
//        driver.findElement(By.id("checkoutButton")).click();

        //click on checkout button from the checkout page
//        driver.findElement(By.id("checkout-button")).click();

        //click on continue as guest
//        List<WebElement> buttons = driver.findElements(By.tagName("button"));
//        buttons.get(1).click();
//        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

//        driver.findElement(By.className("loyalty-continue-as-guest-btn")).click();
//        driver.findElement(By.id("verify-account-email")).sendKeys("abc@gmail.com");
        //enter the email address
//        List<WebElement> emailAcc = driver.findElements(By.id("verify-account-email"));
//        emailAcc.get(1).sendKeys("abc@gmail.com");
//        driver.findElement(By.className("loyalty-continue-as-guest-btn")).click();
//        driver.findElement(By.className("loyalty-guest-signin-button cb_fixed-button-primary css-0")).click();
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
    driver.quit();
    }

}

