package com.insider.utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtilities {

    public static void switchToWindow(String targetTitle, WebDriver driver) {
        String origin = Driver.get().getWindowHandle();
        for (String handle : Driver.get().getWindowHandles()) {
            Driver.get().switchTo().window(handle);
            if (Driver.get().getTitle().contains(targetTitle)) {
                return;
            }
        }
        Driver.get().switchTo().window(origin);
    }

    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(element).perform();
    }

    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getAttribute("innerHTML"));
        }
        return elemTexts;
    }

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", element);
    }


    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    public static void waitForPresenceOfElement(By by, long time) {
        new WebDriverWait(Driver.get(), time).until(ExpectedConditions.presenceOfElementLocated(by));
    }


    public static void scrollDown(WebElement element, int num) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        for (int i = 0; i < num; i++) {
            jse.executeScript("window.scrollBy(0,250)");
        }
    }

    public static void scrollUp(WebElement element, int num) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        for (int i = 0; i < num; i++) {
            jse.executeScript("window.scrollBy(0,-250)");
        }
    }

    public static void selectDropdownElementByText(WebElement element, String elementText) {
        waitForVisibility(element, 5);
        Select select = new Select(element);
        select.selectByVisibleText(elementText);
        Assert.assertEquals(elementText, select.getFirstSelectedOption().getText());
    }

    public static void verifySelectedDropdownElement(WebElement element, String elementText) {
        waitForVisibility(element, 5);
        Select select = new Select(element);
        Assert.assertEquals(elementText, select.getFirstSelectedOption().getText());
    }

}
