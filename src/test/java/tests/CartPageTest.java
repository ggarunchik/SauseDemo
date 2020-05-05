package tests;

import models.User;
import org.testng.annotations.Test;

public class CartPageTest extends BaseTest {
    private static final User userRegular = new User("standard_user", "secret_sauce");

    @Test
    public void verifyCartItems() {
        loginPage
                .openPage()
                .tryToLogin(userRegular);
        productsPage
                .addToCart("Sauce Labs Fleece Jacket")
                .addToCart("Sauce Labs Bolt T-Shirt")
                .addToCart("Sauce Labs Onesie");
        cartPage.openPage()
                .validateProductsAmount(3)
                .verifyItemAmountBadge(3);
    }

    @Test
    public void verifyUserCanRemoveItem() {
        verifyCartItems();
        cartPage
                .removeItemFromCart("Sauce Labs Onesie")
                .validateProductsAmount(2)
                .verifyItemAmountBadge(2);
    }

    @Test
    public void verifyUserCanContinueShopping() {
        verifyCartItems();
        cartPage.clickContinueShopping();
        cartPage.verifyItemAmountBadge(3);
    }

    @Test
    public void continueShoppingSideMenu() {
        verifyCartItems();
        sideMenuPage
                .openPage()
                .clickAllItemsButton();
        productsPage.verifyInventoryVisibility();
        cartPage.verifyItemAmountBadge(3);
    }
}
