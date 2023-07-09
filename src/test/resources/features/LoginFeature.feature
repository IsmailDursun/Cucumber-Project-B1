Feature: Docuport Login Logout Feature

  Background: will run for each scenario first
    Given user is on Docuport login page


  @login
  Scenario: Login as a client
    Given user is on Docuport login page
    When user enters username for client
    And user enters password for client
    And user clicks login button
    Then user should see the home page for client

  @login
  Scenario: Login as an employee
    Given user is on Docuport login page
    When user enters username for employee
    And user enters password for employee
    And user clicks login button
    Then user should see the home page for employee

  @login
  Scenario: Login as a advisor
    Given user is on Docuport login page
    When user enters username for advisor
    And user enters password for advisor
    And user clicks login button
    Then user should see the home page for advisor

  @login
  Scenario: Login as an admin
    Given user is on Docuport login page
    When user enters username for admin
    And user enters password for advisor
    And user clicks login button
    Then user should see the home page for admin

  @login
  Scenario: Login as a client map practice
    When user enters credentials
      | username | b1g3_client@gmail.com |
      | password | Group3                |
#      | username | b1g3_employee@gmail.com |
#      | password | Group3                |
#      | username | b1g3_advisor@gmail.com |
#      | password | Group3                |
#      | username | b1g3_supervisor@gmail.com |
#      | password | Group3                |


    Then user should see the home page for client


  @login
  Scenario Outline: Login as a different users  map practice
    When user enters "<username>" and "<password>"
    Then validate left navigation bar
      | Client          | Supervisor      | Advisor         | Employee        |
      | Home            | Home            | Home            | Home            |
      | Received docs   | Received docs   | Received docs   | Received docs   |
      | My uploads      | My uploads      | My uploads      | My uploads      |
      | Invitations     | Clients         | Clients         | Clients         |
      | 1099 Form       | Users           | Invitations     | Users           |
      | Reconciliations | Leads           | Users           | Bookkeeping     |
      |                 | Bookkeeping     | Leads           | 1099 Form       |
      |                 | 1099 Form       | Bookkeeping     | Reconciliations |
      |                 | Reconciliations | 1099 Form       |                 |
      |                 |                 | Reconciliations |                 |
    Examples:
      | username                  | password |
      | b1g3_client@gmail.com     | Group3   |
      | b1g3_supervisor@gmail.com | Group3   |
      | b1g3_advisor@gmail.com    | Group3   |
      | b1g3_employee@gmail.com   | Group3   |

  @login
  Scenario: Login as an advisor
    When user enters username for advisor
    And user enters password for advisor
    And user clicks login button
    And user should see the home page for advisor

    And the user clicks CLIENTS button

    And they click “Create new client” button and choose PERSONAL,

    And the user sees client creation pop up window.

    And the user filled all the information about new client
      | firstName | lastName | email              | phoneNumber | password |
      | Ali       | Veli     | aliveli5@gmail.com | 9186532412  | Asdf00   |

    And they click SAVE button

    And the user sees Confirmation text - “<CLIENT FULL NAME> been created successfully”

    And  the user is redirected to “EDIT CLIENT” page.

    And the user filled out all fields

    And they click SAVE button

    And the user sees Confirmation “ <CLIENT FULL NAME> has been updated successfully”

    And the user LOG OUT of the APP

    And they LOG IN as a new client which was created

    Then the user should see the home page

#  @login
#  Scenario Outline: Login as a different users
#    Given user is on Docuport login page
#    When user enters "<username>" and "<password>"
#    And user clicks on Received docs
#    And user sees buttons on the page1
#      | Search | Download | Received docs |
#    And user clicks on my uploads
#    Then user sees buttons on the page
#      | Search | Download | My uploads |
#    Examples:
#      | username                  | password |
#      | b1g3_advisor@gmail.com    | Group3   |
#      | b1g3_client@gmail.com     | Group3   |
#      | b1g3_employee@gmail.com   | Group3   |
#      | b1g3_supervisor@gmail.com | Group3   |