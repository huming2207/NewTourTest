package com.jacksonhu.newtourtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

    @FindBy(how = How.NAME, using = "register")
    private WebElement registerButton;

    public void inputFirstName(String name)
    {
        firstNameTextBox.sendKeys(name);
    }

    public void inputLastName(String name)
    {
        lastNameTextBox.sendKeys(name);
    }

    public void inputPhoneNumber(String phone)
    {
        phoneTextBox.sendKeys(phone);
    }

    public void inputEmail(String email)
    {
        emailTextBox.sendKeys(email);
    }

    public void inputFirstAddress(String address)
    {
        firstAddressTextBox.sendKeys(address);
    }

    public void inputSecondAddress(String address)
    {
        secondAddressTextBox.sendKeys(address);
    }

    public void inputCity(String city)
    {
        cityTextBox.sendKeys(city);
    }

    public void inputState(String state)
    {
        stateTextBox.sendKeys(state);
    }

    public void inputPostalCode(String postalCode)
    {
        postalCodeTextBox.sendKeys(postalCode);
    }

    public void selectCountryByName(String country)
    {
        new Select(countrySelectionBox).selectByVisibleText(country.toUpperCase());
    }

    public void inputUserName(String userName)
    {
        userNameTextBox.sendKeys(userName);
    }

    public void inputPasswords(String password)
    {
        // YES, I AM A ROBOT AND I DON'T NEED THESE STUPID CONFIRMATIONS
        passwordTextBox.sendKeys(password);
        confirmPasswordTextBox.sendKeys(password);
    }

    public void clickRegisterButton()
    {
        registerButton.click();
    }

}
