package lukaszmucha.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedList;
import java.util.List;

public class SearchResults {

    WebDriver driver;
    List<WebElement> sortedResults;

    public SearchResults(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }
    //PageFactory
    @FindBy(id="sort")
    WebElement sort;
    @FindBy(xpath = "//select[@id='sort']/option[3]")
    WebElement sortByPriceAscending;
    /*@FindBy(css=".prodListSingle")
    List<WebElement> sortedResults;*/
    By sortedProducts = By.cssSelector(".prodListSingle");


    public void sortResutlsByPriceAscending(){

        sort.click();

        sortByPriceAscending.click();

    }
    public List<WebElement> getSortedResults() {

        sortedResults = driver.findElements(sortedProducts);

        return sortedResults;

    }
    public ProductPage selectTopSortedResult(List<WebElement> sortedListOfResults){

        sortedListOfResults.get(0).click();

        ProductPage productPage = new ProductPage(driver);

        return productPage;

    }


}
