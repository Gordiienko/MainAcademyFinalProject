package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class BasePage {
    private static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public static WebDriver getDriver() {
        return driver;
    }
public void switchToIframe(WebElement webElement){
        getDriver().switchTo().frame(webElement);
}

    public void hoverMouse(By locator) {
        WebElement element = find(locator);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).build().perform();
    }
    protected WebElement waitUntilVisible(By locator, int seconds){
        return  new WebDriverWait(getDriver(),Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitUntilElementPresence(By locator, int seconds) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    protected WebElement waitUntilElementClickable (By locator, int seconds){
        return new WebDriverWait(getDriver(),Duration.ofSeconds(seconds))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement find(By locator) {
        return getDriver().findElement(locator);
    }

    public List<WebElement> findAll(By locator) {
        return getDriver().findElements(locator);
    }


}

