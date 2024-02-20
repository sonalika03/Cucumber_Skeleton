package com.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class driverSetup {
    private WebDriver driver;
    Properties prop = null;
    FileInputStream fis;
    String Proj_Path = System.getProperty("user.dir");
    String path = Proj_Path+"\\src\\test\\resources\\Properties\\Global.properties";

    public driverSetup() throws IOException {
        prop = new Properties();
        fis = new FileInputStream(path);
        prop.load(fis);
    }

    public WebDriver getBrowser() throws IOException {
        String Browser = (String) prop.get("browser");
        switch (Browser){
            case "Chrome":
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "Firefox":
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "Edge":
            case "EdgeBrowser":
                WebDriverManager.edgedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            default:
                System.out.println("The Browser doesnot exists in the stack.....");
                System.out.println("By default proceeding with the Chrome Browser");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
        String url = (String) prop.get("url");
        driver.get(url);
        return driver;
    }

    public void tearDown(){
        if(driver!=null)
            driver.quit();
    }
}
