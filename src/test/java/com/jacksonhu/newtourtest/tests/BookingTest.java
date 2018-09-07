package com.jacksonhu.newtourtest.tests;

import com.jacksonhu.newtourtest.SeleniumService;
import com.jacksonhu.newtourtest.pages.FlightSelectionPage;
import com.jacksonhu.newtourtest.pages.TicketPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

public class BookingTest extends BaseTest
{
    public BookingTest()
    {
        super(SeleniumService.getWebDriver(), "#5, BookingTest");
    }

    /**
     * Step #5, Book a ticket for a round trip from London to Sydney
     */
    public void bookTicket()
    {
        TicketPage ticketPage;

        // Go to the flight booking page
        try {
            webDriver.findElement(By.partialLinkText("Flights")).click();
            ticketPage = PageFactory.initElements(webDriver, TicketPage.class);
        } catch (NoSuchElementException exception) {
            logger.warn("Failed to load the booking page.");
            return;
        }

        logger.info("Booking page loaded successfully, now filling in the information...");

        // Fill in the form
        ticketPage.selectDepartureCity("London");
        ticketPage.selectArrivalCity("Sydney");

        // Submit the request
        ticketPage.clickContinueButton();

        // Continue for reserve flights
        try {
            FlightSelectionPage flightSelectionPage = PageFactory.initElements(webDriver, FlightSelectionPage.class);
            flightSelectionPage.clickReserveFlightButton(); // Just reserve a default flight
        } catch (NoSuchElementException exception) {
            logger.warn("Failed to load the flight reservation page.");
        }

        logger.info("Flight reservation page loaded and flights are reserved.");
    }
}
