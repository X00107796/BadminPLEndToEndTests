package lukaszmucha;
import io.github.bonigarcia.wdm.WebDriverManager;
import lukaszmucha.PageObjects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

import lukaszmucha.TestComponents.BaseTest;

public class AddRemoveItemFromCartTest extends BaseTest
{
    @Test
    public void addItemToCart() throws InterruptedException, IOException {

        //landingPage.goTo();

        LoginPage loginPage = landingPage.goToLogIn();

        loginPage.logIn();

        SearchResults searchResults = landingPage.searchProduct("yonex arcsaber");

        searchResults.sortResutlsByPriceAscending();

        ProductPage productPage = searchResults.selectTopSortedResult(searchResults.getSortedResults());

        Boolean correctProductName = productPage.checkProductName("Yonex ArcSaber 11 Play Grayish Pearl");

        Assert.assertTrue(correctProductName);

        ShoppingCart cart = productPage.addToCart();

        correctProductName = cart.checkProductName("Yonex ArcSaber 11 Play Grayish Pearl");

        Assert.assertTrue(correctProductName);

    }
    @Test(dependsOnMethods = {"addItemToCart"})
    public void removeItemFromCart() throws InterruptedException, IOException{

        LoginPage loginPage = landingPage.goToLogIn();

        loginPage.logIn();

        ShoppingCart cart = landingPage.goToCart();

        cart.removeProductFromCart();



    }
}
