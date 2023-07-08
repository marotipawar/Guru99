package com.maroti.util;

import com.maroti.baseLayer.WebDriverService;
import com.maroti.data.ExcelDataProvider;
import com.maroti.data.RegisterExcelDataProvider;
import com.maroti.model.Guru99Register;
import com.maroti.pageLayer.guru99.RegisterServiceImpl;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;

public class Guru99App {

    public static void main(String[] args) throws FileNotFoundException {

        WebDriverService driver = new RegisterServiceImpl(new ChromeDriver());
        driver.goTo("https://demo.guru99.com/test/newtours/register.php");
        RegisterExcelDataProvider.getExcelData("RegisterData.xlsx").forEach(reg->{
            driver.register(reg);
            driver.goTo("https://demo.guru99.com/test/newtours/register.php");
        });
    }
}
