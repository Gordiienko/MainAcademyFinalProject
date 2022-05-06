package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class MainPage extends BasePage {

    private final By textNearTheEmailField = By.xpath("//p[@id=\"block-newsletter-label\"]");
    private final By textUnderEmailField = By.xpath("//div[@class=\"col-md-7 col-xs-12\"]//p");
    private final By subscribeButton = By.xpath("//input[@value=\"Subscribe\"]");
    private final By frameLive = By.id("framelive");
    private final By dropDownLanguageMenuButton = By.xpath("//ul[@class=\"dropdown-menu hidden-sm-down\"]//li");
    private final By languageButton = By.xpath("//span[@class=\"expand-more\"]");
    private final By ukraineLanguageLocator = By.xpath("//a[@data-iso-code=\"uk\"]");
    private final By signInButton = By.xpath("//span[text()=\"Sign in\"]");
    private final By closesMenu = By.id("category-3");
    private final By accessoriesMenu = By.id("category-6");
    private final By artMenu = By.id("category-9");
    private final By subCategoryMenu = By.className("popover");

    @Step("")
    public void openClothesCategory() {
        WebElement webElement = find(frameLive);
        switchToIframe(webElement);
        waitUntilElementPresence(closesMenu, 10);
        hoverMouse(closesMenu);
    }
    public void openArtCategory(){
        waitUntilVisible(artMenu,15);
        hoverMouse(artMenu);
    }
    public void openAccessoriesCategory() {
        waitUntilVisible(accessoriesMenu,15);
        hoverMouse(accessoriesMenu);
    }

    public boolean categoryIsDisplayed(String category) {
        return waitUntilVisible(By.xpath(String.format("//a[contains(text(),'%s')]", category)), 10).isDisplayed();
    }

    public boolean subCategoryIsDisplayed(){
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
