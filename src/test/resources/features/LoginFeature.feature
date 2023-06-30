Feature: Docuport Login Logout Feature

  Background: will run for each scenario first
    Given user is on Docuport login page

  @smoke @regression
  Scenario: Login as a client
    When user enters username for client
    And user enters password for client
    And user clicks login button
    Then user should see the home page for client

  @regression
  Scenario: Login as a employee
    When user enters username for employee
    And user enters password for employee
    And user clicks login button
    Then user should see the home page for employee

  @regression
  Scenario: Login as a advisor
    When user enters username for advisor
    And user enters password for advisor
    And user clicks login button
    Then user should see the home page for advisor

  @regression
  Scenario: Login as a admin
    When user enters username for admin
    And user enters password for admin
    And user clicks login button
    Then user should see the home page for admin

@regression
  Scenario: Login as an client map practice
    When user enters credentials
      | username | b1g1_client@gmail.com |
      | password | group1                |
    Then user should see the home page for client


