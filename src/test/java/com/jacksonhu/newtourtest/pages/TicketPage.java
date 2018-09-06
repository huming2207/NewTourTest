package com.jacksonhu.newtourtest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class TicketPage
{
    @FindBy(how = How.NAME, using = "fromPort")
    private WebElement fromSelection;

    @FindBy(how = How.NAME, using = "toPort")
    private WebElement toSelection;

    @FindBy(how = How.NAME, using = "findFlights")
    private WebElement continueButton;

    public void selectDepartureCity(String cityName)
    {
        new Select(fromSelection).selectByVisibleText(cityName);
    }

    public void selectArrivalCity(String cityName)
    {
        new Select(toSelection).selectByVisibleText(cityName);
    }

    public void clickContinueButton()
    {
        continueButton.click();
    }
}
