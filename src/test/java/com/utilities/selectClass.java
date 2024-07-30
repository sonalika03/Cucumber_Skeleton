package com.utilities;

import gherkin.lexer.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class selectClass {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(element);
        select.selectByValue("2");
        Thread.sleep(2000);
        select.selectByVisibleText("White");
        Thread.sleep(2000);
        select.selectByIndex(3);
        Thread.sleep(2000);
        //System.out.println(select.getFirstSelectedOption());
//        List<WebElement> options =select.getOptions();
//        for (WebElement option : options){
//            System.out.println(option);
//        }
        WebElement element1 = driver.findElement(By.id("cars"));
        Select select1 = new Select(element1);
        System.out.println(select1.isMultiple());
        select1.selectByIndex(2);
        select1.selectByValue("audi");
        Thread.sleep(2000);
        select1.selectByVisibleText("Volvo");
        Thread.sleep(2000);
        List<WebElement> options =select.getOptions();
        for (WebElement option : options){
            System.out.println(option);
        }

        System.out.println(select1.getFirstSelectedOption());
//        System.out.printlnselect1.getAllSelectedOptions());
//        select1.deselectByIndex(2);
//        Thread.sleep(2000);
//        select1.deselectByValue("audi");
//        Thread.sleep(2000);
//        select1.deselectByVisibleText("Volvo");
//        Thread.sleep(2000);
        select1.deselectAll();
        Thread.sleep(2000);
        driver.quit();

    }

}
