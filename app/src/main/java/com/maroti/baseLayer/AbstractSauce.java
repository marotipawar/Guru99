package com.maroti.baseLayer;

import com.maroti.baseLayer.SauceServices;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public abstract class AbstractSauce implements SauceServices {
    WebDriver driver;
    TakesScreenshot ts;
    JavascriptExecutor script;
    Actions act;



    public AbstractSauce(WebDriver driver) {
        this.driver = driver;
        TakesScreenshot ts = (TakesScreenshot) driver;
        JavascriptExecutor script = (JavascriptExecutor) driver;
        Actions act = new Actions(driver);
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }

    @Override
    public String goTo(String url) {
        driver.get(url);
        return driver.getCurrentUrl();
    }

    @Override
    public void implicitlyWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Override
    public String captureTitle(WebDriver driver) {
        return driver.getTitle();
    }

    @Override
    public String captureCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    @Override
    public File captureScreen(WebDriver driver) throws IOException {
        return ts.getScreenshotAs(OutputType.FILE);
    }

    @Override
    public void javascriptClick(WebDriver driver, WebElement element) {
        script.executeScript("arguments[0].click();", element);
    }

    @Override
    public void javascriptSendKeys(WebDriver driver, WebElement element, String value) {
        script.executeScript("argument[0].value='"+value+"'", element);
    }

    @Override
    public void actionsClick(WebDriver driver, WebElement element) {
        act.click(element).build().perform();
    }

    @Override
    public void actionsSendKeys(WebDriver driver, WebElement element, String value) {
       act.sendKeys(element, value).build().perform();

    }

    @Override
    public void actionsMoveToElement(WebDriver driver, WebElement element) {
        act.moveToElement(element).build().perform();
    }

    @Override
    public boolean login(String username, String password) {
        return false;
    }

    @Override
    public int addItemsToCart(int items) {
        return 0;
    }

    @Override
    public String[] userDetails(String firstName, String lastName, String zipCode) {
        return new String[0];
    }

    @Override
    public void checkout() {

    }

    @Override
    public String finishShopping() {
        return null;
    }
}