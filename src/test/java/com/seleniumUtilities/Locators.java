package com.seleniumUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class Locators {
     public static void main(String[] args) throws InterruptedException {
          WebDriver driver = new ChromeDriver();
          driver.get("https://demoqa.com/automation-practice-form");
          driver.manage().window().maximize();
          //By using ID
          driver.findElement(By.id("firstName")).sendKeys("Sonalika");
          driver.findElement(By.id("lastName")).sendKeys("Goud");
          driver.findElement(By.id("userEmail")).sendKeys("goudsonali@gmail.com");
//          By abc = RelativeLocator.with(By.tagName("input")).below(By.id("lastName"));

          JavascriptExecutor js = (JavascriptExecutor)driver;
          js.executeScript("window.scrollBy(0,300)");

          Thread.sleep(200);

          driver.findElement(By.xpath("(//div/label[@class='custom-control-label'])[1]")).click();
          System.out.println(driver.findElement(By.xpath("//input[@value='Male']")).isSelected());

          //parent to child traverse in xpath
          driver.findElement(By.xpath("//div[@id='userNumber-wrapper']/div[2]/input")).sendKeys("9874083830");
          //parent to child traverse in css
          System.out.println(driver.findElement(By.cssSelector("div[id='userNumber-wrapper'] div:nth-child(2)")).getText());

          //child to parent traverse
          //input[@id='subjectsInput']/ancestor::div[3]
          //input[@id='subjectsInput']/parent::div/parent::div/parent::div
          driver.findElement(By.xpath("//input[@id='subjectsInput']")).sendKeys("subject");

          //find the xpath of the locator, traverse to parent locator, traverse to following sibling locator
          driver.findElement(By.xpath("//div[@class='col-md-9 col-sm-12']/div/input[@id='hobbies-checkbox-1']/parent::div/following-sibling::div[1]")).click();
          driver.quit();

     }



}
