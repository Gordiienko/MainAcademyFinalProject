package prestaShopTests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.Arrays;
import java.util.List;

public class CheckCategoriesTest extends BaseTest {
    @Test
    public void checkThatCategoryMenAndWomenIsVisible() {
        List<String> clothesCategories = Arrays.asList("Men", "Women");
        List<String> accessoriesCategories = Arrays.asList("Stationery", "Home Accessories");
        MainPage mainPage = new MainPage();
        SoftAssertions softAssertions = new SoftAssertions();
        mainPage.openMainPage();
        mainPage.hoverMouseClothesCategory();
        for (String category : clothesCategories) {
            softAssertions.assertThat(mainPage.categoryIsDisplayed(category))
                    .as("In the category, 'Clothes' should be sub menu 'MEN' and 'WOMEN'").isTrue();
        }
        mainPage.hoverMouseAccessoriesCategory();
        for (String category : accessoriesCategories) {
            softAssertions.assertThat(mainPage.categoryIsDisplayed(category))
                    .as("In the category, 'Accessories' should be sub menu 'Stationery' and 'Accessories'")
                    .isTrue();
        }
        mainPage.hoverMouseArtCategory();
        softAssertions.assertThat(mainPage.subCategoryIsDisplayed())
                .as("In the 'Art' category, there should be no submenu").isFalse();
        softAssertions.assertAll();
    }
}
