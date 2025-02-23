package com.ait.Home.Work;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase{

    private final String productName = "14.1-inch Laptop"; // Название товара
    private LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void preconditions() {
        loginPage = new LoginPage();
        // Логинимся, если не залогинены
        if (isElementPresent(By.cssSelector("a[href='/login']"))) {
            loginPage.logInPositiveTest();
        }
    }
    @Test(description = "Добавление товара в корзину, проверка количества и удаление")
    public void addItemAndRemoveFromCartTest() {
        // 1. Найти и кликнуть по товару
        clickOnFirstProductByName(productName);

        // 2. Добавить товар в корзину
        click(By.id("add-to-cart-button-31"));

        // 3. Проверка появления сообщения о добавлении
        Assert.assertTrue(isElementPresent(By.cssSelector(".bar-notification.success")),
                "Сообщение о добавлении товара не отображается!");

        // 4. Проверка количества товара в корзине
        String cartQty = driver.findElement(By.cssSelector(".cart-qty")).getText();
        Assert.assertTrue(cartQty.contains("1"), "Количество товаров в корзине не обновилось!");

        // 5. Открыть корзину
        click(By.cssSelector(".cart-label"));

        // 6. Удалить товар
        click(By.cssSelector("input[name='removefromcart']")); // Чекбокс "Удалить"
        click(By.cssSelector("input[name='updatecart']")); // Кнопка "Обновить корзину"

        // 7. Проверить, что корзина пуста
        Assert.assertTrue(isElementPresent(By.cssSelector(".order-summary-content")),
                "Корзина не пуста!");
        Assert.assertEquals(getText(By.cssSelector(".order-summary-content")).trim(),
                "Your Shopping Cart is empty!",
                "Текст сообщения о пустой корзине неверный!");
    }

    // Метод для поиска товара по названию и клика по нему
    public void clickOnFirstProductByName(String productName) {
        By productLocator = By.xpath("(//a[contains(text(), '" + productName + "')])[1]");
        driver.findElement(productLocator).click();
    }
}