package com.jacksonhu.newtourtest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage
{
    @FindBy(how = How.NAME, using = "firstName")
    private WebElement firstNameTextBox;

    @FindBy(how = How.NAME, using = "lastName")
    private WebElement lastNameTextBox;

    @FindBy(how = How.NAME, using = "phone")
    private WebElement phoneTextBox;

    @FindBy(how = How.NAME, using = "userName") // Why user name is email and email is user name???
    private WebElement emailTextBox;

    @FindBy(how = How.NAME, using = "address1")
    private WebElement firstAddressTextBox;

    @FindBy(how = How.NAME, using = "address2")
    private WebElement secondAddressTextBox;

    @FindBy(how = How.NAME, using = "city")
    private WebElement cityTextBox;

    @FindBy(how = How.NAME, using = "state")
    private WebElement stateTextBox;

    @FindBy(how = How.NAME, using = "postalCode")
    private WebElement postalCodeTextBox;

    @FindBy(how = How.NAME, using = "country")
    private WebElement countrySelectionBox;

    @FindBy(how = How.NAME, using = "email") // Why user name is email and email is user name???
    private WebElement userNameTextBox;

    @FindBy(how = How.NAME, using = "password")
    private WebElement passwordTextBox;

    @FindBy(how = How.NAME, using = "confirmPassword")
    private WebElement confirmPasswordTextBox;
}
