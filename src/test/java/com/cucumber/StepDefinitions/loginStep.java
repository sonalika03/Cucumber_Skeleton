package com.cucumber.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import com.cucumber.pageActions.*;

import java.io.IOException;

public class loginStep {
    PageActions actions= new PageActions();
    @Given("^I am on homepage$")
    public void i_am_on_homepage() throws InterruptedException,IOException {
        actions.pageActions();
    }

    @Given("^I should be on homepage$")
    public void i_should_be_on_homepage() {
        actions.getTitle();
    }

    @When("I click on the register and should be navigated to registration page")
    public void i_click_on_the_register_and_should_be_navigated_to_registration_page() {
        actions.register();
    }

    @When("^I enter the firstname (.*) lastname (.*) address (.*) city (.*) state (.*) zipcode (.*) phone (.*) ssn (.*)$")
    public void i_Enter_The_Firstname_Lastname_Address_City_State_Zipcode_Phone_Ssn(String firstname, String lastname, String address, String city, String state, String zipcode, String phone, String ssn) throws InterruptedException {
        actions.registration(firstname, lastname, address, city, state, zipcode, phone, ssn);
        actions.scroll();
       Thread.sleep(2000);
    }

    @When("^I enter the username (.*) password (.*) and confirm password (.*) and click on register$")
    public void i_Enter_The_Username_Password_And_Confirm_Password_and_click_on_register(String username, String password, String confirmPassword) {
       actions.registerUsername(username, password, confirmPassword);
    }

}
