package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import users.User;

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

    public String getTextFromPopUpUnderField() {
        return find(popUpUnderFirstNameField).getText();
    }

    public String getFirstNameColor() {
        return waitUntilVisible(colorFrameBoxOfFirstName, 10)
                .getCssValue("outline-color");

    }

    public void clickOnCustomerPrivacyIcon() {
        find(customerPrivacyIcon).click();
    }

    public void clickOnSaveButton() {
        waitUntilElementClickable(saveButton, 10).click();
    }

    public void clickOnSocialTitleMr() {
        waitUntilElementPresence(socialTitleMr, 10).click();
    }

    @Step("Enter registration date {user.}")
    public RegistrationAccountPage fillRegistrationForm(User user) {
        find(firstNameField).sendKeys(user.getUserFirstName());
        find(lastNameField).sendKeys(user.getUserLastName());
        find(emailField).sendKeys(user.getUserEmail());
        find(passwordField).sendKeys(user.getUserPassword());
        find(birthdateField).sendKeys(user.getUserBirthday());
        return this;
    }

    @Step("Enter registration date {user}")
    public RegistrationAccountPage fillRegistrationFormWithInvalidFirstName(User user) {
        find(firstNameField).sendKeys("James8");
        find(lastNameField).sendKeys(user.getUserLastName());
        find(emailField).sendKeys(user.getUserEmail());
        find(passwordField).sendKeys(user.getUserPassword());
        find(birthdateField).sendKeys(user.getUserBirthday());
        return this;

    }
}
