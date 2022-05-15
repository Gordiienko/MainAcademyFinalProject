package models;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Data
public class AllProductModel {
    private String price;
    private String name;

    public AllProductModel(WebElement container) {

        this.price = container.findElement(By.xpath(".//span[@class=\"price\"]")).getText();
        this.name = container.findElement(By.xpath(".//h2[@class=\"h3 product-title\"]/a")).getText();
    }
}
