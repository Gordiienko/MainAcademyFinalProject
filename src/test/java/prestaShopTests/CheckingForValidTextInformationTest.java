package prestaShopTests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;


public class CheckingForValidTextInformationTest extends BaseTest {
    @Test(description = "Check on valid text by email field")
    public void validTextByEmailField() {
        String exceptedTextNearTheEmailField = "Get our latest news and special sales";
        String exceptedTextUnderEmailField = "You may unsubscribe at any moment." +
                " For that purpose, please find our contact info in the legal notice.";
        String exceptedLetterCaseOfSubscribeButton = "uppercase";
        MainPage mainPage = new MainPage();
        SoftAssertions softAssertions = new SoftAssertions();
        mainPage.openMainPage();
        String actualTextNearTheEmailField = mainPage.getTextNearTheEmailField();

        softAssertions.assertThat(actualTextNearTheEmailField)
                .as("Text near the email field must be: Get our latest news and special sales")
                .isEqualTo(exceptedTextNearTheEmailField);

        String actualTextUnderEmailField = mainPage.getTextUnderEmailField();

        softAssertions.assertThat(actualTextUnderEmailField).as("Text under email field must be:" +
                        " You may unsubscribe at any moment." +
                        "For that purpose, please find our contact info in the legal notice.")
                .isEqualTo(exceptedTextUnderEmailField);
        String actualLetterCaseOfSubscribeButton = mainPage.checkThatCharactersOnSubscribeButtonInUpperCase();

        softAssertions.assertThat(actualLetterCaseOfSubscribeButton).as("Subscribe button must be in: uppercase")
                .isEqualTo(exceptedLetterCaseOfSubscribeButton);
        softAssertions.assertAll();
    }
}
