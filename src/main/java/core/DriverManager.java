package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import pages.BasePage;

import java.time.Duration;
import java.util.Locale;

public class DriverManager {

    public static synchronized void setUpDriver() {
        String browser = System.getProperty("browser");
        String threadCount = System.getProperty("threadCount");
        System.out.println("=========================" + threadCount + "=========================");
        if (browser == null || browser.equals("")) {
            browser = "chrome";
        }
        setBrowser(browser);
    }

    public static void setBrowser(String browser) {
        WebDriver driver;
        switch (browser.toLowerCase(Locale.ROOT)) {
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Unsupported browser name: " + browser);
        }

        WebDriverListener listener = new EventDriver();
        WebDriver decorated = new EventFiringDecorator(listener).decorate(driver);
        decorated.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        BasePage.setDriverThreadLocal(decorated);
        String browserHeight = System.getProperty("height");
        String browserWidth = System.getProperty("width");
        decorated.manage().window().setSize(new Dimension(Integer.valueOf(browserHeight), Integer.valueOf(browserWidth)));
    }

    public static void quiteDriver() {
        if (BasePage.getWebDriverThreadLocal() != null) {
            BasePage.getWebDriverThreadLocal().get().quit();
            BasePage.getWebDriverThreadLocal().remove();
        }
    }
}
