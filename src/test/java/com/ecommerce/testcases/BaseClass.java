package com.ecommerce.testcases;

import com.ecommerce.utilities.Readconfig;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseClass {
    // Create methods which will be called from all the classes
    // Create object of ReadConfig.java class to read from that class

    Readconfig readconfigObj = new Readconfig();

    //Read values from readconfig file

    //store value of url from Readconfig class
    String url = readconfigObj.getBaseUrl();

    //store value of browser from Readconfig class
    String browser = readconfigObj.getBrowser();

    // Create an object of WebDriver
    public static WebDriver driver;

    // Create variable of logger class
    public static Logger logger;

    // Launch browser as mentioned in the Config.properties file
    @BeforeClass //Write a method to set value of browser
    //In this class setup method will be executed first
    public void setup() {
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "msedge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                driver = null;
                break;
        }
        driver.manage().window().maximize();
        // wait command before a browser is launched
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // Initialize logger object
        logger = LogManager.getLogger("EcommerceTesting");
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        logger.info("URL opened");
    }

    // Teardown to close and quit the browser
    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
        logger.info("url closed");
    }
    // use method to capture screenshot
    public void captureScreenShot(WebDriver driver, String testName) throws IOException {
        // step1: convert webdriver object to TakesScreenshot interface
        TakesScreenshot screenshot = ((TakesScreenshot) driver);

        // step2: call getScreenshotAs method to create image file

        File src = screenshot.getScreenshotAs(OutputType.FILE); //source

        File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");//destination

        // step3: copy image file from source to destination
        FileUtils.copyFile(src, dest);
    }

    }
