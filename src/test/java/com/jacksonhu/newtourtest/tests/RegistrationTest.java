package com.jacksonhu.newtourtest.tests;

import com.jacksonhu.newtourtest.ConstantValues;
import com.jacksonhu.newtourtest.SeleniumService;
import com.jacksonhu.newtourtest.pages.RegSuccessfulPage;
import com.jacksonhu.newtourtest.pages.RegistrationPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.UUID;

public class RegistrationTest extends BaseTest
{

    public RegistrationTest()
    {
        super(SeleniumService.getWebDriver(), "#3, RegistrationTest");
    }

    /**
     * Step #3, Registration
     */

    public void performInvalidRegistrationWithNothing()
    {
        webDriver.get("http://newtours.demoaut.com/mercuryregister.php");
        RegistrationPage page = PageFactory.initElements(webDriver, RegistrationPage.class);

        logger.info("#3.1, Testing invalid registration with no username/password");

        // Print the username and password
        logger.info("User name: (null)");
        logger.info("Password: (null)");

        // Submit the page
        page.clickRegisterButton();

        if(validateResult()) {
            logger.warn("Registration successful, test FAILED");
        } else {
            logger.info("Registration failed, test PASSED");
        }
    }

    public void performInvalidRegistrationWithInvalidInfo()
    {
        webDriver.get("http://newtours.demoaut.com/mercuryregister.php");
        RegistrationPage page = PageFactory.initElements(webDriver, RegistrationPage.class);

        logger.info("#3.2, Testing invalid registration with something nonsense");

        // Fill in the contents
        page.inputCity("Wellington");
        page.inputEmail(UUID.randomUUID().toString().substring(0, 30)); // Wrong Email
        page.inputFirstAddress("330 Swanston Street");
        page.inputFirstName("John");
        page.inputLastName("Durian");
        page.inputPasswords(ConstantValues.NEWTOUR_PASSWORD);
        page.inputUserName(ConstantValues.NEWTOUR_USERNAME);
        page.inputPostalCode("9001");
        page.inputState("New Zealand"); // Make New Zealand Australian Again!
        page.selectCountryByName("AUSTRALIA");
        page.inputPhoneNumber("+61411451400");

        // Print the username and password
        logger.info("User name: {}", ConstantValues.NEWTOUR_USERNAME);
        logger.info("Password: {}", ConstantValues.NEWTOUR_PASSWORD);

        // Submit the page
        page.clickRegisterButton();

        if(validateResult()) {
            logger.warn("Registration successful, test FAILED");
        } else {
            logger.info("Registration failed, test PASSED");
        }
    }

    public void performValidRegistration()
    {
        webDriver.get("http://newtours.demoaut.com/mercuryregister.php");
        RegistrationPage page = PageFactory.initElements(webDriver, RegistrationPage.class);

        logger.info("#3.3, Testing valid registration");

        // Fill in the contents
        page.inputCity("Melbourne");
        page.inputEmail("test@rmit.edu.au");
        page.inputFirstAddress("330 Swanston Street");
        page.inputFirstName("John");
        page.inputLastName("Durian");
        page.inputPasswords(ConstantValues.NEWTOUR_PASSWORD);
        page.inputUserName(ConstantValues.NEWTOUR_USERNAME);
        page.inputPostalCode("3001");
        page.inputState("Victoria");
        page.selectCountryByName("AUSTRALIA");
        page.inputPhoneNumber("+61411451400");

        // Print the username and password
        logger.info("User name: {}", ConstantValues.NEWTOUR_USERNAME);
        logger.info("Password: {}", ConstantValues.NEWTOUR_PASSWORD);

        // Submit the page
        page.clickRegisterButton();

        if(validateResult()) {
            logger.warn("Registration successful, test PASSED");
        } else {
            logger.info("Registration failed, test FAILED");
        }
    }

    private boolean validateResult()
    {
        // Validate the result
        try {
            RegSuccessfulPage successfulPage = PageFactory.initElements(this.webDriver, RegSuccessfulPage.class);

            logger.info("Got registration result, start output");
            for(WebElement element : successfulPage.getRegistrationResultTexts()) {
                logger.info(element.getText());
            }
            return true;
        } catch (NoSuchElementException element) {
            return false;
        }
    }
}
