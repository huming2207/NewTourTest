package com.jacksonhu.newtourtest.cases;

import com.jacksonhu.newtourtest.ConstantValues;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IndexPageTest extends BaseTest
{
    public IndexPageTest(WebDriver webDriver)
    {
        super(webDriver, "#1, IndexPageTest");
        webDriver.get("http://newtours.demoaut.com/mercurywelcome.php");
    }

    /**
     * Step #1, Validate Index page
     */
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
