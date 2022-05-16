package pages;

import io.qameta.allure.Step;
import models.AllProductModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AllProductsPage extends BasePage {

    private final By sortByButton = By.xpath("//button[@class=\"btn-unstyle select-title\"]");
    private final By sortByDropDownMenu = By.xpath("//div[@class=\"dropdown-menu\"]");
    private final By sortByNameAToZ = By.xpath("//a[contains(text(),'Name, A to Z')]");
    private final By sortByNameZToA = By.xpath("//a[contains(text(),'Name, Z to A')]");
    private final By sortByPriceLowToHigh = By.xpath("//a[contains(text(),'Price, low to high')]");
    private final By sortByPriceHighToLow = By.xpath("//a[contains(text(),'Price, high to low')]");
    private final By allProductContainer = By.xpath("//article");


    public List<AllProductModel> getInfoFromAllProducts() {
        waitUntilElementPresence(allProductContainer, 10);
        List<AllProductModel> products = new ArrayList<>();
        List<WebElement> containers = findAll(allProductContainer);
        for (WebElement container : containers) {
            AllProductModel allProductModel = new AllProductModel(container);
            products.add(allProductModel);
        }
        return products;
    }

    @Step("Click on 'Sort by' button")
    public void clickOnSortByButton() {
        waitUntilElementClickable(sortByButton, 10).click();
    }

    @Step("Click on 'Sort by price Low to High' link")
    public void clickOnSortByPriceLowToHigh() {
        WebElement webElement = find(sortByDropDownMenu);
        switchToIframe(webElement);
        waitUntilElementClickable(sortByPriceLowToHigh, 10).click();
    }

    @Step("Click on 'Sort by name Z to A' link")
    public void clickOnSortByNameZToA() {
        WebElement webElement = find(sortByDropDownMenu);
        switchToIframe(webElement);
        waitUntilElementClickable(sortByNameZToA, 10).click();
    }

    @Step("Click on 'Sort by name A to Z' link")
    public void clickOnSortByNameAToZ() {
        WebElement webElement = find(sortByDropDownMenu);
        switchToIframe(webElement);
        waitUntilElementClickable(sortByNameAToZ, 10).click();
    }

    @Step("Click on 'Sort by price High to Low' link")
    public void clickOnSortByPriceHighToLow() {
        WebElement webElement = find(sortByDropDownMenu);
        switchToIframe(webElement);
        waitUntilElementClickable(sortByPriceHighToLow, 10).click();
    }
}
