package lukaszmucha.PageObjects;

import lukaszmucha.AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart extends AbstractComponent {

    WebDriver driver;

    public ShoppingCart(WebDriver driver){

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @FindBy(css="div[class='desc col-10 col-lg'] h3 ")
    WebElement productName;
    public Boolean checkProductName(String productNameString){

        Boolean match = productName.getText().equalsIgnoreCase(productNameString);

        return match;

    }
    @FindBy(css=".icon.icon-trash")
    WebElement trashEl;
    public void removeProductFromCart(){

        trashEl.click();

    }

}
