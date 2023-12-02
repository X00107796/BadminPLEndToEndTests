package lukaszmucha.AbstractComponents;

import lukaszmucha.PageObjects.ShoppingCart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbstractComponent {

    WebDriver driver;

    public AbstractComponent(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @FindBy(css="a[href='#headCartMenu']")
    WebElement cart;
    public ShoppingCart goToCart(){

        cart.click();

        ShoppingCart cartPage = new ShoppingCart(driver);

        return cartPage;

    }





}
