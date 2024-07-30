package com.utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotClass {
    public void robotClassMethod() throws AWTException, InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.get("https://demoqa.com/upload-download");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement uploadFileBtn = driver.findElement(By.xpath("//label[@for='uploadFile']"));
        js.executeScript("arguments[0].scrollIntoView",uploadFileBtn);
        uploadFileBtn.click();
        Point location = uploadFileBtn.getLocation();
        System.out.println(location.getX() + "," +location.getY());
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_SHIFT);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_UP);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
    }
}
