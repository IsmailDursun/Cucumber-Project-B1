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

#    option + command + L
#    CTRL + ALT + L