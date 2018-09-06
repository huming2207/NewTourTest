package com.jacksonhu.newtourtest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignOnPage
{
    @FindBy(how = How.NAME, using = "userName")
    private WebElement userNameTextBox;

    @FindBy(how = How.NAME, using = "password")
    private WebElement passwordTextBox;

    @FindBy(how = How.NAME, using = "login")
    private WebElement loginButton;

    public void inputUserName(String userName)
    {
        userNameTextBox.sendKeys(userName);
    }

    public void inputPassword(String password)
    {
        passwordTextBox.sendKeys(password);
    }

    public void clickLoginButton()
    {
        loginButton.click();
    }
}
