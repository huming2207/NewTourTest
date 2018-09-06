package com.jacksonhu.newtourtest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PaymentPage
{

    @FindBy(how = How.NAME, using = "passFirst0")
    private WebElement passengerFirstNameTextBox;

    @FindBy(how = How.NAME, using = "passLast0")
    private WebElement passengerLastNameTextBox;

    @FindBy(how = How.NAME, using = "pass.0.meal")
    private WebElement passengerMealSelection;

    @FindBy(how = How.NAME, using = "creditnumber")
    private WebElement creditCardNumberTextBox;

    @FindBy(how = How.NAME, using = "cc_frst_name")
    private WebElement cardHolderFirstNameTextBox;

    @FindBy(how = How.NAME, using = "cc_last_name")
    private WebElement cardHolderLastNameTextBox;

    @FindBy(how = How.NAME, using = "buyFlights")
    private WebElement purchaseButton;
}
