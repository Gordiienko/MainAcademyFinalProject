package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AccountPage extends BasePage {
    private final By accountName = By.xpath("//a[@class=\"account\"]");

    @Step("Check that Account name appear")
    public String checkThatAccountNameAppear() {
        return waitUntilElementPresence(accountName, 10).getText();
    }
}
