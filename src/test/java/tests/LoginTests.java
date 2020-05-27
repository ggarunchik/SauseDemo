package tests;

import io.qameta.allure.Description;
import models.User;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    private static final User userRegular = new User("standard_user", "secret_sauce");
    private static final User userLocked = new User("locked_out_user", "secret_sauce");

    @Ignore("It work but I left variant with steps in it")
    @Test
    public void loginWithRegularUser() {
        loginPage
                .openPage()
                .loginAndContinue(userRegular);
                //.loginWithProp(System.getProperty("user"), System.getProperty("password"));
        productsPage
                .verifyInventoryVisibility();
    }

    @Ignore("It work but I left variant with steps in it")
    @Test
    public void loginWithLockedUser() {
        loginPage
                .openPage()
                .tryToLogin(userLocked)
                .verifyErrorPopUp();
    }

    @Test(description = "Login with regular user")
    @Description("Demonstration of the steps description")
    public void loginWithRegularUserTest() {
        loginPageSteps.loginWithRegularUser(userRegular);
    }

    @Test(description = "Login with locked user")
    @Description("Demonstration of the steps description")
    public void loginWithLockedUserTest() {
        loginPageSteps.loginWithLockedUser(userLocked);
    }
}
