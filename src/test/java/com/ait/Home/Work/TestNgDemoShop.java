package com.ait.Home.Work;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class TestNgDemoShop {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");// открытие сайта без истории
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void openChromeTest() {
        System.out.println("Browser opens!");
    }

    @Test(priority = 2)
    public void findElementsByTagName() {
        WebElement element = driver.findElement(By.name("q"));
        System.out.println(element.getText());
    }

    @Test(priority = 3)
    public void findElementById() {
        driver.findElement(By.id("bar-notification"));
        driver.findElement(By.id("mob-menu-button"));
        driver.findElement(By.id("dialog-notifications-error"));
        driver.findElement(By.id("topcartlink"));
        driver.findElement(By.id("flyout-cart"));
        driver.findElement(By.id("small-searchterms"));
        driver.findElement(By.id("newsletter-subscribe-block"));
    }

    @Test(priority = 4)
    public void findElementByClassName() {
        List<WebElement> elements = driver.findElements(By.className("title"));
        System.out.println(elements.size());
        System.out.println("=========================================");
        WebElement element = driver.findElement(By.className("listbox"));
        System.out.println(element.getText());
        System.out.println("=========================================");
        WebElement element1 = driver.findElement(By.className("footer"));
        System.out.println(element1.getText());
    }

    @Test(priority = 5)
    public void findElementByCssSelector() {

        //id -> css - #
        driver.findElement(By.cssSelector("#flyout-cart"));

        //className ->css-.
        driver.findElement(By.cssSelector(".header-links-wrapper"));

        //[key='value']
        driver.findElement(By.cssSelector("[type='button']"));
        driver.findElement(By.cssSelector("[href='/search']"));
        driver.findElement(By.cssSelector("[for='pollanswers-1']"));

        //contains ->*
        driver.findElement(By.cssSelector("[href*='build']"));

        //start with ->^
        driver.findElement(By.cssSelector("[href^='/electronics']"));

    }

    @Test(priority = 6)
    public void findTableElementWithCss() {
        //print number of rows
        List<WebElement> rows = driver.findElements(By.cssSelector("li"));
        System.out.println(rows.size());
        for (WebElement element : rows) {
            System.out.println(element.getText());
        }
        System.out.println("*************************************");
    }

    @Test(priority = 7)
    public void findElementByXpath() {
        driver.findElement(By.xpath("//*[@id='topcartlink']"));
        driver.findElement(By.xpath("//*[@class='header-menu']"));
        driver.findElement(By.xpath("//*[@type='submit']"));
        driver.findElement(By.xpath("//*[@href='/books']"));

        //contains text
        driver.findElement(By.xpath("//*[contains(.,'Welcome to')]"));

        //equals
        driver.findElement(By.xpath("//*[text()='Welcome to the new Tricentis store!']"));
        driver.findElement(By.xpath("//*[.='Feel free to shop around and explore everything.']"));

        //contains
        driver.findElement(By.xpath("//*[contains(@id, 'newsletter')]"));

        //start with
        driver.findElement(By.xpath("//*[starts-with(@href,'/apparel')]"));

        //parent
        driver.findElement(By.xpath("//ul/.."));
        driver.findElement(By.xpath("//ul/parent::*"));
        driver.findElement(By.xpath("//ul/parent::div"));

        //ancestor
        driver.findElement(By.xpath("//ul/ancestor::*")); //first ancestor
        driver.findElement(By.xpath("//ul/ancestor::div"));//two steps below
        driver.findElement(By.xpath("//ul/ancestor::div[1]"));//one steps below

    }


    @AfterMethod()

    public void tearDown() {
        driver.quit();
    }

}
