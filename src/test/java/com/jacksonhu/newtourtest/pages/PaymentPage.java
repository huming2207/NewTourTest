package com.jacksonhu.newtourtest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

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

    public void inputPassengerFirstName(String name)
    {
        passengerFirstNameTextBox.sendKeys(name);
    }

    public void inputPassengerLastName(String name)
    {
        passengerLastNameTextBox.sendKeys(name);
    }

    public void selectMealType(String mealTypeName)
    {
        new Select(passengerMealSelection).selectByVisibleText(mealTypeName);
    }

    public void inputCreditCardNumber(String creditCardNum)
    {
        creditCardNumberTextBox.sendKeys();
    }

    public void inputCardHolderFirstName(String name)
    {
        cardHolderFirstNameTextBox.sendKeys(name);
    }

    public void inputCardHolderLastName(String name)
    {
        cardHolderLastNameTextBox.sendKeys(name);
    }

    public void clickPurchaseButton()
    {
        purchaseButton.click();
    }
}
