package prestaShopTests;

import models.UserModel;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginAccountPage;
import pages.MainPage;
import pages.RegistrationAccountPage;

public class RegistrationAccountTest extends BaseTest {
    UserModel userModel = new UserModel();
    MainPage mainPage = new MainPage();
    AccountPage accountPage = new AccountPage();
    LoginAccountPage loginAccountPage = new LoginAccountPage();
    RegistrationAccountPage registrationAccountPage = new RegistrationAccountPage();

    @Test(description = "Create new account with valid date")
    public void createNewAccountWithValidDate() {
        mainPage.openMainPage();
        mainPage.clickOnSignInButton();
        loginAccountPage.clickCreateAccountLink();
        registrationAccountPage.clickOnSocialTitleMr();
        registrationAccountPage.fillRegistrationForm(userModel)
                .clickOnCustomerPrivacyIcon();
        registrationAccountPage.clickOnSaveButton();

        Assertions.assertThat(userModel.getUserFirstName() + " " + userModel.getUserLastName())
                .isEqualTo(accountPage.checkThatAccountNameAppear());
    }

    @Test(description = "Create new account with invalid first name")
    public void createNewAccountWithInvalidFirstName() {
        String exceptedColorOfFirstNameField = "rgba(255, 76, 76, 1)";
        String textFromPopUpUnderFieldFirstName = "Invalid name";
        SoftAssertions softAssertions = new SoftAssertions();
        mainPage.openMainPage();
        mainPage.clickOnSignInButton();
        loginAccountPage.clickCreateAccountLink();
        registrationAccountPage.clickOnSocialTitleMr();
        registrationAccountPage.fillRegistrationFormWithInvalidFirstName(userModel)
                .clickOnCustomerPrivacyIcon();
        registrationAccountPage.clickOnSaveButton();
        softAssertions.assertThat(registrationAccountPage.getFirstNameColor())
                .as("Color of First Name field must be: red").isEqualTo(exceptedColorOfFirstNameField);
        softAssertions.assertThat(registrationAccountPage.getTextFromPopUpUnderField())
                .as("Text in pop-up must be: Invalid name")
                .isEqualTo(textFromPopUpUnderFieldFirstName);
        softAssertions.assertAll();
    }
}
