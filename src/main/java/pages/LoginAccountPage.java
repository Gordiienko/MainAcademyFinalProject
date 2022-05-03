package pages;

import org.openqa.selenium.By;

public class LoginAccountPage extends BasePage{
    private final By createAccountLink = By.xpath("//a[contains(text(),'No account?')]");

    public void clickCreateAccountLink(){
        waitUntilElementClickable(createAccountLink,10).click();
    }
}
