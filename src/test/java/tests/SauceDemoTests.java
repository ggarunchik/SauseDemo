package tests;

import models.User;
import org.testng.annotations.Test;

public class SauceDemoTests extends BaseTest {

    @Test
    public void demoTestsFromLecture() {
        User user = new User("standard_user", "secret_sauce");
        loginPage.openPage();
        loginPage.tryToLogin(user);
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage();
        cartPage.validateProductsAmount(1);
        cartPage.validateProductDetails("Sauce Labs Fleece Jacket", 1, 49.99);
    }

    @Test
    public void loginWithPageFactoryPattern() {
        User user = new User("standard_user", "secret_sauce");
        loginPageFactory
                .openPage()
                .login(user)
                .addToCart("Sauce Labs Fleece Jacket")
                .addToCart("Sauce Labs Bolt T-Shirt")
                .clickCart()
                .validateProductsAmount(2);

    }
}
