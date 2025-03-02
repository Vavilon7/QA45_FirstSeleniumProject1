package com.ait.Home.Work;


import com.demoWebShop.fw.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    protected static final ApplicationManager app = new ApplicationManager("chrome");
    @BeforeSuite
    public void setUp() {
        System.out.println("Before suite");
        app.init();
    }
    @AfterSuite
    public void tearDown() {
        //System.out.println("After suite");
        app.stop();
    }
    public static String generateRandomEmail() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        return "user" + i + "@testmail.com";
    }
    String randomEmail = generateRandomEmail();

}


