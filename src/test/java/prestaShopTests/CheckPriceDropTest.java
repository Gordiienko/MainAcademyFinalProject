package prestaShopTests;

import models.PriceOfDropProductModel;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.PriceDropPage;

import java.util.List;

import static utils.Formatter.getPrice;

public class CheckPriceDropTest extends BaseTest {

    @Test
    public void checkPriseOfProductInPriceDropPage() {
        MainPage mainPage = new MainPage();
        PriceDropPage priceDropPage = new PriceDropPage();
        SoftAssertions softAssertions = new SoftAssertions();
        mainPage.openMainPage();
        mainPage.clickOnPriceDropLink();
        List<PriceOfDropProductModel> products = priceDropPage.getProductsFromPriceDropPage();
        for (PriceOfDropProductModel product : products) {
            softAssertions.assertThat(product.getOldPrice())
                    .as("In products must be value of old price").isNotNull();
            softAssertions.assertThat(product.getNewPrice())
                    .as("In products must be value of new price").isNotNull();
            softAssertions.assertThat(product.getDiscountFromProducts() + getPrice(product.getNewPrice()))
                    .as("products discount should be 20%").isEqualTo(getPrice(product.getOldPrice()));
        }
        softAssertions.assertAll();
    }
}
