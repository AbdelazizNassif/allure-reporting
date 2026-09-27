package com.petfinder.tests.regressionE2eTests;

import driverSettigns.DriverFactory;
import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import utils.AllureScreenshotListener;
// import utils.ScreenshotUtil;

@Listeners(AllureScreenshotListener.class)
public class BaseTest {

    public WebDriver driver = null;
    public Dotenv dotenv = null;

    @BeforeClass
    @Description("Initialize chrome browser")
    public void initializeDriver() {
        driver = DriverFactory.createDriver();
        driver.manage().window().maximize();
        dotenv = Dotenv.load();
    }

    @AfterClass
    @Description("Initialize chrome browser")
    public void quitDriver() {
        DriverFactory.quitDriver();
    }

//    @AfterMethod
//    @Description("Take screenshot")
//    public void takeScreenShot(ITestResult result) {
//        new ScreenshotUtil().
//                attachScreenshotToAllureReport(driver, result.getName());
//    }


}


