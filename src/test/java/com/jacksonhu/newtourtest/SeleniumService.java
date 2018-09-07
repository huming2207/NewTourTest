package com.jacksonhu.newtourtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumService
{
    private static WebDriver webDriver = null;

    public static WebDriver getWebDriver()
    {
        if(webDriver == null) {
            System.setProperty("webdriver.chrome.driver", ConstantValues.CHROMIUM_WEB_DRIVER);
            webDriver = new ChromeDriver();
        }

        return webDriver;
    }
}
