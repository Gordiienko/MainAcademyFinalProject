package prestaShopTests;

import models.PriceOfDropProductModel;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.PriceDropPage;

import java.util.List;

public class CheckPriceDropTest extends BaseTest {

    @Test
    public void checkPriseOfProductInPriceDropPage() {
        MainPage mainPage = new MainPage();
        PriceDropPage priceDropPage = new PriceDropPage();
        SoftAssertions softAssertions = new SoftAssertions();
        mainPage.clickOnPriceDropLink();
        List<PriceOfDropProductModel> products = priceDropPage.getProductsFromPriceDropPage();
        for (PriceOfDropProductModel product : products) {
            softAssertions.assertThat(product.getOldPrice())
                    .as("sda").isNotNull();
            softAssertions.assertThat(product.getNewPrice())
                    .as("sda").isNotNull();
            /*softAssertions.assertThat(product.getPriceFromProducts()+product.getNewPrice())
                    .as("dsa").isEqualTo(product.getOldPrice());*/
        }


        softAssertions.assertAll();
    }
}
