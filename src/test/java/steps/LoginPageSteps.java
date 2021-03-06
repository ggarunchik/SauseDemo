package steps;

import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;
import utils.AllureUtils;

public class LoginPageSteps {
    private LoginPage loginPage;
    private ProductsPage productsPage;

    public LoginPageSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Step("Trying to login with user: '{user}'")
    public LoginPageSteps loginWithRegularUser(User user) {
        loginPage
                .openPage()
                .loginAndContinue(user);
        productsPage.verifyInventoryVisibility();
        return this;
    }

    @Step("Trying to login with user: '{user}'")
    public LoginPageSteps loginWithLockedUser(User user) {
        loginPage
                .openPage()
                .tryToLogin(user)
                .verifyErrorPopUp();
        return this;
    }

}
