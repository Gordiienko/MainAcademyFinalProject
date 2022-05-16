package prestaShopTests;


import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class CheckLanguagesTest extends BaseTest {

    @Test(description = "Check how much languages in drop-down menu and presents of Ukrainian language")
    public void checkHowMuchLanguagesInDropDownMenu() {
        MainPage mainPage = new MainPage();
        String exceptedLanguageResult = "Українська";
        mainPage.openMainPage();
        mainPage.clickOnLanguageButton();
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(mainPage.getAllLanguageFromDropDownMenu().size())
                .as("Size of language must be: 44").isEqualTo(44);

        String actualLanguageResult = mainPage.findUkraineLanguageInDropDownMenu();

        softAssertions.assertThat(actualLanguageResult)
                .as("In Language drop down menu must be: Українська")
                .isEqualTo(exceptedLanguageResult);
        softAssertions.assertAll();
    }
}
