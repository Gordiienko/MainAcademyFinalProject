package models;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import static utils.Formatter.getPrice;


@Data
public class PriceOfDropProductModel {
    private String newPrice;
    private String oldPrice;
    private String discount;

    public PriceOfDropProductModel(WebElement container) {

        this.newPrice = container.findElement(By.xpath(".//div//span[@class=\"price\"]")).getText();
        this.oldPrice = container.findElement(By.xpath(".//div//span[@class=\"regular-price\"]")).getText();
        this.discount = container.findElement(By.xpath(".//li[@class=\"product-flag discount\"]")).getText();
    }

    public double getDiscountFromProducts() {
        double oldPrice = getPrice(this.oldPrice);
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);

        DecimalFormat df = new DecimalFormat("##.##", symbols);

        df.setRoundingMode(RoundingMode.CEILING);
        double result = (oldPrice / 100) * Integer.valueOf(this.discount.replaceAll("\\D", ""));
        return Double.valueOf(df.format(result));
    }

}
