package models;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Data
public class ProductModel {
    private String name;
    private String price;


    public ProductModel(WebElement container) {
        this.name = container.findElement(By.xpath(".//div//h3/a")).getText();
        this.price = container.findElement(By.xpath(".//div//span[@class=\"price\"]")).getText();
    }

    public Double getPriceValue() {
        return Double.valueOf(this.getPrice().replace("€", ""));
    }


}
