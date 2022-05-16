package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {

    private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    public static void setDriverThreadLocal(WebDriver driver) {
        DRIVER_THREAD_LOCAL.set(driver);
    }

    public static ThreadLocal<WebDriver> getWebDriverThreadLocal() {
        return DRIVER_THREAD_LOCAL;
    }


    public static WebDriver getDriver() {
        return DRIVER_THREAD_LOCAL.get();
    }

    public void switchToIframe(WebElement webElement) {
        getDriver().switchTo().frame(webElement);
    }

    public void hoverMouse(By locator) {
        WebElement element = find(locator);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).build().perform();
    }

    protected WebElement waitUntilElementPresence(By locator, int seconds) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected WebElement waitUntilVisible(By locator, int seconds) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitUntilElementClickable(By locator, int seconds) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement find(By locator) {
        return getDriver().findElement(locator);
    }

    public List<WebElement> findAll(By locator) {
        return getDriver().findElements(locator);
    }


}


