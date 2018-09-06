package com.jacksonhu.newtourtest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FlightSelectionPage
{
    /**
     * Click this to continue booking procedure
     */
    @FindBy(how = How.NAME, using = "reserveFlights")
    private WebElement reserveFlightButton;

}
