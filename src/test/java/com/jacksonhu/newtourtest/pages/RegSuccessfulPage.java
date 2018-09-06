package com.jacksonhu.newtourtest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class RegSuccessfulPage
{
    @FindBy(how = How.XPATH, using = "//font[@size=\"2\"]")
    private List<WebElement> registrationResultTexts;

    public List<WebElement> getRegistrationResultTexts()
    {
        return this.registrationResultTexts;
    }
}
