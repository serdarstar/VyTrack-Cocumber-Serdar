
Feature: Login with parameters
  @store @regression
  Scenario: Login as a driver
    Given the user is on the login page
    When user logs in using "user11" and "UserUser123"
    Then the user should be able to login
    And the title should contains "Dashboard"

    @regression
  Scenario: Login as a sales manager
    Given the user is on the login page
    When user logs in using "salesmanager123" and "UserUser123"
    Then the user should be able to login

  @regression
  Scenario: Login as a store manager
    Given the user is on the login page
    When user logs in using "storemanager85" and "UserUser123"
    Then the user should be able to login