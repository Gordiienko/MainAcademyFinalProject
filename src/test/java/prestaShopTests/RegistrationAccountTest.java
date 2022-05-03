package prestaShopTests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginAccountPage;
import pages.MainPage;
import pages.RegistrationAccountPage;
import users.User;

public class RegistrationAccountTest extends BaseTest {
    User user = new User();
    MainPage mainPage = new MainPage();
    AccountPage accountPage = new AccountPage();
    LoginAccountPage loginAccountPage = new LoginAccountPage();
    RegistrationAccountPage registrationAccountPage = new RegistrationAccountPage();

    @Test(description = "Create new account with valid date")
    public void createNewAccountWithValidDate() {
        mainPage.clickOnSignInButton();
        loginAccountPage.clickCreateAccountLink();
        registrationAccountPage.clickOnSocialTitleMr();
        registrationAccountPage.fillRegistrationForm(user)
                .clickOnCustomerPrivacyIcon();
        registrationAccountPage.clickOnSaveButton();

        Assertions.assertThat(user.getUserFirstName() + " " + user.getUserLastName())
                .isEqualTo(accountPage.checkThatAccountNameAppear());
    }

    @Test(description = "Create new account with invalid first name")
    public void createNewAccountWithInvalidFirstName() {
        String exceptedColorOfFirstNameField = "rgba(255, 76, 76, 1)";
        String textFromPopUpUnderFieldFirstName = "Invalid name";
        mainPage.clickOnSignInButton();
        loginAccountPage.clickCreateAccountLink();
        registrationAccountPage.clickOnSocialTitleMr();
        registrationAccountPage.fillRegistrationFormWithInvalidFirstName(user)
                .clickOnCustomerPrivacyIcon();
        registrationAccountPage.clickOnSaveButton();
        Assertions.assertThat(registrationAccountPage.getFirstNameColor())
                .as("Color of First Name field must be: red").isEqualTo(exceptedColorOfFirstNameField);
        Assertions.assertThat(registrationAccountPage.getTextFromPopUpUnderField())
                .as("Text in pop-up must be: Invalid name")
                .isEqualTo(textFromPopUpUnderFieldFirstName);
    }
}
