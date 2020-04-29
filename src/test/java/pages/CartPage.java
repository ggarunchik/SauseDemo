package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage extends BasePage {

    private String productQuantityLocator = "//*[contains(text(),'%s')]/../../..//div[@class='cart_quantity']";
    private String productPriceLocator = "//*[contains(text(),'%s')]/../../..//div[@class='inventory_item_price']";
    private static final By CHECKOUT_BTN = By.cssSelector(".btn_action");
    private static final By CART_ITEM = By.cssSelector(".cart_item");
    private static final String CART_URL = "https://www.saucedemo.com/cart.html";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(CART_URL);
    }

    public void validateProductsAmount(int number) {
        Assert.assertEquals(driver.findElements(CART_ITEM).size(), number, "Quantity is invalid");
    }

    public void validateProductDetails(String productName, int quantity, double price) {
        String actualQuantity = driver.findElement(By.xpath(String.format(productQuantityLocator, productName))).getText();
        Assert.assertEquals(actualQuantity, String.valueOf(quantity), "Quantity is invalid");
        String actualPrice = driver.findElement(By.xpath(String.format(productPriceLocator, productName))).getText();
        Assert.assertEquals(actualPrice, String.valueOf(price), "Price is invalid");
    }

    public void continueCheckout() {
        click(CHECKOUT_BTN);
    }
}