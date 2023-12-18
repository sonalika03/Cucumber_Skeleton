package com.cucumber.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginStep {
    private WebDriver driver;

    @Given("^I am on homepage$")
    public void i_am_on_homepage() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @Given("^I should be on homepage$")
    public void i_should_be_on_homepage() {
        String title = driver.getTitle();
        System.out.println(title);
    }

    @When("I click on the register")
    public void i_click_on_the_register() {
        driver.findElement(By.xpath("//a[text()='Register']")).click();
    }

    @Then("I should be navigated to registration page")
    public void i_should_be_navigated_to_registration_page() {
        String register = driver.findElement(By.xpath("//body/div/div[3]/div[2]/h1")).getText();
        System.out.println(register);
    }

    @When("^I enter the firstname (.*) lastname (.*) address (.*) city (.*) state (.*) zipcode (.*) phone (.*) ssn (.*)$")
    public void i_Enter_The_Firstname_Lastname_Address_City_State_Zipcode_Phone_Ssn(String firstname, String lastname, String address, String city, String state, String zipcode, String phone, String ssn) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='customer.firstName']")).sendKeys(firstname);
        driver.findElement(By.xpath("//input[@id='customer.lastName']")).sendKeys(lastname);
        driver.findElement(By.xpath("//input[@id='customer.address.street']")).sendKeys(address);
        driver.findElement(By.xpath("//input[@id='customer.address.city']")).sendKeys(city);
        driver.findElement(By.xpath("//input[@id='customer.address.state']")).sendKeys(state);
        driver.findElement(By.xpath("//input[@id='customer.address.zipCode']")).sendKeys(zipcode);
        driver.findElement(By.xpath("//input[@id='customer.phoneNumber']")).sendKeys(phone);
        driver.findElement(By.xpath("//input[@id='customer.ssn']")).sendKeys(ssn);
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollTo(0,250)");
       Thread.sleep(2000);
    }

    @When("^I enter the username (.*) password (.*) and confirm password (.*)$")
    public void i_Enter_The_Username_Password_And_Confirm_Password(String username, String password, String confirmPassword) {
        driver.findElement(By.xpath("//input[@id='customer.username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='customer.password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='repeatedPassword']")).sendKeys(confirmPassword);
    }

    @Then("I click on register")
    public void i_click_on_register() {
        driver.findElement(By.xpath("//input[@value='Register']")).click();
        driver.quit();
    }


}
