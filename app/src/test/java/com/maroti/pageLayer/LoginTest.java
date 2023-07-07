package com.maroti.pageLayer;

import com.maroti.baseLayer.SauceServices;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.*;

@Test(groups = {"login"})
public class LoginTest {

    private SauceServices sauce;
    @Parameters({"url"})
    @BeforeTest
    public void setUp(String url) {
        sauce= new Login(new ChromeDriver());
        sauce.goTo(url);
    }



    @Test
    public void testGetDriver() {
    }

    @Parameters({"username", "password"})
    @Test(priority = 1)
    public void testLogin(String username, String password) {
        sauce.login(username,password);
    }

    @AfterMethod
    public void tearDown() {
    }

}