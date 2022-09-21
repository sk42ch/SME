package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class SMEDriver {

    private static WebDriver driver;

    @BeforeClass
    public void setUp(){
        /*Run This Command from Google Chrome File Location
         * Create ChromeData Folder and use the path
         * cd "C:\Program Files\Google\Chrome\Application"
         * chrome.exe --remote-debugging-port=9988 --user-data-dir="C:\Users\sohel\OneDrive\Desktop\ChromeData"
        */

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setExperimentalOption("debuggerAddress","localhost:9988");
        driver = new ChromeDriver(opt);
       // driver = new ChromeDriver();
        driver.get("https://www.youtube.com/channel_switcher");

    }

    @AfterClass
    public void tearDown(){
        driver.quit();

    }

    public static WebDriver getSMEDriver(){
        return driver;
    }

}
