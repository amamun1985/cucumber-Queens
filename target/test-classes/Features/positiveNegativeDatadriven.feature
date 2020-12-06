@LoginTest
Feature: Test login functionalities

  @PositiveTest
  Scenario: Check login is successful with valid credentials
    Given a user is on the login page
    When user enters username "mamun" and password "12345"
    And click on login button
    Then user is navigated to the home page
  @NegativeTest
  Scenario: Check login is unsuccessful with invalid credentials
    Given a user is on the login page
    When user enters username "mamun" and password "444444"
    And click on login button
    Then user is failed to login
    @negativeTest1
    Scenario: Check login is unsuccessful with invalid credentials
      Given a user is on the login page
      When user enters username "mamunAbdullah" and password "44444445"
      And click on login button
      Then user is failed to login
  @DataDrivenTest
  Scenario Outline: Check login is successful with valid credentials for multiple users
    Given a user is on the login page
    When user enters username "<username>" and password "<password>"
    And click on login button
    Then user is navigated to the home page

    Examples:
      |username|password|
      |mamun   |12345   |
      |Hasan   |12345   |
