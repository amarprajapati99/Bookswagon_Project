package com.bridgelabz.selenium.bookswagon.base;

import com.bridgelabz.selenium.bookswagon.utility.EmailReport;
import com.bridgelabz.selenium.bookswagon.utility.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class BaseClass {

    public static WebDriver driver;
    URL url;
    URLConnection connection;

    @BeforeTest
    public void setUp() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        Log.info("launching the Chrome browser");
        driver = new ChromeDriver(options);
        try {
            url = new URL("https://www.bookswagon.com/");
            connection = url.openConnection();
            connection.connect();
            Log.info("Internet is connected");
        } catch (IOException e) {
            e.printStackTrace();
            Log.info("Internet is not connected");
        }
        Log.info("Navigate to url : https://www.bookswagon.com/ ");
        driver.get("https://www.bookswagon.com/");
        driver.manage().window().maximize();
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @AfterTest
    public void closeBrowser() {
//        EmailReport.sendMail();
//        Log.info("send report to gmail");
        driver.quit();
    }
}