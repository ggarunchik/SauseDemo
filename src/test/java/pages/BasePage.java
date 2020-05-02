package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public abstract class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 15);
    }

    protected abstract BasePage openPage();
    protected abstract BasePage isPageOpen();

    public void waitForElementVisibility(By elementBy) {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
        } catch (TimeoutException ex) {
            Assert.fail("can't find element. dropped by timeout");
            ex.printStackTrace();
        }
    }

    public void click(By elementBy) {
        waitForElementVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    public void writeText(By elementBy, String text) {
        waitForElementVisibility(elementBy);
        clearField(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    public void clearField(By elementBy) {
        driver.findElement(elementBy).clear();
    }
}
