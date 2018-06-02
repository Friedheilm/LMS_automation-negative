package by.bntu.lms.waits;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
    private WebDriver driverWait;
    private Wait<WebDriver> wait;

    public ExplicitWait(WebDriver driver) {
        this.driverWait = driver;
        wait = new WebDriverWait(this.driverWait, 10)
                .ignoring(StaleElementReferenceException.class, WebDriverException.class)
                .withMessage("Element was not found by locator");
    }

    public void waitForElementIsClickable(WebElement element) {
        waitForElementIsVisible(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementIsVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementIsInvisible(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForPageToLoad() {
        wait.until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    public void waitForExpectedUri(String partOfUrl) {
        wait.until(ExpectedConditions.urlContains(partOfUrl));
    }

    public void waitForAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

}
