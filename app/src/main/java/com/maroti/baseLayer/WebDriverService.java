package com.maroti.baseLayer;

import com.maroti.model.Guru99Register;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public interface WebDriverService {

    WebDriver getDriver();

    String goTo(String url);

    void implicitlyWait(WebDriver driver);

    Guru99Register register(Guru99Register reg );

    String captureTitle(WebDriver driver);

    String captureCurrentUrl(WebDriver driver);

    File captureScreen(WebDriver driver) throws IOException;

    void javascriptClick(WebDriver driver, WebElement element);
    void javascriptSendKeys(WebDriver driver, WebElement element, String value);

    void actionsClick(WebDriver driver, WebElement element);

    void actionsSendKeys(WebDriver driver, WebElement element, String value);

    void actionsMoveToElement(WebDriver driver, WebElement element);

    boolean login(String username, String password);

    int addItemsToCart(int items);

    String[] userDetails(String firstName, String lastName, String zipCode);

    void checkout();

    String finishShopping();


}


