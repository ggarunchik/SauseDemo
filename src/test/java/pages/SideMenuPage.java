package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SideMenuPage extends BasePage {

    private static final By SIDE_MENU_BUTTON = By.cssSelector(".bm-burger-button");
    private static final By CLOSE_SIDE_MENU_BUTTON = By.cssSelector(".bm-cross-button");
    private static final By ALL_ITEMS_BUTTON = By.id("inventory_sidebar_link");
    private static final By ABOUT_BUTTON = By.id("about_sidebar_link");
    private static final By LOGOUT_BUTTON = By.id("logout_sidebar_link");
    private static final By RESET_APP_BUTTON = By.id("reset_sidebar_link");

    public SideMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SideMenuPage openPage() {
        click(SIDE_MENU_BUTTON);
        isPageOpen();
        return this;
    }

    @Override
    protected SideMenuPage isPageOpen() {
        waitForElementVisibility(CLOSE_SIDE_MENU_BUTTON);
        return this;
    }

    public ProductsPage clickAllItemsButton() {
        click(ALL_ITEMS_BUTTON);
        return new ProductsPage(driver);
    }

    public SideMenuPage clickAboutButton() {
        click(ABOUT_BUTTON);
        String currentBrowserURL = driver.getCurrentUrl();
        Assert.assertEquals(currentBrowserURL, "https://saucelabs.com/");
        return this;
    }

    public LoginPage clickLogoutButton() {
        click(ABOUT_BUTTON);
        return new LoginPage(driver);
    }
}
