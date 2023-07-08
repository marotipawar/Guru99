package com.maroti.pageLayer.guru99;

import com.maroti.baseLayer.AbstractWebDriver;
import com.maroti.model.Guru99Register;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterServiceImpl extends AbstractWebDriver {

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phone;

    @FindBy(xpath = "//input[@name='userName']")
    private WebElement userName;

    @FindBy(xpath = "//input[@name='address1']")
    private WebElement address;
    @FindBy(xpath = "//input[@name='city']")
    private WebElement city;

    @FindBy(xpath = "//input[@name='state']")
    private WebElement state;

    @FindBy(xpath = "//input[@name='postalCode']")
    private WebElement postalCode;

    @FindBy(xpath = "//select[@name='country']")
    private WebElement country;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement email;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;
    @FindBy(xpath = "//input[@name='confirmPassword']")
    private WebElement confirmPassword;

    @FindBy(xpath = "//input[@name='submit']")
    private WebElement btnSubmit;

    public RegisterServiceImpl(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public Guru99Register register(Guru99Register reg) {
        firstName.sendKeys(reg.getFirstName());
        lastName.sendKeys(reg.getLastName());
        phone.sendKeys(reg.getPhone());
        userName.sendKeys(reg.getUserName());
        address.sendKeys(reg.getAddress());
        city.sendKeys(reg.getCity());
        state.sendKeys(reg.getState());
        postalCode.sendKeys(reg.getPinCode());
        Select se = new Select(country);
        se.selectByVisibleText(reg.getCountry());
        email.sendKeys(reg.getEmail());
        password.sendKeys(reg.getPassword());
        confirmPassword.sendKeys(reg.getComfirmPassword());
        //btnSubmit.click();
        return reg;

    }
}
