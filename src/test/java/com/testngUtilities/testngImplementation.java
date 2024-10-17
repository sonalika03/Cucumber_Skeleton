package com.testngUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class testngImplementation {
    //Hard and soft asserts
    //Annotations
    WebDriver driver;
    @BeforeTest
    public void launchURL(){
        driver = new ChromeDriver();
        System.out.println("Im in BeforeTest");
    }

    @Test
    public void username(){
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
    }

    @Test(priority = 1)
    public void password(){
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
    }

    @Test(priority = 2)
    public void login(){
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test(priority = 3)
    public void logout(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//a[@class='button secondary radius']")).click();
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}
