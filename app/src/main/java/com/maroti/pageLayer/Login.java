package com.maroti.pageLayer;

import com.maroti.baseLayer.AbstractSauce;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends AbstractSauce {
    @FindBy(xpath = "//form/child::div[1]/input")
    private WebElement usernameElement;
    @FindBy(xpath = "//form/child::div[2]/input")
    private WebElement passwordElement;
    @FindBy(xpath = "//form/child::input")
    private WebElement btnLoginElement;

    private WebDriver driver;
    public Login(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }

    @Override
    public boolean login(String username, String password) {
       usernameElement.sendKeys(username);
       passwordElement.sendKeys(password);
       btnLoginElement.click();
       return true;
    }





}
