package prestaShopTests;

import core.EventDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import java.time.Duration;
import static pages.BasePage.getDriver;


public class BaseTest {

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverListener listener = new EventDriver();
        WebDriver decorated = new EventFiringDecorator(listener).decorate(driver);
        decorated.manage().window().maximize();
        decorated.get("https://demo.prestashop.com/");
        decorated.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        BasePage.setDriver(decorated);


    }

    @AfterMethod
    public void quite() {
        getDriver().quit();

    }
}

