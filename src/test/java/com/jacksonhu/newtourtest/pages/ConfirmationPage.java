package com.jacksonhu.newtourtest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ConfirmationPage
{
    /**
     *  Here is a nicer way to grab out all the stuff in the confirmation table.
     *  In the table, all the text are wrapped with a <font> tag with size attribute set to "-1".
     *  Btw, <table> tag sucks.
     */
    @FindBy(how = How.NAME, using = "//font[@size=\"-1\"]")
    private List<WebElement> confirmationTableContents;

    @FindBy(how = How.NAME, using = "//a[@href=\"mercurysignoff.php\"]")
    private WebElement signOffButton;


}
