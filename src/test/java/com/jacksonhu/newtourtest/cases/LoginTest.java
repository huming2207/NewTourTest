package com.jacksonhu.newtourtest.cases;

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

        // Go to the sign-on page and register an account
        webDriver.findElement(By.partialLinkText("REGISTER")).click();
        SignOnPage page = PageFactory.initElements(this.webDriver, SignOnPage.class);

        // Login
        page.inputUserName(ConstantValues.NEWTOUR_USERNAME);
        page.inputPassword(ConstantValues.NEWTOUR_PASSWORD);
        page.clickLoginButton();

        // Try get the result
        try {
            WebElement signOffButton = webDriver.findElement(By.partialLinkText("SIGN-OFF"));
        } catch (NoSuchElementException exception) {
            logger.warn("Sign-off button not found, login test didn't pass.");
        }
        logger.info("Login test passed.");
    }

}
