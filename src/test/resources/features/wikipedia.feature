Feature: Wikipedia search and verification

  @wiki
  Scenario: Search functionality result title validation
    Given user is on Wikipedia home page
    When user searches "Steve Jobs" in the wiki search box
    Then user should see "Steve Jobs - Wikipedia" is in the wiki title

  @wiki
  Scenario: Search functionality result header validation
    Given user is on Wikipedia home page
    When user searches "Steve Jobs" in the wiki search box
    Then user should see "Steve Jobs" is in the main header

  @wiki
  Scenario: Search functionality result header validation
    Given user is on Wikipedia home page
    When user searches "Steve Jobs" in the wiki search box
    Then user should see "Steve Jobs" is in the image header

  @wiki
  Scenario Outline: Search functionality result header validation
    Given user is on Wikipedia home page
    When user searches for  the "<name>"
    Then user should see the  "<name>" in the "<result>"
    Examples:
      | name       | result       |
      | Steve Jobs | title        |
      | Steve Jobs | header       |
      | Steve Jobs | image header |