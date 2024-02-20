@FirstTest

Feature: Para Bank
  As a user, I should be able to login using username and password

  Background:
    Given I am on homepage

  Scenario: Sign up by giving the personal information
    Given I should be on homepage
    When I click on the register and should be navigated to registration page
    When I enter the firstname lastname address city state zipcode phone ssn
    When I enter the username password and confirm password and click on register