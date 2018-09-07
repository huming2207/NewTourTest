package com.jacksonhu.newtourtest.cases;

import com.jacksonhu.newtourtest.pages.ConfirmationPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BookingConfirmationTest extends BaseTest
{
    public BookingConfirmationTest(WebDriver webDriver)
    {
        super(webDriver, "BookingConfirmationTest");
    }

    public void listBookingConfirmation()
    {
        ConfirmationPage confirmationPage = null;
        try {
            confirmationPage = PageFactory.initElements(webDriver, ConfirmationPage.class);
            logger.info("Confirmation page loaded, start to print out the content...");
        } catch (NoSuchElementException exception) {
            logger.warn("Failed to load confirmation page!");
            return;
        }

        for(WebElement element : confirmationPage.getConfirmationTableContents()) {
            logger.info(element.getText());
        }
    }
}
