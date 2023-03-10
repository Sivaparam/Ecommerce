package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckOutPage {
    //constructor
    public CheckOutPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //locator for checkout button on pop up window
    @FindBy(id = "checkoutButton")
    WebElement checkOutBtn;
    //locator for checkout button on checkout page
    @FindBy(id = "checkout-button")
        WebElement checkBtn;

    @FindBy(css = ".loyalty-guest-signin-button")
        WebElement guestCheck2;
    @FindBy(className = "loyalty-continue-as-guest-btn")
    WebElement guestCheck;
    //locator to find email address field for guest check out
    @FindBy(id = "verify-account-email")
    List<WebElement> emailFields;
    //method to click on checkout button (from pop up and checkout page)
    public void clickCheckOut(){
        checkOutBtn.click();
    }

    public void clickCheck(){
        checkBtn.click();
    }

    public void guestCheckOut(){
    guestCheck.click();
    }

    public void guestCheckOut2(){
        guestCheck2.click();
    }

    public void enterEmail(){
       WebElement guestEmail = emailFields.get(1);
       guestEmail.sendKeys("abc@gmail.com");
    }

}

