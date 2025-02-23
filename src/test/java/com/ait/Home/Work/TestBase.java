package com.ait.Home.Work;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class TestBase {
    protected static final ApplicationManager app = new ApplicationManager();
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        if (driver == null) {
            app.init();
            this.driver = ApplicationManager.driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
    public void click(By locator) {
        if (driver == null) {
            throw new IllegalStateException("WebDriver не инициализирован! Проверьте вызов setUp().");
        }
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText().trim();
    }

    public static String generateRandomEmail() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        return "user" + i + "@testmail.com";
    }

    String randomEmail = generateRandomEmail();

}


