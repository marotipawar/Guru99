package com.maroti.pageLayer;

import com.maroti.baseLayer.AbstractSauce;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ShoppingCart extends AbstractSauce {
    @FindBy(xpath = "//div[@class='inventory_list']//button")
    List<WebElement> addToCartElements;

    public ShoppingCart(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public int addItemsToCart(int items) {
        int count = 0;

        for (int i = 0; i <= items; i++) {
            if(addToCartElements.get(i).getText().equals("Add to cart")){
                addToCartElements.get(i).click();
                count += 1;
            }

        }
        return count;
    }
}
