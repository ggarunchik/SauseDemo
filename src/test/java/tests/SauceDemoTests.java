package tests;

import org.testng.annotations.Test;

public class SauceDemoTests extends BaseTest {

    @Test
    public void demoTestsFromLecture() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage();
        cartPage.validateProductsAmount(1);
        cartPage.validateProductDetails("Sauce Labs Fleece Jacket", 1, 49.99);
    }
}
