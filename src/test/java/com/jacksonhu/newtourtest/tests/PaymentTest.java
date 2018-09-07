package com.jacksonhu.newtourtest.tests;

import com.jacksonhu.newtourtest.SeleniumService;
import com.jacksonhu.newtourtest.pages.PaymentPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

public class PaymentTest extends BaseTest
{
    public PaymentTest()
    {
        super(SeleniumService.getWebDriver(), "#6, PaymentTest");
    }

    /**
     * Step #6, pay for the ticket (you can put any number for the credit card as it is a demo)
     * This test should follow after the BookingTest::bookTicket
     */
    public void testPayment()
    {
        PaymentPage paymentPage;

        try {
            paymentPage = PageFactory.initElements(webDriver, PaymentPage.class);
        } catch (NoSuchElementException exception) {
            logger.warn("Failed to load the payment page.");
            return;
        }

        logger.info("Payment page loaded.");

        // Submit a fake passenger info
        paymentPage.inputCardHolderFirstName("John");
        paymentPage.inputCardHolderLastName("Doe");
        paymentPage.inputCreditCardNumber("5326000011405140");
        paymentPage.inputPassengerFirstName("Jane");
        paymentPage.inputPassengerLastName("Doe");
        paymentPage.clickPurchaseButton();
    }
}
