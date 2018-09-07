package com.jacksonhu.newtourtest.cases;

import com.jacksonhu.newtourtest.ConstantValues;
import com.jacksonhu.newtourtest.SeleniumService;
import com.jacksonhu.newtourtest.pages.RegSuccessfulPage;
import com.jacksonhu.newtourtest.pages.RegistrationPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RegistrationTest extends BaseTest
{

    public RegistrationTest()
    {
        super(SeleniumService.getWebDriver(), "#3, RegistrationTest");
    }

    /**
     * Step #3, Registration
     */
    public void performValidRegistration()
    {
        RegistrationPage page = PageFactory.initElements(webDriver, RegistrationPage.class);

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

        // Validate the result
        // After login it should have a sign off button on the top menu, but actually it doesn't have.
        try {
            RegSuccessfulPage successfulPage = PageFactory.initElements(this.webDriver, RegSuccessfulPage.class);

            logger.info("Got registration result, start output");
            for(WebElement element : successfulPage.getRegistrationResultTexts()) {
                logger.info(element.getText());
            }
        } catch (NoSuchElementException element) {
            logger.warn("Element not found, failed to load the registration page");
        }
    }
}
