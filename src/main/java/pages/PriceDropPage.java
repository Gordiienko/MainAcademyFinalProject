package pages;

import models.PriceOfDropProductModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PriceDropPage extends BasePage {
    private final By productContainerFromPriceDropPage = By.className("reviews-loaded");

    public List<PriceOfDropProductModel> getProductsFromPriceDropPage() {
        waitUntilElementPresence(productContainerFromPriceDropPage, 10);
        List<PriceOfDropProductModel> products = new ArrayList<>();
        List<WebElement> containers = findAll(productContainerFromPriceDropPage);
        for (WebElement container : containers) {
            products.add(new PriceOfDropProductModel(container));
        }
        return products;
    }


}
