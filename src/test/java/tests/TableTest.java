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

public class TableTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver=new ChromeDriver();
        driver.get("https://www.w3schools.com/css/css_table.asp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void findTableElementWithCss(){
        //print number of rows
        List<WebElement> rows=driver.findElements(By.cssSelector("tr"));
        System.out.println(rows.size());
        for (WebElement element:rows){
            System.out.println(element.getText());
        }
        System.out.println("**************************************");
        for (int i=0; i<rows.size();i++){
            System.out.println(rows.get(i).getText());
        }
        System.out.println("*************************************");

        //get row4
        WebElement row4=driver.findElement(By.cssSelector("tr:nth-child(4)"));
        System.out.println(row4.getText());
        System.out.println("*************************");

        //get row 4, second element
        WebElement francisco = driver.findElement(By.cssSelector("tr:nth-child(4) td:nth-child(2)"));
        System.out.println(francisco.getText());
    }

}
