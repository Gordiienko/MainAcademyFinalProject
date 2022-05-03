package prestaShopTests;

import org.assertj.core.api.Assertions;
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
        String actualTextNearTheEmailField = mainPage.getTextNearTheEmailField();

        Assertions.assertThat(actualTextNearTheEmailField)
                .as("Text near the email field must be: Get our latest news and special sales")
                .isEqualTo(exceptedTextNearTheEmailField);

        String actualTextUnderEmailField = mainPage.getTextUnderEmailField();

        Assertions.assertThat(actualTextUnderEmailField).as("Text under email field must be:" +
                        " You may unsubscribe at any moment." +
                        "For that purpose, please find our contact info in the legal notice.")
                .isEqualTo(exceptedTextUnderEmailField);
        String actualLetterCaseOfSubscribeButton = mainPage.checkThatCharactersOnSubscribeButtonInUpperCase();

        Assertions.assertThat(actualLetterCaseOfSubscribeButton).as("Subscribe button must be in: uppercase")
                .isEqualTo(exceptedLetterCaseOfSubscribeButton);
    }
}
