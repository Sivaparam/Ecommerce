package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class placeOrderPage {

    public placeOrderPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "addressForm__fullName")
    WebElement nameField;

    @FindBy(id = "addressForm__address")
    WebElement stAddress;

    @FindBy(id = "addressForm__town")
    WebElement townAdd;

    @FindBy(className = "css-nxtdqy")
    WebElement stateAdd;


    @FindBy(id = "addressForm__zip")
    WebElement zipAdd;

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
        stAddress.sendKeys("1000 Market Place Boulevard");
        townAdd.sendKeys("cumming");
        Select state = new Select(stateAdd);
        state.selectByIndex(10);
        zipAdd.sendKeys("30041");
    }

    public void enterPhone(){
        phone.sendKeys("2345678900");
    }

    public void saveAndCtn(){
        saveCtn.click();
    }

    public void clickSuggAdd(){
        suggestAdd.click();
    }
}
