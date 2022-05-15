package prestaShopTests;

import models.ProductModel;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.List;


public class CheckPopularProductsTest extends BaseTest {

    @Test(description = "Check size and valid date of popular products section")
    public void checkSizeAndValidDateOfPopularProductsSection() {
        MainPage mainPage = new MainPage();
        SoftAssertions softAssertions = new SoftAssertions();
        List<ProductModel> products = mainPage.getProductsFromProductsSection();
        softAssertions.assertThat(products.size())
                .as("In POPULAR PRODUCTS section must be 8 products").isEqualTo(8);
        for (ProductModel product : products) {
            softAssertions.assertThat(product.getName())
                    .as("sda").isNotNull();
            softAssertions.assertThat(product.getPrice())
                    .as("sda").isNotNull();
            softAssertions.assertThat(product.getPriceValue())
                    .as("sda").isGreaterThan(0.00);
        }
        softAssertions.assertAll();
    }
}
