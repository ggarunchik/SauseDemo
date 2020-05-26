package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.AllureUtils;

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

    @Step("Opening Cart Page")
    @Override
    public CartPage openPage() {
        driver.get(CART_URL);
        isPageOpen();
        return this;
    }

    @Step("Verifying is Cart Page open")
    @Override
    protected CartPage isPageOpen() {
        waitForElementVisibility(CHECKOUT_BTN);
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Checking that amount of products equals to: '{number}'")
    public CartPage validateProductsAmount(int number) {
        Assert.assertEquals(driver.findElements(CART_ITEM).size(), number, "Quantity is invalid");
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Checking that product: '{productName}' has quantity: '{quantity}' and price: '{price}'")
    public void validateProductDetails(String productName, int quantity, double price) {
        String actualQuantity = driver.findElement(By.xpath(String.format(productQuantityLocator, productName))).getText();
        Assert.assertEquals(actualQuantity, String.valueOf(quantity), "Quantity is invalid");
        String actualPrice = driver.findElement(By.xpath(String.format(productPriceLocator, productName))).getText();
        Assert.assertEquals(actualPrice, String.valueOf(price), "Price is invalid");
        AllureUtils.takeScreenshot(driver);
    }

    @Step("Proceeding to checkout")
    public CheckoutPage continueCheckout() {
        click(CHECKOUT_BTN);
        AllureUtils.takeScreenshot(driver);
        return new CheckoutPage(driver);
    }

    @Step("Removing item: '{productName}' from the cart")
    public CartPage removeItemFromCart(String productName) {
        By removeFromCart = By.xpath(String.format(REMOVE_FROM_CART_LOCATOR, productName));
        driver.findElement(removeFromCart).click();
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Clicking on continue shopping button")
    public ProductsPage clickContinueShopping() {
        click(CONTINUE_SHOPPING_BUTTON);
        AllureUtils.takeScreenshot(driver);
        return new ProductsPage(driver);
    }

    @Step("Verifying that badge number is: '{expectedItemAmount}'")
    public CartPage verifyItemAmountBadge(int expectedItemAmount) {
        int badgeValue = Integer.parseInt(driver.findElement(ITEM_AMOUNT_BADGE).getText());
        assertEquals(badgeValue, expectedItemAmount);
        AllureUtils.takeScreenshot(driver);
        return this;
    }
}