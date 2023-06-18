Feature: Docuport Login Logout Feature
@smoke
  Scenario: Login as a client
      Given user is on Docuport login page
    When user enters username for client
    And user  enters password for client
    And user click login buton
    Then user should see the home page for client

  Scenario: Login as an employee
    Given user is on Docuport login page
    When user enters username for employee
    And user  enters password for employee
    And user click login buton
    Then user should see the home page for employee
