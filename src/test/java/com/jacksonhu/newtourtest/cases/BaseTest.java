package com.jacksonhu.newtourtest.cases;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseTest
{
    protected Logger logger;
    protected WebDriver webDriver;

    public BaseTest(WebDriver webDriver, String className)
    {
        this.webDriver = webDriver;
        this.logger = LoggerFactory.getLogger(className);
    }
}
