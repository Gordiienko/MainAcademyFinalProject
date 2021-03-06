package pages;

import io.qameta.allure.Step;
import models.UserModel;
import org.openqa.selenium.By;

public class RegistrationAccountPage extends BasePage {

    private final By socialTitleMr = By.cssSelector("#field-id_gender-1");
    private final By firstNameField = By.id("field-firstname");
    private final By lastNameField = By.id("field-lastname");
    private final By emailField = By.id("field-email");
    private final By passwordField = By.id("field-password");
    private final By birthdateField = By.id("field-birthday");
    private final By saveButton = By.xpath("//button[contains(text(),'Save')]");
    private final By customerPrivacyIcon = By.xpath("//input[@name=\"customer_privacy\"]");
    private final By popUpUnderFirstNameField = By.xpath("//li[text()=\"Invalid format.\"]");
    private final By colorFrameBoxOfFirstName = By.xpath("//input[@value=\"James8\"]");

    @Step("Get text from popup under first name field")
    public String getTextFromPopUpUnderField() {
        return find(popUpUnderFirstNameField).getText();
    }

    @Step("Get first name field frame, color")
    public String getFirstNameColor() {
        return waitUntilVisible(colorFrameBoxOfFirstName, 10)
                .getCssValue("outline-color");

    }

    @Step("Click on customer privacy icon")
    public void clickOnCustomerPrivacyIcon() {
        find(customerPrivacyIcon).click();
    }

    @Step("Click on save button")
    public void clickOnSaveButton() {
        waitUntilElementClickable(saveButton, 10).click();
    }

    @Step("Click on social title 'Mr'")
    public void clickOnSocialTitleMr() {
        waitUntilElementPresence(socialTitleMr, 10).click();
    }

    @Step("Enter registration date {user.}")
    public RegistrationAccountPage fillRegistrationForm(UserModel userModel) {
        find(firstNameField).sendKeys(userModel.getUserFirstName());
        find(lastNameField).sendKeys(userModel.getUserLastName());
        find(emailField).sendKeys(userModel.getUserEmail());
        find(passwordField).sendKeys(userModel.getUserPassword());
        find(birthdateField).sendKeys(userModel.getUserBirthday());
        return this;
    }

    @Step("Enter registration date {user}")
    public RegistrationAccountPage fillRegistrationFormWithInvalidFirstName(UserModel userModel) {
        find(firstNameField).sendKeys("James8");
        find(lastNameField).sendKeys(userModel.getUserLastName());
        find(emailField).sendKeys(userModel.getUserEmail());
        find(passwordField).sendKeys(userModel.getUserPassword());
        find(birthdateField).sendKeys(userModel.getUserBirthday());
        return this;

    }
}
