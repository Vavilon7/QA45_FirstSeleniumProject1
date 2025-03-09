package com.ait.Home.Work;

import com.demoWebShop.fw.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {
    ApplicationManager app = new ApplicationManager
            (System.getProperty("browser", Browser.CHROME.browserName()));

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void startTest(Method method, Object[] p) {

        logger.info("Start test " + method.getName() + " with data: " + Arrays.asList(p));
    }

//    @AfterMethod
//    public void stopTest(ITestResult result) {
//        if (result.isSuccess()) {
//            logger.info("PASSED: " + result.getMethod().getMethodName() );
//        } else {
//            logger.error("FAILED: " + result.getMethod().getMethodName() + " Screenshot: " + app.getUser().takeScreenshot());
//        }
//        logger.info("Stop test");
//        logger.info("**********************************************************");
//    }

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        //System.out.println("Before suite");
        app.init();
    }

//    @BeforeTest
//    public void startBeforeTest() {
//        System.out.println("*****Before test");
//    }
//
//    @AfterTest
//    public void stopAfterTest() {
//        System.out.println("*****After test");
//    }

    // @AfterMethod(enabled = true)
    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        //System.out.println("After suite");
        app.stop();
    }

}