Feature: Passing multiple parameters to the same step

  @google
  Scenario: Searching multiple items
    Given user is on Google search page
    Then user search the following items
      | items        |
      | loop academy |
      | java         |
      | selenium     |
      | cucumber bdd |
      | sql          |
    Then user is on Google search page
#    option + command + L
#    CTRL + ALT + L