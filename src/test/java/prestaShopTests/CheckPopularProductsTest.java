package prestaShopTests;

import models.ProductModel;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.List;

import static utils.Formatter.getPrice;


public class CheckPopularProductsTest extends BaseTest {

    @Test(description = "Check size and valid date of popular products section")
    public void checkSizeAndValidDateOfPopularProductsSection() {
        MainPage mainPage = new MainPage();
        SoftAssertions softAssertions = new SoftAssertions();
        mainPage.openMainPage();
        List<ProductModel> products = mainPage.getProductsFromProductsSection();
        softAssertions.assertThat(products.size())
                .as("In POPULAR PRODUCTS section must be 8 products").isEqualTo(8);
        for (ProductModel product : products) {
            softAssertions.assertThat(product.getName())
                    .as("The products must contain the product name").isNotNull();
            softAssertions.assertThat(product.getPrice())
                    .as("The products must contain the product price").isNotNull();
            softAssertions.assertThat(getPrice(product.getPrice()))
                    .as("The price of each product must be greater than 0.00").isGreaterThan(0.00);
        }
        softAssertions.assertAll();
    }
}
