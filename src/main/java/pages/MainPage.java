package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import models.ProductModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

@Log4j
public class MainPage extends BasePage {

    private final String BASE_URL = "https://demo.prestashop.com/";
    private final By textNearTheEmailField = By.xpath("//p[@id=\"block-newsletter-label\"]");
    private final By textUnderEmailField = By.xpath("//div[@class=\"col-md-7 col-xs-12\"]//p");
    private final By subscribeButton = By.xpath("//input[@value=\"Subscribe\"]");
    private final By frameLive = By.id("framelive");
    private final By dropDownLanguageMenuButton = By.xpath("//ul[@class=\"dropdown-menu hidden-sm-down\"]//li");
    private final By languageButton = By.xpath("//span[@class=\"expand-more\"]");
    private final By ukraineLanguageLocator = By.xpath("//a[text()='Українська']");
    private final By signInButton = By.xpath("//span[text()=\"Sign in\"]");
    private final By closesMenu = By.id("category-3");
    private final By accessoriesMenu = By.id("category-6");
    private final By artMenu = By.id("category-9");
    private final By subCategoryMenu = By.className("popover");
    private final By productContainer = By.xpath("//article[contains(@class,'product-miniature')]");
    private final By priceDropLink = By.id("link-product-page-prices-drop-1");
    private final By allProductsLink = By.xpath("//a[contains(text(),'All products')]");

    public void openMainPage() {
        log.info("Opening main page of the application");
        getDriver().get(BASE_URL);
    }

    @Step("Click on 'All products' link")
    public AllProductsPage clickOnAllProductsLink() {
        WebElement webElement = find(frameLive);
        switchToIframe(webElement);
        waitUntilElementClickable(allProductsLink, 10).click();
        return new AllProductsPage();
    }

    @Step("Click on 'Price drop' link")
    public PriceDropPage clickOnPriceDropLink() {
        WebElement webElement = find(frameLive);
        switchToIframe(webElement);
        waitUntilElementPresence(priceDropLink, 10).click();
        return new PriceDropPage();
    }

    public List<ProductModel> getProductsFromProductsSection() {
        WebElement webElement = find(frameLive);
        switchToIframe(webElement);
        waitUntilElementPresence(productContainer, 10);
        List<ProductModel> products = new ArrayList<>();
        List<WebElement> containers = findAll(productContainer);
        for (WebElement container : containers) {
            ProductModel productModel = new ProductModel(container);
            products.add(productModel);
        }
        return products;
    }


    public void hoverMouseClothesCategory() {
        WebElement webElement = find(frameLive);
        switchToIframe(webElement);
        waitUntilElementPresence(closesMenu, 10);
        hoverMouse(closesMenu);
    }

    public void hoverMouseArtCategory() {
        waitUntilVisible(artMenu, 15);
        hoverMouse(artMenu);
    }

    public void hoverMouseAccessoriesCategory() {
        waitUntilVisible(accessoriesMenu, 15);
        hoverMouse(accessoriesMenu);
    }

    public boolean categoryIsDisplayed(String category) {
        return waitUntilVisible(By.xpath(String.format("//a[contains(text(),'%s')]", category)), 10).isDisplayed();
    }

    public boolean subCategoryIsDisplayed() {
        return find(subCategoryMenu).isDisplayed();
    }

    @Step("Click on [sign in] button")
    public void clickOnSignInButton() {
        WebElement webElement = find(frameLive);
        switchToIframe(webElement);
        waitUntilElementClickable(signInButton, 10).click();
    }

    @Step("Find [Ukraine language] in drop-down menu")
    public String findUkraineLanguageInDropDownMenu() {

        return find(ukraineLanguageLocator).getText();
    }

    @Step("Click on [language] button")
    public void clickOnLanguageButton() {
        WebElement webElement = find(frameLive);
        switchToIframe(webElement);
        waitUntilElementClickable(languageButton, 10).click();
    }

    @Step("Get all [language] from drop-down menu")
    public List<WebElement> getAllLanguageFromDropDownMenu() {
        return findAll(dropDownLanguageMenuButton);
    }

    @Step("Get [text] near the email field")
    public String getTextNearTheEmailField() {
        WebElement webElement = find(frameLive);
        switchToIframe(webElement);
        return waitUntilElementPresence(textNearTheEmailField, 10).getText();
    }

    @Step("Get [text] under email field")
    public String getTextUnderEmailField() {

        return waitUntilElementPresence(textUnderEmailField, 5).getText();
    }

    @Step("Check that characters on [SUBSCRIBE] button in uppercase")
    public String checkThatCharactersOnSubscribeButtonInUpperCase() {
        return find(subscribeButton).getCssValue("text-transform");
    }

}
