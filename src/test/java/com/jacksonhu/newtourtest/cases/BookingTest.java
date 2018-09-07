package com.jacksonhu.newtourtest.cases;

import com.jacksonhu.newtourtest.pages.TicketPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BookingTest extends BaseTest
{
    public BookingTest(WebDriver webDriver)
    {
        super(webDriver, "BookingTest");
    }

    public void bookTicket()
    {
        // Go to the flight booking page
        webDriver.get("http://newtours.demoaut.com/mercurywelcome.php");
        webDriver.findElement(By.partialLinkText("Flights")).click();

        // Fill in the form
        TicketPage ticketPage = PageFactory.initElements(webDriver, TicketPage.class);
        ticketPage.selectDepartureCity("London");
        ticketPage.selectArrivalCity("Sydney");

        // Submit the request
        ticketPage.clickContinueButton();
    }
}
