package com.cucumber.Pages;

import org.openqa.selenium.By;

public class loginPage {

    public static By Register = By.xpath("//a[text()='Register']");
    public static By cnfrmRegister = By.xpath("//body/div/div[3]/div[2]/h1");
    public static By firstName = By.xpath("//input[@id='customer.firstName']");
    public static By lastName = By.xpath("//input[@id='customer.lastName']");
    public static By street = By.xpath("//input[@id='customer.address.street']");
    public static By city = By.xpath("//input[@id='customer.address.city']");
    public static By state = By.xpath("//input[@id='customer.address.state']");
    public static By zipCode = By.xpath("//input[@id='customer.address.zipCode']");
    public static By phoneNumber = By.xpath("//input[@id='customer.phoneNumber']");
    public static By ssn = By.xpath("//input[@id='customer.ssn']");
    public static By username = By.xpath("//input[@id='customer.username']");
    public static By password = By.xpath("//input[@id='customer.password']");
    public static By repeatPassword = By.xpath("//input[@id='repeatedPassword']");
    public static By btnRegister = By.xpath("//input[@value='Register']");

}
