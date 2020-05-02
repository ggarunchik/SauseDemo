package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private String ADD_TO_CART_LOCATOR = "//*[text()='%s']/../../..//button";
    private String REMOVE_FROM_CART_LOCATOR = "//*[text()='%s']/../../..//button";
    private static final By CONTINUE_SHOPPING_BUTTON = By.cssSelector(".btn_secondary");
    private static final By CHECKOUT_BUTTON = By.cssSelector(".btn_action");
    private static final By INVENTORY_VISIBILITY_LOCATOR = By.id("inventory_container");
    private static final String CART_CSS = ".shopping_cart_link";



    private static final String PRODUCTS_URL = "https://www.saucedemo.com/inventory.html";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductsPage openPage() {
        driver.get(PRODUCTS_URL);
        isPageOpen();
        return this;
    }

    @Override
    protected ProductsPage isPageOpen() {
        waitForElementVisibility(INVENTORY_VISIBILITY_LOCATOR);
        return this;
    }

    public ProductsPage addToCart(String productName) {
        By addToCartXpath = By.xpath(String.format(ADD_TO_CART_LOCATOR, productName));
        driver.findElement(addToCartXpath).click();
        return this;
    }

    public void removeItemFromCart(String productName) {
        By addToCartXpath = By.xpath(String.format(REMOVE_FROM_CART_LOCATOR, productName));
        driver.findElement(addToCartXpath).click();
    }

    public void verifyInventoryVisibility() {
        waitForElementVisibility(INVENTORY_VISIBILITY_LOCATOR);
    }

    public CartPage clickCart() {
        driver.findElement(By.cssSelector(CART_CSS)).click();
        return new CartPage(driver);
    }
}
