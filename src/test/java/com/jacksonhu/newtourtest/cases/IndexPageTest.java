package com.jacksonhu.newtourtest.cases;

import com.jacksonhu.newtourtest.ConstantValues;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndexPageTest extends BaseTest
{
    public IndexPageTest(WebDriver webDriver)
    {
        super(webDriver, "IndexPageTest");
        webDriver.get("http://newtours.demoaut.com/mercurywelcome.php");
    }

    public void validateImgCount()
    {
        if(webDriver.findElements(By.xpath("//img")).size() < ConstantValues.INDEX_PAGE_IMG_COUNT) {
            logger.warn("Index page images are not loaded correctly.");
        } else {
            logger.info("Got all images for index page");
        }
    }

    public void validateTableCount()
    {
        if(webDriver.findElements(By.xpath("//table")).size() < ConstantValues.INDEX_PAGE_TABLE_COUNT) {
            logger.warn("Index page tables are not loaded correctly.");
        } else {
            logger.info("Got all tables for index page");
        }
    }

}
