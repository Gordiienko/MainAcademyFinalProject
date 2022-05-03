package pages;

import org.openqa.selenium.By;

public class AccountPage extends BasePage{
    private final By accountName = By.xpath("//a[@class=\"account\"]");

    public String checkThatAccountNameAppear(){
       return waitUntilElementPresence(accountName,10).getText();
    }
}
