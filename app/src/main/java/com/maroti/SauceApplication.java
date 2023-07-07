package com.maroti;

import com.maroti.data.ExcelDataProvider;
import com.maroti.model.User;
import com.maroti.pageLayer.CheckoutCart;
import com.maroti.pageLayer.Login;
import com.maroti.baseLayer.SauceServices;
import com.maroti.pageLayer.ShoppingCart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;
import java.util.List;

public class SauceApplication {
    public static void main(String[] args) throws FileNotFoundException {


       /* SauceServices sauce = new Login(new ChromeDriver());
        sauce.goTo("https://www.saucedemo.com/checkout-complete.html");
        sauce.login("standard_user", "secret_sauce");
        WebDriver driver = sauce.getDriver();
        sauce.implicitlyWait(driver);

        SauceServices cart = new ShoppingCart(driver);
        cart.addItemsToCart(4);

        SauceServices checkout = new CheckoutCart(driver);
        checkout.checkout();
        checkout.userDetails("Maroti", "Pawar", "410001");
        System.out.println(checkout.finishShopping());*/


        List<User> users =ExcelDataProvider.readExcelData("Users.xlsx");

        User user2=users.get(2);
        System.out.println(user2.getFirstName()+" "+user2.getLastName());
      //users.forEach(System.out::println);
    }
}
