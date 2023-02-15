package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BagPage {

    //constructor
    public BagPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //locator to select size
    @FindBy(id = "variant-1-sizeDimension1-M")
        WebElement productSize;
    //locator to minimize promo pop up
    @FindBy(className = "promoDrawer__handlebar__icon")
        WebElement promoPopUp;
    //locator to click on add to bag button
    @FindBy(id = "AddToBagFromBuyBox_add-to-bag__button")
            WebElement addBag;

    //method to minimize promo pop up
    public void promoPop(){
        if(promoPopUp != null){
            promoPopUp.click();
        }else{
            System.out.println("No promo pop up on Product page");
        }
    }

    //method to select size of product
    public void selectSize(){
        productSize.click();
    }

    public void addToBag(){
        addBag.click();
    }
}
