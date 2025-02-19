package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FirstSeleniumTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app");// открытие сайта без истории
        //driver.navigate().to("https://ilcarro.web.app");//открытие сайта с историей
        //driver.navigate().back();
        driver.manage().window().maximize();
        //wait for all elements on the website to load before staring test
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @Test
    public void openChromeTest() {
        System.out.println("Browser opens!");
    }

    @Test
    public void findElementsByTagName() {
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());
        WebElement element1 = driver.findElement(By.tagName("h2"));
        System.out.println(element1.getText());
        WebElement element2 = driver.findElement(By.tagName("a"));
        System.out.println(element2.getText());
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());

    }

    @Test
    public void findElementById() {
        driver.findElement(By.id("city"));
        driver.findElement(By.id("dates"));

    }

    @Test
    public void findElementByClassName() {
        WebElement element = driver.findElement(By.className("header"));
        System.out.println(element.getText());

        List<WebElement> elements = driver.findElements(By.className("logo"));
        System.out.println(elements.size());

        WebElement element1 = driver.findElement(By.className("navigation-link"));
        System.out.println(element1.getText());
    }

    @Test
    public void findElementByLinkText() {
        WebElement linkText = driver.findElement(By.linkText("Let the car work"));
        System.out.println(linkText.getText());

        System.out.println("*************************************************");

        WebElement linkText1 = driver.findElement(By.linkText("Terms of use"));
        System.out.println(linkText1.getText());

        WebElement partialLinkText = driver.findElement(By.partialLinkText("Let the car work"));
        System.out.println(partialLinkText.getText());
    }

    @Test
    public void findElementByCssSelector() {
        //tagName->css
        //driver.findElement(By.tagName"h1"));
        driver.findElement(By.cssSelector("h1"));

        //id -> css - #
        driver.findElement(By.cssSelector("#city"));

        //className ->css-.
        driver.findElement(By.cssSelector(".header"));

        //[key='value']
        driver.findElement(By.cssSelector("[type='submit']"));
        driver.findElement(By.cssSelector("[href='/search']"));
        driver.findElement(By.cssSelector("[for='dates']"));

        //contains ->*
        driver.findElement(By.cssSelector("[href*='results?']"));
        //start with ->^
        driver.findElement(By.cssSelector("[href^='/let']"));
        //end on ->$
        driver.findElement(By.cssSelector("[href$='Tokyo']"));

    }
    @Test
    public void findElementByXpath() {
        // xpath -> //*[@key='value']
        //driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.xpath("//h1"));
        driver.findElement(By.xpath("//*[@id='city']"));
        driver.findElement(By.xpath("//*[@class='header']"));
        driver.findElement(By.xpath("//*[@type='submit']"));
        driver.findElement(By.xpath("//*[@href='/search']"));
        driver.findElement(By.xpath("//*[@for='dates']"));
        //contains text
        driver.findElement(By.xpath("//*[contains(.,'Find your')]"));

        //equals
        driver.findElement(By.xpath("//*[text()='Find your car now!']"));
        driver.findElement(By.xpath("//*[.='Find your car now!']"));

        //contains
        driver.findElement(By.xpath("//*contains(@href,'results?')]"));

        //start with
        driver.findElement(By.xpath("//*[starts-with(@href,'/let')]"));

        //parent
        driver.findElement(By.xpath("//h1/.."));
        driver.findElement(By.xpath("//h1/parent::*"));
        driver.findElement(By.xpath("//h1/parent::div"));

        //ancestor
        driver.findElement(By.xpath("//h1/ancestor::*")); //first ancestor
        driver.findElement(By.xpath("//h1/ancestor::div"));//two steps below
        driver.findElement(By.xpath("//h1/ancestor::div[1]"));//one steps below


    }

    @AfterMethod()

    public void tearDown() {
        driver.quit();// закрываются все вкладки
        //driver.close();// закрывает только одна вкладка, текущая
    }

}
