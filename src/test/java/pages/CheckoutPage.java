package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutPage extends BasePage {

    private static final By FIRST_NAME_INPUT = By.id("first-name");
    private static final By LAST_NAME_INPUT = By.id("last-name");
    private static final By ZIP_CODE_INPUT = By.id("postal-code");
    private static final By CANCEL_BUTTON = By.xpath("//a[@class='cart_cancel_link btn_secondary']");
    private static final By CONTINUE_BUTTON = By.xpath("//input[@type='submit']");
    private static final By ITEM_TOTAL_LOCATOR = By.xpath("//*/div[@class='summary_subtotal_label']");
    private static final By TAX_LOCATOR = By.xpath("//*/div[@class='summary_tax_label']");
    private static final By TOTAL_LOCATOR = By.xpath("//*/div[@class='summary_total_label']");
    private static final By FINISH_BUTTON = By.xpath("//a[text()='FINISH']");
    private static final By COMPLETE_ORDER_STRING = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected CheckoutPage openPage() {
        return this;
    }

    @Override
    protected CheckoutPage isPageOpen() {
        return this;
    }

    public void verifyContinueToCheckout(String userName, String userSurname, int userZipCode) {
        writeText(FIRST_NAME_INPUT, userName);
        writeText(LAST_NAME_INPUT, userSurname);
        writeText(ZIP_CODE_INPUT, String.valueOf(userZipCode));
        click(CONTINUE_BUTTON);
        click(FINISH_BUTTON);
        waitForElementVisibility(COMPLETE_ORDER_STRING);
    }

    //TODO find a way to trim OR locate only value of price without text
//    public void verifyTaxCalculation() {
//        String itemPriceValue = driver.findElement(ITEM_TOTAL_LOCATOR).getText();
//        String taxValue = driver.findElement(TAX_LOCATOR).getText();
//        String totalPriceValue = driver.findElement(TOTAL_LOCATOR).getText();
//
//        int validateTaxValue = Integer.parseInt(itemPriceValue) * 8 / 100;
//        int validateTotalPriceValue = validateTaxValue + Integer.parseInt(itemPriceValue);
//
//        Assert.assertEquals(Integer.parseInt(taxValue), validateTaxValue);
//        Assert.assertEquals(Integer.parseInt(totalPriceValue), validateTotalPriceValue);
//    }
}
