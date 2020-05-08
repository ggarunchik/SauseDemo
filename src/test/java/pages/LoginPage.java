package pages;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final By USERNAME_INPUT = By.id("user-name");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.cssSelector(".btn_action");
    private static final By ERROR_LOCATOR = By.xpath("//*/h3[@data-test='error']");

    private static final String LOGIN_URL = "https://www.saucedemo.com/";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage openPage() {
        driver.get(LOGIN_URL);
        isPageOpen();
        return this;
    }

    @Override
    protected LoginPage isPageOpen() {
        waitForElementVisibility(LOGIN_BUTTON);
        return this;
    }

    public LoginPage tryToLogin(User user) {
        inputText(USERNAME_INPUT, user.getUserName());
        inputText(PASSWORD_INPUT, user.getUserPassword());
        click(LOGIN_BUTTON);
        return this;
    }

    public ProductsPage loginAndContinue(User user) {
        tryToLogin(user);
        return new ProductsPage(driver);
    }

    public LoginPage verifyErrorPopUp() {
        waitForElementVisibility(ERROR_LOCATOR);
        return this;
    }

}
