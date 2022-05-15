package prestaShopTests;

import models.AllProductModel;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.AllProductsPage;
import pages.MainPage;
import java.util.List;

public class CheckAllProductDateTest extends BaseTest {

    @Test
    public void checkPriceAndNameOfAllProduct() {
        MainPage mainPage = new MainPage();
        AllProductsPage allProductsPage = new AllProductsPage();
        SoftAssertions softAssertions = new SoftAssertions();
        mainPage.clickOnAllProductsLink();
        allProductsPage.clickOnSortByButton();
        allProductsPage.clickOnSortByNameAToZ();
        List<AllProductModel> products = allProductsPage.getInfoFromAllProducts();
//        products.sort();

        }

    }

