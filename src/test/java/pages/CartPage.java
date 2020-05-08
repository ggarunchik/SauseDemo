package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage extends BasePage {

    private String productQuantityLocator = "//*[contains(text(),'%s')]/../../..//div[@class='cart_quantity']";
    private String productPriceLocator = "//*[contains(text(),'%s')]/../../..//div[@class='inventory_item_price']";
    private String REMOVE_FROM_CART_LOCATOR = "//*[text()='%s']/../../..//button";
    private static final By CHECKOUT_BTN = By.cssSelector(".btn_action");
    private static final By CART_ITEM = By.cssSelector(".cart_item");
    private static final By CONTINUE_SHOPPING_BUTTON = By.cssSelector(".btn_secondary");
    private static final By ITEM_AMOUNT_BADGE = By.cssSelector(".shopping_cart_badge");

    private static final String CART_URL = "https://www.saucedemo.com/cart.html";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CartPage openPage() {
        driver.get(CART_URL);
        isPageOpen();
        return this;
    }

    @Override
    protected CartPage isPageOpen() {
        waitForElementVisibility(CHECKOUT_BTN);
        return this;
    }

    public CartPage validateProductsAmount(int number) {
        Assert.assertEquals(driver.findElements(CART_ITEM).size(), number, "Quantity is invalid");
        return this;
    }

    public void validateProductDetails(String productName, int quantity, double price) {
        String actualQuantity = driver.findElement(By.xpath(String.format(productQuantityLocator, productName))).getText();
        Assert.assertEquals(actualQuantity, String.valueOf(quantity), "Quantity is invalid");
        String actualPrice = driver.findElement(By.xpath(String.format(productPriceLocator, productName))).getText();
        Assert.assertEquals(actualPrice, String.valueOf(price), "Price is invalid");
    }

    public CheckoutPage continueCheckout() {
        click(CHECKOUT_BTN);
        return new CheckoutPage(driver);
    }

    public CartPage removeItemFromCart(String productName) {
        By removeFromCart = By.xpath(String.format(REMOVE_FROM_CART_LOCATOR, productName));
        driver.findElement(removeFromCart).click();
        return this;
    }

    public ProductsPage clickContinueShopping() {
        click(CONTINUE_SHOPPING_BUTTON);
        return new ProductsPage(driver);
    }

    public CartPage verifyItemAmountBadge(int expectedItemAmount) {
        int badgeValue = Integer.parseInt(driver.findElement(ITEM_AMOUNT_BADGE).getText());
        assertEquals(badgeValue, expectedItemAmount);
        return this;
    }
}