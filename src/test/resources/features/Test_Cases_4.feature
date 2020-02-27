
Feature: Test Cases 4
  Scenario:Test 1: Three dots are displayed
    Given the user is on the login page
    When user logs in using "storemanager85" and "UserUser123"
    And the user navigates "Activities" "Calendar Events"
    Then three options are available
  Scenario: Test 2:the title column is displayed
    Given the user is on the login page
    When user logs in using "storemanager85" and "UserUser123"
    And the user navigates "Activities" "Calendar Events"
    Then the title column is displayed

  Scenario: Test 3: Save and Close menu items displayed
    Given the user is on the login page
    When the user enter the store manager information
    And the user navigates "Activities" "Calendar Events"
    And the user navigates to Create Calendar Event
    Then Save and Close menu items displayed


  Scenario:Test 4 All Calendar Events subtitle is displayed
    Given the user is on the login page
    When the user enter the store manager information
    And the user navigates "Activities" "Calendar Events"
    And the user navigates to Create Calendar Event
    Then All Calendar Events subtitle is displayed

  Scenario:Test 5 verify hour difference is just one hour
    Given the user is on the login page
    When the user enter the store manager information
    And the user navigates "Activities" "Calendar Events"
    And the user navigates to Create Calendar Event
    Then verify hour difference is just one hour

  Scenario:Test 6 Verify end time as one hour later
    Given the user is on the login page
    When the user enter the store manager information
    And the user navigates "Activities" "Calendar Events"
    And the user navigates to Create Calendar Event
    Then Verify end time as one hour later

  Scenario:Test 7 Verify that start and end date input boxes are displayed
    Given the user is on the login page
    When the user enter the store manager information
    And the user navigates "Activities" "Calendar Events"
    And the user navigates to Create Calendar Event
    Then Verify that start and end date input boxes are displayed

  Scenario:Test 8 Verify that start and end date input boxes are displayed
    Given the user is on the login page
    When the user enter the store manager information
    And the user navigates "Activities" "Calendar Events"
    And the user navigates to Create Calendar Event
    Then Verify that Daily is selected by default

  Scenario: Test 9 Verify that following message as a summary is displayed: “Summary: Daily every 1 day”
    Given the user is on the login page
    When the user enter the store manager information
    And the user navigates "Activities" "Calendar Events"
    And the user navigates to Create Calendar Event
    Then Verify “Summary: Daily every 1 day” is displayed

  @cases
  Scenario: Test 10 Verify that following message as a summary is displayed: “Summary: Daily every 1 day, end
  after 10 occurrences”
    Given the user is on the login page
    When the user enter the store manager information
    And the user navigates "Activities" "Calendar Events"
    And the user navigates to Create Calendar Event
    Then Verify “Daily every 1 day, end  after 10 occurrences”



