package models;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


@Data
public class PriceOfDropProductModel {
    private String newPrice;
    private String oldPrice;
    /*private String discount;*/

    public PriceOfDropProductModel(WebElement container) {

        this.newPrice = container.findElement(By.xpath(".//div//span[@class=\"price\"]")).getText();
        this.oldPrice = container.findElement(By.xpath(".//div//span[@class=\"regular-price\"]")).getText();
        /*this.discount = container.findElement(By.xpath(".//li[@class=\"product-flag discount\"]")).getText();*/
    }

    /*public double getPriceFromProducts() {
        double oldPrice = Double.valueOf(this.oldPrice.replace("€", ""));
        return (oldPrice / 100) * Integer.valueOf(this.discount.replaceAll("\\D", ""));
    }*/

}
