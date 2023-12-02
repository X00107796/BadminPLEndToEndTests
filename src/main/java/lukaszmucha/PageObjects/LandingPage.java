package lukaszmucha.PageObjects;

import lukaszmucha.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import lukaszmucha.PageObjects.SearchResults;

public class LandingPage extends AbstractComponent {

    WebDriver driver;

    //PageFactory
    @FindBy(id="search")
    WebElement search;

    @FindBy(css="button[type='submit']")
    WebElement searchButton;

    public LandingPage(WebDriver driver){

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void goTo(){

        driver.get("https://www.badmin.pl");

        driver.manage().window().maximize();
    }
    public SearchResults searchProduct(String productName){

        search.sendKeys("yonex arcsaber");

        searchButton.click();

        SearchResults searchResults = new SearchResults(driver);

        return searchResults;

    }
    @FindBy(css=".icon.icon-profil")
    WebElement profilEl;
    @FindBy(xpath = "//a[contains(text(),'Zaloguj się')]")
    WebElement logInEl;

    public LoginPage goToLogIn(){

        profilEl.click();

        logInEl.click();

        LoginPage logInPage = new LoginPage(driver);

        return logInPage;

    }
    @FindBy(css="//a[@title='Lotki']")
    WebElement lotkiMenuEl;
    public LotkiPage openMenuItem(){

        lotkiMenuEl.click();

        LotkiPage lotki = new LotkiPage(driver);

        return lotki;

    }
}
