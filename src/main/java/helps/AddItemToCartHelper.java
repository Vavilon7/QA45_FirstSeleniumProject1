package helps;

import com.demoWebShop.fw.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AddItemToCartHelper extends BaseHelper {
    public AddItemToCartHelper(WebDriver driver) {
        super(driver);
    }
    public void clickOnBooksButton() {
        click(By.xpath("(//a[@href='/books'])[1]"));
    }
    // Нажимаем на товар с определённым ID
    public void clickOnProduct(int productId) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("[data-productid='" + productId + "']")
        ));
        productElement.click();
    }
    public void scrollHalfPageDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long pageHeight = (long) js.executeScript("return document.body.scrollHeight;");
        js.executeScript("window.scrollBy(0, arguments[0]);", pageHeight / 2);
    }

    // Проверяем и нажимаем на кнопку "Add to Cart" для конкретного продукта
    public void addToCart(int productId) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("add-to-cart-button-" + productId)
        ));
        button.click();
    }

    public void removeItemFromCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Ждём, пока исчезнет уведомление о добавлении в корзину
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("bar-notification")));

        // Открываем корзину
        WebElement cartLabel = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cart-label")));
        cartLabel.click();

        // Кликаем по кнопке "Удалить"
        WebElement removeCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='removefromcart']")));
        removeCheckbox.click();

        WebElement updateCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='updatecart']")));
        updateCartButton.click();

        System.out.println("🛒 Товар удалён из корзины.");
    }

    public void verifyCartIsEmpty() {
        boolean cartEmpty = isElementPresent(By.cssSelector(".order-summary-content"));
        System.out.println(cartEmpty ? "✅ Корзина очищена." : "❌ Корзина не пуста!");
    }

    public int getCartQuantity() {
        String countStr = driver.findElement(By.cssSelector(".cart-qty")).getText().replaceAll("[^0-9]", "");
        return countStr.isEmpty() ? 0 : Integer.parseInt(countStr);
    }
}