package com.jacksonhu.newtourtest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TicketPage
{
    @FindBy(how = How.NAME, using = "fromPort")
    private WebElement fromSelection;

    @FindBy(how = How.NAME, using = "toPort")
    private WebElement toSelection;

    @FindBy(how = How.NAME, using = "findFlights")
    private WebElement continueButton;
}
