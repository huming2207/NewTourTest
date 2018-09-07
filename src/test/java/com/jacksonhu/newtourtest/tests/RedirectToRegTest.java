package com.jacksonhu.newtourtest.tests;

import com.jacksonhu.newtourtest.SeleniumService;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class RedirectToRegTest extends BaseTest
{
    public RedirectToRegTest()
    {
        super(SeleniumService.getWebDriver(), "#2, RedirectToRegTest");
    }

    /**
     * Step #2, redirection to registration page
     */
    public void redirectPage()
    {
        try {
            // Go to the register page and register an account
            webDriver.findElement(By.partialLinkText("REGISTER")).click();
            logger.info("Redirected to register page.");
        } catch (NoSuchElementException exception) {
            logger.warn("Redirection failed!");
        }
    }
}
