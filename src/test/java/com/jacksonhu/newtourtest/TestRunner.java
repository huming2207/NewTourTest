package com.jacksonhu.newtourtest;

import com.jacksonhu.newtourtest.tests.*;

public class TestRunner
{
    public static void main(String... args)
    {
        TestRunner runner = new TestRunner();

        // Step 1: Go to http://newtours.demoaut.com
        runner.runStep1();

        // Step 2: Go to Register through Home page
        runner.runStep2();

        // Step 3: Register the a user with valid address in Australia, then print the username in the console
        runner.runStep3();

        // Step 4: Login/Sign in into the system
        runner.runStep4();

        // Step 5: Book a ticket for a round trip from London to Sydney
        runner.runStep5();

        // Step 6: Complete all forms to book your ticket and pay for the ticket (you can put any number for
        // the credit card as it is a demo)
        runner.runStep6();

        // Step 7: Print ticket information into the console
        runner.runStep7();

        // Step 8: Logout
        runner.runStep8();

        // Close the browser
        SeleniumService.getWebDriver().close();
    }

    private void runStep1()
    {
        IndexPageTest indexPageTest = new IndexPageTest();
        indexPageTest.validateImgCount();
        indexPageTest.validateTableCount();
    }

    private void runStep2()
    {
        RedirectToRegTest redirectToRegTest = new RedirectToRegTest();
        redirectToRegTest.redirectPage();
    }

    private void runStep3()
    {
        RegistrationTest registrationTest = new RegistrationTest();
        registrationTest.performValidRegistration();
    }

    private void runStep4()
    {
        LoginTest loginTest = new LoginTest();
        loginTest.performLogin();
    }

    private void runStep5()
    {
        BookingTest bookingTest = new BookingTest();
        bookingTest.bookTicket();
    }

    private void runStep6()
    {
        PaymentTest paymentTest = new PaymentTest();
        paymentTest.testPayment();
    }

    private void runStep7()
    {
        BookingConfirmationTest bookingConfirmationTest = new BookingConfirmationTest();
        bookingConfirmationTest.listBookingConfirmation();
    }

    private void runStep8()
    {
        LogoffTest logoffTest = new LogoffTest();
        logoffTest.logOff();
    }
}
