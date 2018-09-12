package com.jacksonhu.newtourtest.tests;

import com.jacksonhu.newtourtest.ConstantValues;
import com.jacksonhu.newtourtest.SeleniumService;
import com.jacksonhu.newtourtest.pages.SignOnPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.UUID;

public class LoginTest extends BaseTest
{
    public LoginTest()
    {
        super(SeleniumService.getWebDriver(), "#4, LoginTest");
    }

    /**
     * #4.1, Login/Sign in into the system with empty credential (should fail)
     */
    public void performInvalidEmptyLogin()
    {
        logger.info("Step 1, Testing invalid login (doesn't input anything)");
        this.runLogin("", "");

        // Try get the result
        try {
            webDriver.findElement(By.partialLinkText("SIGN-OFF"));
        } catch (NoSuchElementException exception) {
            logger.warn("Sign-off button not found, test passed.");
            return;
        }
        logger.info("Login test failed. What the hell? Why I can login with nothing??");
    }

    /**
     * #4.2, Login/Sign into the system with a invalid, random string (UUID)
     */
    public void performInvalidLoginWithRandomStr()
    {
        logger.info("Step 2, Testing invalid login (random string, non-existence account)");
        this.runLogin(ConstantValues.NEWTOUR_USERNAME, ConstantValues.NEWTOUR_PASSWORD);

        // Try get the result
        try {
            webDriver.findElement(By.partialLinkText("SIGN-OFF"));
        } catch (NoSuchElementException exception) {
            logger.warn("Sign-off button not found, test passed.");
            return;
        }
        logger.info("Login test failed. What the hell? Why I can login with these weird things???");
    }

    /**
     * #4.3, Login/Sign into the system with correct credential (the one just registered)
     */
    public void performLogin()
    {
        logger.info("Step 3, Testing valid login");
        this.runLogin(ConstantValues.NEWTOUR_USERNAME, ConstantValues.NEWTOUR_PASSWORD);

        // Try get the result
        try {
            webDriver.findElement(By.partialLinkText("SIGN-OFF"));
        } catch (NoSuchElementException exception) {
            logger.warn("Sign-off button not found, login test didn't pass.");
            return;
        }
        logger.info("Login test passed.");
    }

    private void runLogin(String userName, String password)
    {
        webDriver.get("http://newtours.demoaut.com/mercurywelcome.php");

        // Force log off when necessary
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
        page.inputUserName(userName);
        page.inputPassword(password);
        page.clickLoginButton();

    }
}
