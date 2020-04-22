package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private static final By USERNAME_INPUT = By.cssSelector(".product_sort_container");
    private String ADD_TO_CART_LOCATOR = "//*[text()='%s']/../../..//button";
    private static final By LOGIN_BUTTON = By.xpath("//*[text()='Sauce Labs Backpack']/../../..//div");

    private static final String PRODUCTS_URL = "https://www.saucedemo.com/inventory.html";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(PRODUCTS_URL);
    }

    public void addToCart(String productName) {
        By addToCartXpath = By.xpath(String.format(ADD_TO_CART_LOCATOR, productName));
        driver.findElement(addToCartXpath).click();
    }
}
