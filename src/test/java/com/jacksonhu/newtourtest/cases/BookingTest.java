package com.jacksonhu.newtourtest.cases;

import com.jacksonhu.newtourtest.pages.FlightSelectionPage;
import com.jacksonhu.newtourtest.pages.TicketPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BookingTest extends BaseTest
{
    public BookingTest(WebDriver webDriver)
    {
        super(webDriver, "#5, BookingTest");
    }

    /**
     * Step #5, Book a ticket for a round trip from London to Sydney
     */
    public void bookTicket()
    {
        // Go to the flight booking page
        webDriver.findElement(By.partialLinkText("Flights")).click();

        // Fill in the form
        TicketPage ticketPage = PageFactory.initElements(webDriver, TicketPage.class);
        ticketPage.selectDepartureCity("London");
        ticketPage.selectArrivalCity("Sydney");

        // Submit the request
        ticketPage.clickContinueButton();

        // Continue for reserve flights
        FlightSelectionPage flightSelectionPage = PageFactory.initElements(webDriver, FlightSelectionPage.class);
        flightSelectionPage.clickReserveFlightButton(); // Just reserve a default flight
    }
}
