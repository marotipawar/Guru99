package com.maroti;

import java.io.FileNotFoundException;
import java.nio.file.FileSystems;

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


        /*List<User> users =ExcelDataProvider.readExcelData("Users.xlsx");

        User user2=users.get(2);
        System.out.println(user2.getFirstName()+" "+user2.getLastName());*/
      //users.forEach(System.out::println);


        String path = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
        System.out.println(path);
    }
}
