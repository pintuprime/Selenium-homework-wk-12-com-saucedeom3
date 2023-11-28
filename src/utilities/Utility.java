package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;

public class Utility extends BaseTest {
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
        //WebElement webElement = driver.findElement(by);
        //String text = webElement.getText();
        //return text;
    }
    public boolean verifyTextDisplayed(By by, String expectedText) {
        boolean actualText =
                (driver.findElement(by).getText()).contains(expectedText);
        // Find and get actual text on page and check whether it contains expected text or not?
        assert actualText : "Text is not found: " + expectedText;
        return true;
    }

    public boolean verifyNumberFromElement(By by, int expectedNumber) {
        int actualNumber = driver.findElements(by).size();
        assert actualNumber == expectedNumber : "Expected Number of items not displayed: " + expectedNumber;
        return true;
    }

}
