package pages;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPageFactory extends BasePage{
    @FindBy(id="user-name")
    WebElement userNameInput;
    @FindBy(id="password")
    WebElement passwordInput;
    @FindBy(css=".btn_action")
    WebElement loginButton;
    private static final String LOGIN_URL = "https://www.saucedemo.com/";

    public LoginPageFactory(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPageFactory openPage() {
        driver.get(LOGIN_URL);
        PageFactory.initElements(driver, this);
        isPageOpen();
        return this;
    }

    @Override
    protected LoginPageFactory isPageOpen() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By) loginButton));
        return this;
    }

    public ProductsPage login(User user) {
        userNameInput.sendKeys(user.getUserName());
        passwordInput.sendKeys(user.getUserPassword());
        loginButton.click();
        return new ProductsPage(driver);
    }
}
