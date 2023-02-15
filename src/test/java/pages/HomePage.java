package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    //Locator for home page pop up window
    @FindBy(className = "sitewide-9pwq9q")
        WebElement popUpElement;

    //Locator for search bar
    @FindBy(name = "searchText")
        WebElement search_Text;

    //constructor
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //launch home page
    public void launch_HomePage() {
        driver.get("https://www.gap.com/");
    }
    //to close up
    public void close_PopUp(){
        if(popUpElement != null){
            popUpElement.click();
        } else {
            System.out.println("No Pop up on Home page");
        }
    }
    //to enter text in search bar
    public void search_Product(String prod){
        search_Text.sendKeys(prod);
        search_Text.sendKeys(Keys.ENTER);
    }
}






