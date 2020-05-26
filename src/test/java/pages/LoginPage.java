package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AllureUtils;

public class LoginPage extends BasePage {
    private static final By USERNAME_INPUT = By.id("user-name");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.cssSelector(".btn_action");
    private static final By ERROR_LOCATOR = By.xpath("//*/h3[@data-test='error']");

    private static final String LOGIN_URL = "https://www.saucedemo.com/";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening Login Page")
    @Override
    public LoginPage openPage() {
        driver.get(LOGIN_URL);
        isPageOpen();
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Verifying is Login Page open")
    @Override
    protected LoginPage isPageOpen() {
        waitForElementVisibility(LOGIN_BUTTON);
        return this;
    }

    @Step("Trying to login with data: '{user.getUserName()}', '{user.getUserPassword()}'")
    public LoginPage tryToLogin(User user) {
        inputText(USERNAME_INPUT, user.getUserName());
        inputText(PASSWORD_INPUT, user.getUserPassword());
        click(LOGIN_BUTTON);
        return this;
    }

    @Step("Trying to login and check Product Page is visible")
    public ProductsPage loginAndContinue(User user) {
        tryToLogin(user);
        AllureUtils.takeScreenshot(driver);
        return new ProductsPage(driver);
    }

    public ProductsPage loginWithProp(String userN, String userP) {
        inputText(USERNAME_INPUT,userN);
        inputText(PASSWORD_INPUT, userP);
        click(LOGIN_BUTTON);
        return new ProductsPage(driver);
    }

    @Step("Verifying Error Pop Up")
    public LoginPage verifyErrorPopUp() {
        waitForElementVisibility(ERROR_LOCATOR);
        return this;
    }

}
