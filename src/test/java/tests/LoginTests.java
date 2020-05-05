package tests;

import models.User;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    private static final User userRegular = new User("standard_user", "secret_sauce");
    private static final User userLocked = new User("locked_out_user", "secret_sauce");

    @Test
    public void loginWithRegularUser() {
        loginPage
                .openPage()
                .loginAndContinue(userRegular);
        productsPage
                .verifyInventoryVisibility();
    }

    @Test
    public void loginWithLockedUser() {
        loginPage
                .openPage()
                .tryToLogin(userLocked)
                .verifyErrorPopUp();
    }

}
