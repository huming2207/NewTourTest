package com.jacksonhu.newtourtest.tests;

import com.jacksonhu.newtourtest.SeleniumService;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class LogoffTest extends BaseTest
{
    public LogoffTest()
    {
        super(SeleniumService.getWebDriver(), "#8, LogoffTest");
    }

    /**
     * Step #8, log out
     */
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
