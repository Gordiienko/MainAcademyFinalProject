package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginAccountPage extends BasePage {
    private final By createAccountLink = By.xpath("//a[contains(text(),'No account?')]");

    @Step("Click on 'Create account' link")
    public void clickCreateAccountLink() {
        waitUntilElementClickable(createAccountLink, 10).click();
    }
}
