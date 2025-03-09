package com.demoWebShop.fw;

import helps.AddItemToCartHelper;
import helps.LoginPageHelper;
import helps.MenuPageHelper;
import helps.RegisterPageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;
import utils.MyListener;


import java.time.Duration;

public class ApplicationManager {
    String browser;
    WebDriver driver;
    public static SoftAssert softAssert = new SoftAssert();
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public static AddItemToCartHelper addItemToCartHelper;
    public static LoginPageHelper loginPageHelper;
    public static MenuPageHelper menuPageHelper;
    public static RegisterPageHelper registrationHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            logger.info("Tests start in Chrome browser");
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            logger.info("Tests start in Firefox browser");
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            logger.info("Tests start in Edge browser");
        }

        WebDriverListener listener = new MyListener();
        driver = new EventFiringDecorator<>(listener).decorate(driver);

        driver.get("https://demowebshop.tricentis.com/");
        logger.info("Current url --> " + driver.getCurrentUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        addItemToCartHelper=new AddItemToCartHelper(driver);
        loginPageHelper =new LoginPageHelper(driver);
        menuPageHelper=new MenuPageHelper(driver);
        registrationHelper=new RegisterPageHelper(driver);
    }
    public void stop() {
        driver.quit();
    }

    public AddItemToCartHelper getAddItemToCartHelper() {
        return addItemToCartHelper;
    }

    public LoginPageHelper getLoginPageHelper() {
        return loginPageHelper;
    }

    public MenuPageHelper getMenuPageHelper() {
        return menuPageHelper;
    }

    public RegisterPageHelper getRegistrationHelper() {
        return registrationHelper;
    }
}