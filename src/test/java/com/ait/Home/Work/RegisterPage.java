package com.ait.Home.Work;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterPage extends TestBase {
    @BeforeMethod
    public void precondition() {
        driver.get("https://demowebshop.tricentis.com/");
    }

    @Test
    public void registerNewUserPositiveTest() {
        click(By.cssSelector("a[href='/register']"));
        type(By.name("FirstName"), "Ivanov");
        type(By.name("LastName"), "Ivan");
        type(By.name("Email"), "vkjh3@gmail.com");
        type(By.name("Password"), "123456");
        type(By.name("ConfirmPassword"), "123456");
        click(By.name("register-button"));

        // Проверяем, что пользователь успешно зарегистрировался

        Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
    }

    @Test
    public void registerWithInvalidDataNegativeTest() {
        click(By.cssSelector("a[href='/register']"));
        type(By.name("FirstName"), "Ivan");
        type(By.name("LastName"), "Ivanov");
        type(By.name("Email"), "bodak83gmail.com"); // Неправильный email
        type(By.name("Password"), "12346"); // Слишком короткий пароль
        type(By.name("ConfirmPassword"), "123456"); // Несовпадающие пароли
        click(By.name("register-button"));

        // Проверяем сообщение об ошибке email
        Assert.assertTrue(isElementPresent(By.cssSelector(".field-validation-error[data-valmsg-for='Email']")));
        Assert.assertEquals(getText(By.cssSelector(".field-validation-error[data-valmsg-for='Email']")), "Wrong email");

        // Проверяем сообщение об ошибке пароля
        Assert.assertTrue(isElementPresent(By.cssSelector(".field-validation-error[data-valmsg-for='Password']")));
        Assert.assertEquals(getText(By.cssSelector(".field-validation-error[data-valmsg-for='Password']")), "The password should have at least 6 characters.");

        // Проверяем сообщение о несовпадающих паролях
        Assert.assertTrue(isElementPresent(By.cssSelector(".field-validation-error[data-valmsg-for='ConfirmPassword']")));
        Assert.assertEquals(getText(By.cssSelector(".field-validation-error[data-valmsg-for='ConfirmPassword']")), "The password and confirmation password do not match.");
    }

}
