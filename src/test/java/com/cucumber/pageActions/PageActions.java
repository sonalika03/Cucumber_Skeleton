package com.cucumber.pageActions;

import com.cucumber.Pages.loginPage;
import com.utilities.driverSetup;
import com.utilities.txtReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PageActions {
    WebDriver driver;
    driverSetup driversetup;

    txtReader txtreader;
    public void pageActions() throws IOException, InterruptedException {
        driversetup = new driverSetup();
        driver  = driversetup.getBrowser();
        Thread.sleep(2000);

    }
    public void getTitle() throws FileNotFoundException {
        String title = driver.getTitle();
        System.out.println(title);
    }

    public void register(){
        driver.findElement(loginPage.Register).click(); //click on register
        String register = driver.findElement(loginPage.cnfrmRegister).getText();  //navigated to registration page
        System.out.println(register);
    }

    public void registration(String firstname, String lastname, String address, String city, String  state, String  zipcode, String phone, String  ssn){
        driver.findElement(loginPage.firstName).sendKeys(firstname);
        driver.findElement(loginPage.lastName).sendKeys(lastname);
        driver.findElement(loginPage.street).sendKeys(address);
        driver.findElement(loginPage.city).sendKeys(city);
        driver.findElement(loginPage.state).sendKeys(state);
        driver.findElement(loginPage.zipCode).sendKeys(zipcode);
        driver.findElement(loginPage.phoneNumber).sendKeys(phone);
        driver.findElement(loginPage.ssn).sendKeys(ssn);
    }
     public void scroll(){
         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.scrollTo(0,250)");
     }

     public void registerUsername(String username, String  password, String  confirmPassword){
         driver.findElement(loginPage.username).sendKeys(username);
         driver.findElement(loginPage.password).sendKeys(password);
         driver.findElement(loginPage.repeatPassword).sendKeys(confirmPassword);
         driver.findElement(loginPage.btnRegister).click();
         driversetup.tearDown();
     }


}
