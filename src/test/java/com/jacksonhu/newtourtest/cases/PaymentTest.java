package com.jacksonhu.newtourtest.cases;

import com.jacksonhu.newtourtest.pages.PaymentPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PaymentTest extends BaseTest
{
    public PaymentTest(WebDriver webDriver)
    {
        super(webDriver, "PaymentTest");
    }

    /**
     * This test should follow after the BookingTest::bookTicket
     */
    public void testPayment()
    {
        PaymentPage paymentPage = PageFactory.initElements(webDriver, PaymentPage.class);

        // Submit a fake passenger info
        paymentPage.inputCardHolderFirstName("John");
        paymentPage.inputCardHolderLastName("Doe");
        paymentPage.inputCreditCardNumber("5326000011405140");
        paymentPage.inputPassengerFirstName("Jane");
        paymentPage.inputPassengerLastName("Doe");
        paymentPage.clickPurchaseButton();
    }
}
