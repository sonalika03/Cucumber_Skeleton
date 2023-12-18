Feature: Para Bank
  As a user, I should be able to login using username and password

  Background:
    Given I am on homepage

  Scenario Outline: Sign up by giving the personal information
    Given I should be on homepage
    When I click on the register
    Then I should be navigated to registration page
    When I enter the firstname <firstname> lastname <lastname> address <address> city <city> state <state> zipcode <zipcode> phone <phone> ssn <ssn>
    When I enter the username <username> password <password> and confirm password <confirm password>
    Then I click on register

    Examples:
      | firstname | lastname | address      | city   | state  | zipcode | phone      | ssn | username | password     | confirm password |
      | samuel    | john     | cross street | bodhan | kerala | 578935  | 9876543210 | 556 | test1234 | test1234@123 | test1234@123     |