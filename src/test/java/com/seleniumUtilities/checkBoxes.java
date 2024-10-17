package com.seleniumUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class checkBoxes {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
//        driver.navigate("https://demoqa.com/radio-button");
        driver.manage().window().maximize();
        selectCheckBox(driver);
        selectRadioButtons(driver);
        driver.quit();
    }
    public static void selectCheckBox(WebDriver driver){
        //can use IsSelected, IsDisplayed and IsEnabled
        driver.findElement(By.xpath("//label[@for='tree-node-home']/preceding::button[1]")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView", driver.findElement(By.xpath("//label[@for='tree-node-desktop']/preceding::button[1]")));
        driver.findElement(By.xpath("//label[@for='tree-node-desktop']/preceding::button[1]")).click();
        driver.findElement(By.xpath("//span[text()='Notes']")).click();
        System.out.println(driver.findElement(By.xpath("//label[@for='tree-node-home']/span[1]")).isSelected());
    }

    public static void selectRadioButtons(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement yes = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        js.executeScript("window.scrollBy(0,100)");
        WebElement impressive = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        WebElement no = driver.findElement(By.xpath("//label[@for='noRadio']"));
        Thread.sleep(2000);
        if (yes.isEnabled())
        {
            yes.click();
        }else System.out.println(yes +"Element is not Enabled");

        if (impressive.isEnabled())
        {
            impressive.click();
        }else System.out.println(impressive +"Element is not Enabled");

        try {
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(no));
            no.click();
        } catch (Exception e) {
            System.out.println(no +"Element is not Clickable");
        }
    }


}
