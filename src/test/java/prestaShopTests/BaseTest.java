package prestaShopTests;

import core.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

    @BeforeMethod
    public synchronized void setUp() {
        DriverManager.setUpDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void quite() {
        DriverManager.quiteDriver();
    }
}

