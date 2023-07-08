package com.maroti.pageLayer.sauce;

import com.maroti.baseLayer.AbstractWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCart extends AbstractWebDriver {

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement checkoutElement;
    @FindBy(xpath = "//button[@data-test='checkout']")
    WebElement btnCheckout;
    @FindBy(xpath = "//input[@name='firstName']")
    WebElement firstNameElement;
    @FindBy(xpath = "//input[@name='lastName']")
    WebElement lastNameElement;
    @FindBy(xpath = "//input[@name='postalCode']")
    WebElement zipCodeElement;
    @FindBy(xpath = "//input[@name='continue']")
    WebElement btnContinue;

    @FindBy(xpath = "//button[@name='finish']")
    WebElement finish;

    @FindBy(xpath = "//h2[@class='complete-header']")
    WebElement orderCompleted;

    public CheckoutCart(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void checkout() {
        checkoutElement.click();
        btnCheckout.click();
    }

    @Override
    public String[] userDetails(String firstName, String lastName, String zipCode) {
        firstNameElement.sendKeys(firstName);
        lastNameElement.sendKeys(lastName);
        zipCodeElement.sendKeys(zipCode);
        btnContinue.click();
        return new String[]{firstName, lastName, zipCode};
    }

    @Override
    public String finishShopping() {
        finish.click();
        return orderCompleted.getText();
    }
}
