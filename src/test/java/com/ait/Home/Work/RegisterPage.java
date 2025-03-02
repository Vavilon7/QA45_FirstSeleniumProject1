package com.ait.Home.Work;

import data.Contact;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterPage extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getRegistrationHelper().isRegisterButtonPresent()) {
            app.getRegistrationHelper().clickOnContinueButton();
        }
    }
    @Test
    public void registerNewUserPositiveTest() {
        app.getRegistrationHelper().openRegisterPage();
        app.getRegistrationHelper().fillRegisterForm(new Contact("Ivanov", "Ivan", "Bnmjg88@gmail.com", "Man1234$", "Man1234$"));
        app.getRegistrationHelper().submitRegisterForm();
        app.getRegistrationHelper().isRegistrationSuccessful();
    }
    @Test
    public void registerExistedUserNegativeTest() {
        app.getRegistrationHelper().openRegisterPage();
        app.getRegistrationHelper().fillRegisterForm(new Contact("Ivan", "Ivanov", "manel@gm.com", "123", "1234")); // Некорректные данные
        app.getRegistrationHelper().submitRegisterForm();

        // Проверка ошибки Email
        if (app.getRegistrationHelper().isEmailErrorPresent()) {
            if (app.getRegistrationHelper().isEmailErrorCorrect("Wrong email")) {
                System.out.println(" Ошибка Email отображается правильно.");
            } else {
                System.out.println(" Ошибка! Неправильное сообщение об ошибке Email.");
            }
        } else {
            System.out.println("Ошибка! Сообщение об ошибке Email не найдено.");
        }

        // Проверка ошибки Password
        if (app.getRegistrationHelper().isPasswordErrorPresent()) {
            if (app.getRegistrationHelper().isPasswordErrorCorrect("The password should have at least 6 characters.")) {
                System.out.println(" Ошибка пароля отображается правильно.");
            } else {
                System.out.println(" Ошибка! Неправильное сообщение об ошибке пароля.");
            }
        } else {
            System.out.println("Ошибка! Сообщение об ошибке пароля не найдено.");
        }
    }
}