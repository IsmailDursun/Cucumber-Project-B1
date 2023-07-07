Feature: Google Search Functionality Title Verification
  User story: As a user, when I am on the Google search page
  I should be able to search whatever I want and see relevant information


  Scenario: Search functionality result title verification
    Given user is on Google search page
    When user types loop academy in the google search box and click enter
    Then User should see Loop Academy - Google search is in the google title


  Scenario: Search functionality result title verification
    Given user is on Google search page
    When user types "Loop Academy" in the google search box and click enter
    Then User should see "Loop Academy - Google" search is in the google title