package com.automationpractice.methods;

import com.automationpractice.driver.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Methods {
    WebDriver webDriver;
    JavascriptExecutor jsDriver;
    FluentWait<WebDriver> wait;

    public Methods() {
        webDriver = BaseTest.webDriver;
        jsDriver = (JavascriptExecutor) webDriver;
        wait = new FluentWait<>(webDriver);
        wait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
    }

    public void waitUntilElementLocated(By el) {
        wait.until(ExpectedConditions.presenceOfElementLocated(el));
    }

    public void waitUntilElementCliclable(By el) {
        wait.until(ExpectedConditions.elementToBeClickable(el));
    }

    public WebElement findElement(By el) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(el));
    }

    public List<WebElement> findElements(By el) {
        return webDriver.findElements(el);
    }

    public void clickElement(By el) {
        findElement(el).click();
    }

    public boolean isElementSelected(By el) {
        return findElement(el).isSelected();
    }

    public boolean isElementVisible(By el) {
        return findElement(el).isDisplayed();
    }

    public void sendKeysToElement(By el, String txt) {
        findElement(el).sendKeys(txt);
    }

    public void clearElement(By el) {
        findElement(el).clear();
    }

    public void scrollToElement(By el) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(findElement(el)).build().perform();
    }

    public Select getSelect(By el) {
        return new Select(findElement(el));
    }

    public void selectByText(By el, String txt) {
        getSelect(el).selectByVisibleText(txt);
    }

    public void selectByValue(By el, String val) {
        getSelect(el).selectByValue(val);
    }

    public String getSelectedText(By el) {
        return new Select(findElement(el)).getFirstSelectedOption().getText();
    }

    public String getElementsAttribute(By el, String attr) {
        return findElement(el).getAttribute(attr);
    }

    public String getElementsText(By el) {
        return findElement(el).getText();
    }

    public String getElementsValue(By el) {
        return jsDriver.executeScript("return arguments[0].value;", findElement(el)).toString();
    }

}
