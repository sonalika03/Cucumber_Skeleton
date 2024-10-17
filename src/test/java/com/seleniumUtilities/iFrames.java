package com.seleniumUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class iFrames {

        WebDriver driver = new ChromeDriver();


    public void iframemethod(){
        driver.get("https://demoqa.com/frames");
        driver.manage().window().maximize();
        int countIframesInPage = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of Frames on a Page:" + countIframesInPage);
        driver.switchTo().frame(driver.findElement(By.id("frame1")));  //switch to iframe using webelement
        driver.switchTo().defaultContent();    //switch back to main webpage
        driver.switchTo().frame("frame1");   // switch to iframe using id
        System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame2");
        System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());


        //Nested iFrames
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://demoqa.com/nestedframes");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame1']")));
        System.out.println(driver.findElement(By.xpath("//body[text()='Parent frame']")).getText());
        driver.switchTo().frame(driver.findElement(By.xpath("//body[text()='Parent frame']/iframe")));
        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.xpath("//h1[text()='Nested Frames']")).getText());
        driver.quit();

        //Dynamic iframes - It can be identified using the index or bu=y using the 'contains' syntax
    }
}
