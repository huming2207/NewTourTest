package com.jacksonhu.newtourtest.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoffTest extends BaseTest
{
    public LogoffTest(WebDriver webDriver)
    {
        super(webDriver, "LogoffTest");
    }

    public void logOff()
    {
        WebElement logOffElement;
        try {
            logOffElement = webDriver.findElement(By.partialLinkText("SIGN-OFF"));
        } catch (NoSuchElementException exception) {
            logger.warn("Cannot log off, you haven't even logged in...");
            return;
        }

        // Click the log off link
        logOffElement.click();

        try {
            logOffElement = webDriver.findElement(By.partialLinkText("SIGN-ON"));
        } catch (NoSuchElementException exception) {
            logger.warn("Failed to log off for some unknown reasons...");
            return;
        }

        logger.info("Logged off successfully");
    }
}
