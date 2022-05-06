package prestaShopTests;

import org.assertj.core.api.Assertions;
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
        mainPage.openClothesCategory();
        for (String category : clothesCategories) {
            Assertions.assertThat(mainPage.categoryIsDisplayed(category)).isTrue();
        }
        mainPage.openAccessoriesCategory();
        for (String category : accessoriesCategories) {
            Assertions.assertThat(mainPage.categoryIsDisplayed(category)).isTrue();
        }
        mainPage.openArtCategory();
        Assertions.assertThat(mainPage.subCategoryIsDisplayed()).isFalse();
    }
}
