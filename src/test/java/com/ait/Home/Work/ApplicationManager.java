package com.ait.Home.Work;

import data.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class ApplicationManager {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static RegisterPage registerPage;
    public static LoginPage loginPage;
    public static AddItemToCartTests addItemToCartTests;
    private static boolean isInitialized = false; // Флаг инициализации

    public static void init() {
        if (!isInitialized) {
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); // Ожидание загрузки
            driver.manage().window().maximize();

            try {
                driver.get("https://demowebshop.tricentis.com/");
            } catch (Exception e) {
                System.out.println("Ошибка загрузки страницы: " + e.getMessage());
            }

            isInitialized = true;
        }
        registerPage = new RegisterPage();
        loginPage = new LoginPage();
        addItemToCartTests = new AddItemToCartTests();
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
            wait = null;
            isInitialized = false;
        }
    }
}
