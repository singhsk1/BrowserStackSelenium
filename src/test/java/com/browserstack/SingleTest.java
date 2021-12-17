package com.browserstack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SingleTest extends BrowserStackTestNGTest {

    @Test
    public void test() throws Exception {
        driver.get("https://www.google.com/ncr");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("BrowserStack");
        element.submit();
        Thread.sleep(5000 * 2);
        WebElement signInElement = driver.findElement(By.xpath("//div/h3/a[text()='Sign in']"));
        WebElement aboutUsElement = driver.findElement(By.xpath("//div/h3/a[text()='About Us']"));

        Assert.assertTrue(driver.getTitle().matches("(?i)BrowserStack - Google Search"));
        Assert.assertTrue(signInElement.isDisplayed());
        Assert.assertTrue(aboutUsElement.isDisplayed());
    }
}
