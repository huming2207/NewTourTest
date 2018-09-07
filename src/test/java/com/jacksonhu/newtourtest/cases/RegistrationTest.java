package com.jacksonhu.newtourtest.cases;

import com.jacksonhu.newtourtest.ConstantValues;
import com.jacksonhu.newtourtest.pages.RegSuccessfulPage;
import com.jacksonhu.newtourtest.pages.RegistrationPage;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RegistrationTest extends BaseTest
{
    private RegistrationPage page;

    public RegistrationTest(WebDriver webDriver)
    {
        super(webDriver, "RegistrationTest");
    }

    public void performValidRegistration()
    {
        webDriver.get("http://newtours.demoaut.com/mercurywelcome.php");

        // Go to the register page and register an account
        webDriver.findElement(By.partialLinkText("REGISTER")).click();
        RegistrationPage page = PageFactory.initElements(this.webDriver, RegistrationPage.class);


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