package lukaszmucha.TestComponents;

import Utilities.DataReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import lukaszmucha.PageObjects.LandingPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

public class BaseTest extends DataReader {

    WebDriver driver;
    public LandingPage landingPage;

    public WebDriver initializeTest() throws IOException {

        Properties prop = new Properties();

        FileInputStream fileInputStream = new FileInputStream("D:\\Selenium\\SeleniumFrameworkDesignOne\\src\\main\\java\\lukaszmuchaseleniumstudy\\resources\\GlobalData.properties");

        prop.load(fileInputStream);

        String browserName = prop.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "D:\\work\\chromedriver.exe");
            //WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);


        }else if(browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();

            driver = new FirefoxDriver();

        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;


    }
    @BeforeMethod
    public LandingPage launchApplication() throws IOException {

        driver = initializeTest();
        landingPage = new LandingPage(driver);
        landingPage.goTo();
        return landingPage;

    }
    @AfterTest
    public void tearDown(){

        driver.close();

    }
    public String takeScreenshot(String testCaseName) throws IOException {

        TakesScreenshot ts = (TakesScreenshot)driver;

        File source = ts.getScreenshotAs(OutputType.FILE);

        String path = "D:\\Selenium\\SeleniumFrameworkDesignOne\\src\\test\\reports" + testCaseName + ".png";

        File file = new File(path);

        FileUtils.copyFile(source, file);

        return path;

    }


}