package com.ait.Home.Work;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginPage extends TestBase {
    @Test
    public void logInPositiveTest() {
        if (driver == null) {
            setUp(); // Убедимся, что WebDriver инициализирован перед тестом
        }

        super.click(By.cssSelector("a[href='/login']"));
        type(By.xpath("//*[@name='Email']"), "fghh777@gmail.com");
        type(By.xpath("//*[@name='Password']"), "789456");
        super.click(By.xpath("//input[@id='RememberMe']"));
        super.click(By.xpath("//*[@class='button-1 login-button']"));

    }

}