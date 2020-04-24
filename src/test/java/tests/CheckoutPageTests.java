package tests;

import org.testng.annotations.Test;

public class CheckoutPageTests extends BaseTest {

    @Test
    public void verifyCheckoutProcess() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        productsPage.addToCart("Sauce Labs Onesie");
        cartPage.openPage();
        cartPage.validateProductsAmount(3);
        cartPage.continueCheckout();
        checkoutPage.verifyContinueToCheckout("Gleb", "Glebowski", 20039);
    }
}
