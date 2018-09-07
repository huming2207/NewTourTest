package com.jacksonhu.newtourtest.cases;

import com.jacksonhu.newtourtest.SeleniumService;
import org.openqa.selenium.By;

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
        webDriver.get("http://newtours.demoaut.com/mercurywelcome.php");

        // Go to the register page and register an account
        webDriver.findElement(By.partialLinkText("REGISTER")).click();
    }
}
