package tests;

import models.User;
import org.testng.annotations.Test;

public class CartPageTest extends BaseTest {
    private static final User userRegular = new User("standard_user", "secret_sauce");

    @Test(description = "Verify user can add products to the cart" )
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

    @Test(description = "Verify user can remove products to the cart" )
    public void verifyUserCanRemoveItem() {
        verifyCartItems();
        cartPage
                .removeItemFromCart("Sauce Labs Onesie")
                .validateProductsAmount(2)
                .verifyItemAmountBadge(2);
    }

    @Test(description = "Verify user can continue shopping")
    public void verifyUserCanContinueShopping() {
        verifyCartItems();
        cartPage.clickContinueShopping();
        cartPage.verifyItemAmountBadge(2);
    }

    @Test(description = "Verify user can continue shopping from side menu")
    public void continueShoppingSideMenu() {
        verifyCartItems();
        sideMenuPage
                .openPage()
                .clickAllItemsButton();
        productsPage.verifyInventoryVisibility();
        cartPage.verifyItemAmountBadge(3);
    }
}
