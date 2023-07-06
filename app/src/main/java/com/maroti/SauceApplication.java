package com.maroti;

import com.maroti.pageLayer.CheckoutCart;
import com.maroti.pageLayer.Login;
import com.maroti.baseLayer.SauceServices;
import com.maroti.pageLayer.ShoppingCart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceApplication {
    public static void main(String[] args) {


        SauceServices sauce = new Login(new ChromeDriver());
        sauce.goTo("https://www.saucedemo.com/checkout-complete.html");
        sauce.login("standard_user", "secret_sauce");
        WebDriver driver = sauce.getDriver();
        sauce.implicitlyWait(driver);

        SauceServices cart = new ShoppingCart(driver);
        cart.addItemsToCart(3);

        SauceServices checkout = new CheckoutCart(driver);
        checkout.checkout();
        checkout.userDetails("Maroti", "Pawar", "410001");
        System.out.println(checkout.finishShopping());

    }
}
