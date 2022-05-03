package core;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.util.List;

@Slf4j

public class EventDriver implements WebDriverListener {
    @Override
    public void beforeGetText(WebElement element) {
        log.info("Get text from element {}",element);
    }

    @Override
    public void afterGetText(WebElement element, String result) {
        log.info("Text was receive from element [{}]",element.getText());
    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        log.info("Typing {} into field {}",keysToSend,element);
    }

    @Override
    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        log.info("Text {} was saved at field {}",keysToSend,element);
    }

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        log.info("Find element with {}",locator);
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        log.info("Element was found with {}",locator);
    }

    @Override
    public void beforeFindElements(WebDriver driver, By locator) {
        log.info("Find all elements with {}",locator);
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        log.info("Elements was found with {}",locator);
    }

    @Override
    public void afterFindElement(WebElement element, By locator, WebElement result) {
        log.info("Element {} was found with {}",element,locator);
    }

    @Override
    public void beforeClick(WebElement element) {
        log.info("Clicking on the element {}",element);
    }

    @Override
    public void afterClick(WebElement element) {
        log.info("Clicking on element {} was successful",element);
    }
}
