package lukaszmucha.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){

        //super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @FindBy(name = "email_address")
    WebElement email_addressEl;
    @FindBy(name = "password")
    WebElement passwordEl;
    @FindBy(xpath = "//input[@value='Zaloguj się']")
    WebElement logInButtonEl;

    public LandingPage logIn(){

        email_addressEl.sendKeys("masakramufass@gmail.com");

        passwordEl.sendKeys("P4ssw0rd!");

        logInButtonEl.click();

        LandingPage landingPage = new LandingPage(driver);

        return landingPage;


    }



}
