package com.ait.Home.Work;

import data.User;
import data.UserData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class AddItemToCartTests extends TestBase {
    @BeforeMethod(alwaysRun = true)
    public void preconditions() {
        if (!app.getLoginPageHelper().isLoginSuccessful()) {
            app.getLoginPageHelper().clickOnLoginLink();
            app.getLoginPageHelper().fillLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
            app.getLoginPageHelper().clickOnLoginButton();
        }
    }

    @Test(description = "Добавление и удаление товара из корзины")
    public void test1() {
        app.getAddItemToCartHelper().clickOnBooksButton();
        app.getAddItemToCartHelper().clickOnProduct(13);
        app.getAddItemToCartHelper().addToCart(13);
        app.getAddItemToCartHelper().getCartQuantity();
        app.getAddItemToCartHelper().removeItemFromCart();
        app.getAddItemToCartHelper().verifyCartIsEmpty();
    }
    @Test(description = "Добавление и удаление товара из корзины")
    public void test2() {
        app.getAddItemToCartHelper().clickOnBooksButton();
        app.getAddItemToCartHelper().clickOnProduct(79);
        app.getAddItemToCartHelper().addToCart(79);
        app.getAddItemToCartHelper().getCartQuantity();
        app.getAddItemToCartHelper().removeItemFromCart();
        app.getAddItemToCartHelper().verifyCartIsEmpty();
    }
    @Test(description = "Добавление и удаление товара из корзины")
    public void test3() {
        app.getAddItemToCartHelper().clickOnBooksButton();
        app.getAddItemToCartHelper().clickOnProduct(45);
        app.getAddItemToCartHelper().addToCart(45);
        app.getAddItemToCartHelper().getCartQuantity();
        app.getAddItemToCartHelper().removeItemFromCart();
        app.getAddItemToCartHelper().verifyCartIsEmpty();
    }
    @Test(description = "Добавление и удаление товара из корзины")
    public void test4() {
        app.getAddItemToCartHelper().clickOnBooksButton();
        app.getAddItemToCartHelper().clickOnProduct(78);
        app.getAddItemToCartHelper().addToCart(78);
        app.getAddItemToCartHelper().getCartQuantity();
        app.getAddItemToCartHelper().removeItemFromCart();
        app.getAddItemToCartHelper().verifyCartIsEmpty();
    }
    @Test(description = "Добавление и удаление товара из корзины")
    public void test5() {
        app.getAddItemToCartHelper().clickOnBooksButton();
        app.getAddItemToCartHelper().clickOnProduct(22);
        app.getAddItemToCartHelper().addToCart(22);
        app.getAddItemToCartHelper().getCartQuantity();
        app.getAddItemToCartHelper().removeItemFromCart();
        app.getAddItemToCartHelper().verifyCartIsEmpty();
    }
    @Test(description = "Добавление и удаление товара из корзины")
    public void test6() {
        app.getAddItemToCartHelper().clickOnBooksButton();
        app.getAddItemToCartHelper().clickOnProduct(27);
        app.getAddItemToCartHelper().addToCart(27);
        app.getAddItemToCartHelper().getCartQuantity();
        app.getAddItemToCartHelper().removeItemFromCart();
        app.getAddItemToCartHelper().verifyCartIsEmpty();
    }
}
