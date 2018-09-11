package com.jacksonhu.newtourtest.tests;

import com.jacksonhu.newtourtest.ConstantValues;
import com.jacksonhu.newtourtest.SeleniumService;
import com.jacksonhu.newtourtest.pages.SignOnPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginTest extends BaseTest
{
    public LoginTest()
    {
        super(SeleniumService.getWebDriver(), "#4, LoginTest");
    }

    /**
     * Step #4, Login/Sign in into the system
     */
    public void performLogin()
    {
        logger.info("Testing login...");
        webDriver.get("http://newtours.demoaut.com/mercurywelcome.php");

        // Firstly, log off the current session
        try {
            WebElement signOffButton = webDriver.findElement(By.partialLinkText("SIGN-OFF"));
            signOffButton.click();
            logger.info("Logged off from previous session successfully.");
        } catch (NoSuchElementException exception) {
            logger.warn("Sign-off button not found, continue to log in directly");
        }

        // Go to the sign-on page and register an account
        try {
            webDriver.findElement(By.partialLinkText("SIGN-ON")).click();
        } catch (NoSuchElementException exception) {
            logger.warn("Sign-in button does not exist, have you already signed in?");
        }


        SignOnPage page = PageFactory.initElements(this.webDriver, SignOnPage.class);

        // Login
        page.inputUserName(ConstantValues.NEWTOUR_USERNAME);
        page.inputPassword(ConstantValues.NEWTOUR_PASSWORD);
        page.clickLoginButton();

        // Try get the result
        try {
            webDriver.findElement(By.partialLinkText("SIGN-OFF"));
        } catch (NoSuchElementException exception) {
            logger.warn("Sign-off button not found, login test didn't pass.");
            return;
        }
        logger.info("Login test passed.");
    }

}
