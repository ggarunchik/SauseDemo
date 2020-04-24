package tests;

import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loginWithRegularUser() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.verifyInventoryVisibility();
    }

    @Test
    public void loginWithLockedUser() {
        loginPage.openPage();
        loginPage.login("locked_out_user", "secret_sauce");
        loginPage.verifyLongErrorPopUp();
    }

}
