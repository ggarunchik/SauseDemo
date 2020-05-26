package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import utils.CapabilitiesGenerator;
import utils.TestListener;

@Listeners(TestListener.class)
public class BaseTest {

    private WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    LoginPageFactory loginPageFactory;
    SideMenuPage sideMenuPage;

    @BeforeMethod(description = "Creating webdriver with capabilities. Creating page objects")
    public void setUp() {
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        loginPageFactory = new LoginPageFactory(driver);
        sideMenuPage = new SideMenuPage(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Closing browser")
    public void closeBrowser() {
        driver.quit();
    }
}
