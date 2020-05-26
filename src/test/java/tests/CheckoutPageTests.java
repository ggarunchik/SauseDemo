package tests;

import models.User;
import org.testng.annotations.Test;

public class CheckoutPageTests extends BaseTest {
    private static final User userRegular = new User("standard_user", "secret_sauce");

    @Test(description = "Verify checkout process")
    public void verifyCheckoutProcess() {
        loginPage
                .openPage()
                .tryToLogin(userRegular);
        productsPage
                .addToCart("Sauce Labs Fleece Jacket")
                .addToCart("Sauce Labs Bolt T-Shirt")
                .addToCart("Sauce Labs Onesie");
        cartPage.openPage()
                .validateProductsAmount(3)
                .continueCheckout();
        checkoutPage
                .verifyContinueToCheckout("Gleb", "Glebowski", 20039);
    }
}
