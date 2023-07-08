package com.maroti.pageLayer;

import com.maroti.baseLayer.WebDriverService;
import com.maroti.pageLayer.sauce.Login;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

@Test(groups = {"login"})
public class LoginTest {

    private WebDriverService sauce;
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