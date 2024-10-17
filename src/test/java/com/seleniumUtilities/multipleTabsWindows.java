package com.seleniumUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class multipleTabsWindows {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        tabs(driver);
    }
    public static void tabs(WebDriver driver) throws InterruptedException {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();
        Thread.sleep(2000);
//        driver.switchTo().newWindow(WindowType.TAB);  //to create a new tab
//        driver.get("https://www.amazon.in//");
//        Thread.sleep(2000);
        String currentHandle = driver.getWindowHandle();
        System.out.println(currentHandle);
        Set<String> Handles = driver.getWindowHandles();
        System.out.println(Handles);
        for (String handle :Handles){
            if (!handle.equalsIgnoreCase(currentHandle)){
                driver.switchTo().window(handle);
                System.out.println(driver.getTitle());
            }

        }
        driver.quit();
    }

}
//can also create new tab or switch to tab using actions class keyDown and sendKeys