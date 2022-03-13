package trangbui.selenium.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import trangbui.selenium.common.Constants;
import trangbui.selenium.common.Log;

import javax.swing.*;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Constants.WAIT_10, Constants.WAIT_120);
    }

    protected void myWait(int seconds) {
        try {
            wait(seconds);
        } catch (Exception e) {
            Log.debug(e.getMessage());
        }
    }

    protected void waitForElementToAppear(By element) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
    }


    protected void waitForElementToDisappear(By element) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    protected void writeText(By element, String text) {
        waitForElementToAppear(element);
        driver.findElement(element).sendKeys(text);
    }

    protected void writeText(By element, String text, Integer index) {
        waitForElementToAppear(element);
        driver.findElements(element).get(index).sendKeys(text);
    }

    protected String readText(By element) {
        waitForElementToAppear(element);
        return driver.findElement(element).getText();
    }

    protected void click (By element) {
        waitForElementToAppear(element);
        WebElement el = driver.findElements(element).get(0);
        Actions actions = new Actions(driver);
        try {
            actions.moveToElement(el).click().perform();
        } catch (Exception e) {
            myWait(1);
            actions.moveToElement(el).click().perform();
        }
    }

    protected void click (By element, Integer index) {
        waitForElementToAppear(element);
        WebElement el = driver.findElements(element).get(index);
        Actions actions = new Actions(driver);
        actions.moveToElement(el).click().perform();
    }

    protected void assertEquals(By element, String expectedText) {
        waitForElementToAppear(element);
        Assert.assertEquals(readText(element), expectedText);
    }

    protected void assertTrue(By element, String expectedText) {
        waitForElementToAppear(element);
        Assert.assertTrue(readText(element).contains(expectedText));
    }

    // Other Utilities

    public String getTitle() {
        return driver.getTitle();
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public String getSource() {
        return driver.getPageSource();
    }
}


