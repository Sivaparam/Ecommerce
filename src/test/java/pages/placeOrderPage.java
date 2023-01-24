package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class placeOrderPage {

    public placeOrderPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "addressForm__fullName")
    WebElement nameField;

    @FindBy(id = "addressForm__address")
    WebElement address;

    @FindBy(id = "addressForm__phone")
    WebElement phone;

    @FindBy(id = "shippingAddress__button--add")
    WebElement saveCtn;

    @FindBy(css = ".sds-cb_button-tertiary")
    WebElement suggestAdd;

    public void enterName(){
        nameField.sendKeys("abc xyz");
    }

    public void enterAddress(){
        address.sendKeys("1");
    }

    public void enterPhone(){
        phone.sendKeys("1234567890");
    }

    public void saveAndCtn(){
        saveCtn.click();
    }

    public void clickSuggAdd(){
        suggestAdd.click();
    }
}
