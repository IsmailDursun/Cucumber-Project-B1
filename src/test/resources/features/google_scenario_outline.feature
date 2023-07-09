Feature: Scenario outline practice

  @capital
  Scenario Outline: Search for the capital city
    Given user is on Google search page
    When users search for the "<country>"
    Then user should see the "<capital>" in the result

    Examples:
      | country     | capital          |
      | USA         | Washington, D.C. |
      | Azerbaijan  | Baku             |
      | Ukraine     | Kyiv             |
      | Afghanistan | Kabul            |
      | Turkey      | Ankara           |