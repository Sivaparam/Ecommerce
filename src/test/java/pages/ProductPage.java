package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage {
    //constructor
    public ProductPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    //locator to get all products listed
    @FindBy(className = "css-1ohx80u")
        List<WebElement> allProducts;

    //method to select a nth product
    public void selectProduct(){
        WebElement prod = allProducts.get(3);
        prod.click();
    }
}
