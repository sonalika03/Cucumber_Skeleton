package com.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class alertsAndActions {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
//        acceptAlert(driver);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,350)");
//        dismissAlert(driver);
//        enterText(driver);
//        waitForAlertAndAccept(driver);
//        getTextFromAlert(driver);
//        getWindowHandles(driver);
//        actionClassKeyBoard(driver);
//        actionClassMouseHover(driver);
        actionClassMouseEvents(driver);
        driver.quit();
    }
    public static void acceptAlert(WebDriver driver){
        driver.findElement(By.xpath("//div[@class='row']/child::div[2]/child::button")).click();
        driver.switchTo().alert().accept();
    }
    public static void dismissAlert(WebDriver driver){
        driver.findElement(By.xpath("//button[@id='confirmButton']")).click();  //button[@type='button',contains(text(),'Click me')]
        driver.switchTo().alert().dismiss();
    }
    public static void enterText(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//button[@id='promtButton']")).click();
        driver.switchTo().alert().sendKeys("Sonalika");
        driver.switchTo().alert().accept();
        System.out.println(driver.findElement(By.xpath("//div/span[@id='promptResult']")).getText());
    }
    public static void waitForAlertAndAccept(WebDriver driver){
        driver.findElement(By.xpath("//button[@id='timerAlertButton']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public static void getTextFromAlert(WebDriver driver){
        driver.findElement(By.xpath("//div[@class='row']/child::div[2]/child::button")).click();
        System.out.println(driver.switchTo().alert().getText());
    }

    public static void getWindowHandles(WebDriver driver){
        driver.findElement(By.xpath("//span[text()='Browser Windows']")).click();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,200)");
        driver.findElement(By.xpath("//button[@id='windowButton']")).click();
        driver.findElement(By.xpath("//button[@id='messageWindowButton']")).click();
        String mainWindow= driver.getWindowHandle();
        System.out.println(mainWindow);
        Set<String> handles = driver.getWindowHandles();
        System.out.println(handles);
        Iterator<String> childWindow = handles.iterator();
            while (childWindow.hasNext()){
                String childWindows = childWindow.next();
                if (!childWindows.equalsIgnoreCase(mainWindow)){
                    driver.switchTo().window(childWindows);
                    driver.close();
                }
        }
            driver.switchTo().window(mainWindow);
    }

    public static void actionClassKeyBoard(WebDriver driver){
        Actions actions= new Actions(driver);
        driver.findElement(By.xpath("//div[text()='Elements']")).click();
        driver.findElement(By.xpath("//span[text()='Text Box']")).click();
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,150)");
        driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("Practice Test");
        actions.sendKeys(Keys.TAB);
        actions.sendKeys("example@demo.com");
        actions.sendKeys(Keys.TAB);
        actions.sendKeys("1-4-870/1, Goshala ROAD");
//        actions.build().perform();
//        driver.findElement(By.xpath("//input[@placeholder='name@example.com']")).sendKeys("example@demo.com");
        String Address = driver.findElement(By.xpath("//textarea[@placeholder='Current Address']")).getText();
        String Address2 = driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).getText();
//        Address.sendKeys("1-4-870/1, Goshala ROAD");
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("A");
        actions.sendKeys("C");
        actions.keyUp(Keys.CONTROL);
//        actions.build().perform();
        actions.sendKeys(Keys.TAB);
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("V");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
        Assert.assertEquals(Address,Address2);
    }

    public static void actionClassMouseHover(WebDriver driver) throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("//div[text()='Widgets']")).click();
        WebElement menu = driver.findElement(By.xpath("//span[text()='Menu']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", menu);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Menu']")).click();
        WebElement item = driver.findElement(By.linkText("Main Item 2"));
        js.executeScript("arguments[0].scrollIntoView()", item);
        actions.moveToElement(item).build().perform();
        WebElement subItem = driver.findElement(By.linkText("SUB SUB LIST »"));
        actions.moveToElement(subItem).build().perform();
        WebElement subItems2 = driver.findElement(By.linkText("Sub Sub Item 1"));
        actions.moveToElement(subItems2).build().perform();
    }

    public static void actionClassMouseEvents(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("//div[text()='Elements']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Buttons']")).click();
        WebElement doubleClick = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
        js.executeScript("arguments[0].scrollIntoView()", doubleClick);
        WebElement rightClick = driver.findElement(By.xpath("//button[@id='rightClickBtn']"));
        WebElement click = driver.findElement(By.xpath("//button[text()='Click Me']"));
        js.executeScript("arguments[0].scrollIntoView()", click);
        actions.contextClick(rightClick);
        actions.doubleClick(doubleClick);
        actions.click(click);
        actions.perform();
        driver.findElement(By.xpath("//p[@id='doubleClickMessage']")).isDisplayed();
        driver.findElement(By.xpath("//p[@id='rightClickMessage']")).isDisplayed();
        driver.findElement(By.xpath("//p[@id='dynamicClickMessage']")).isDisplayed();
    }
}
