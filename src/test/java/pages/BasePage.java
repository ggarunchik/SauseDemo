package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    public void waitForElementVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
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
