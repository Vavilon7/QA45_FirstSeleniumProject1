package com.ait.Home.Work;


import data.User;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPage extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getLoginPageHelper().isLogInPresent()) {
            app.getLoginPageHelper().clickOnLoginLink();
        }
    }
    @Test
    public void loginPositiveTest() {
        app.getLoginPageHelper().clickOnLoginLink();
        app.getLoginPageHelper().fillLoginForm(new User("Bnmjg88@gmail.com", "Man1234$"));
        app.getLoginPageHelper().clickOnLoginButton();

        if (app.getLoginPageHelper().isLoginSuccessful()) {
            System.out.println("Вход выполнен успешно!");
        } else {
            System.out.println("Ошибка! Вход не был выполнен.");
        }
    }
    @Test
    public void loginNegativeTest() {
        app.getLoginPageHelper().clickOnLoginLink();
        app.getLoginPageHelper().fillLoginForm(new User("invalid@test.com", "wrongPassword"));
        app.getLoginPageHelper().clickOnLoginButton();

        String errorText = app.getLoginPageHelper().getLoginErrorText();
        if (errorText.contains("Login was unsuccessful")) {
            System.out.println(" Ошибка логина отображается правильно: " + errorText);
        } else {
            System.out.println(" Ошибка! Неверное сообщение при неудачном входе.");
        }
    }
}