package lukaszmucha.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @FindBy(tagName = "h1")
    WebElement productName;

    public Boolean checkProductName(String productNameString){

        Boolean match = productName.getText().equalsIgnoreCase(productNameString);

        return match;

    }
    @FindBy(css = "input[value='Dodaj do koszyka']")
    WebElement addToCartButton;
    public ShoppingCart addToCart(){

        addToCartButton.click();

        ShoppingCart cart = new ShoppingCart(driver);

        return cart;

    }


}
