package by.bntu.lms.pages;


import by.bntu.lms.waits.ExplicitWait;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.*;

public class AbstractPage {

    protected WebDriver driver;
    protected ExplicitWait wait;
    protected JavascriptExecutor jse;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new ExplicitWait(driver);
        jse = (JavascriptExecutor) driver;
    }

    protected void alertAccept() {
        wait.waitForAlert();
        driver.switchTo().alert().accept();
    }

    protected void sendKeysIntoWebElement(WebElement webElement, String text) {
        waitForElementIsClickableAndClick(webElement);
        webElement.clear();
        webElement.sendKeys(text);
    }

    protected void selectByVisibleText(WebElement webElement, String text) {
        wait.waitForElementIsClickable(webElement);
        new Select(webElement).selectByVisibleText(text);
    }

    protected void waitForElementIsClickableAndClick(WebElement webElement) {
        wait.waitForElementIsClickable(webElement);
        webElement.click();
    }

    protected void swichToFrame(WebElement webElement) {
        wait.waitForElementIsVisible(webElement);
        driver.switchTo().frame(webElement);
    }

    protected void waitForElementIsClickableAndClickUsingJS(WebElement webElement) {
        wait.waitForElementIsClickable(webElement);
        jse.executeScript("arguments[0].click();", webElement);
    }

    protected void openNewTab(String uri) {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(uri);
    }

    protected void switchToFirstTab() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

    public void takeScreenshot(String screenName,String path) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(path + screenName + ".png"));
    }

    protected void checkElementExistence(WebElement webElement){
        wait.waitForElementIsVisible(webElement);
    }

}