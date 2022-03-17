package com.automationpractice.driver;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    public static WebDriver webDriver;

    @Before
    public void initializeTest() {
        try {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-notification");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("disable-plugins");
            chromeOptions.addArguments("disable-popup-blocking");
            chromeOptions.addArguments("ignore-certificate-errors");
            chromeOptions.addArguments("disable-translate");

            webDriver = new ChromeDriver(chromeOptions);
            webDriver.manage().window().maximize();
            webDriver.get("http://automationpractice.com/index.php");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.close();
            webDriver.quit();
        }
    }
}
