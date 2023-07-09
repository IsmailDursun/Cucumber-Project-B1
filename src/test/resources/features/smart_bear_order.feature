Feature: practice smart bear

  @smartbear
  Scenario: user should be bale to place order and order should be seen in page
    Given user is already logged in and navigated to order page
    When user selects product type "FamilyAlbum"
    And user enters quantity "2"
    And user enters customer name "Chuck Norris"
    And user enters street "1100 Long way dr"
    And user enters city "Chantilly"
    And user enters state "Virginia"
    And user enters zip "22011"
    And user selects credit card type "American Express"
    And user enters credit car number "1111222233334444"
    And user enters expiration date "12/25"
    And user enters process order button
    Then user should see "Chuck Norris" in the first row of the table

  @smartbear
  Scenario Outline: User should be able to place an order and order should be seen in page
    Given user is already logged in and navigated to order page
    When user selects product type "<productType>"
    And user enters quantity "<quantity>"
    And user enters customer name "<customerName>"
    And user enters street "<street>"
    And user enters city "<city>"
    And user enters state "<state>"
    And user enters zip "<zip>"
    And user selects credit card type "<cardType>"
    And user enters credit car number "<cardNumber>"
    And user enters expiration date "<exp>"
    And user enters process order button
    Then user should see "<customerName>" in the first row of the table
    Examples:
      | productType | quantity | customerName       | street           | city      | state    | zip   | cardType         | cardNumber       | exp   |
      | ScreenSaver | 5        | Nadir Shafiev      | 777 LoopCamp  dr | Fairfax   | Virginia | 76112 | Visa             | 1111222233334444 | 12/25 |
      | FamilyAlbum | 2        | Chuck Norris       | 1100 Long way dr | Chantilly | Virginia | 22011 | American Express | 1111222233334444 | 12/25 |
      | MyMoney     | 4        | Feyruz Shahmuradov | 778 LoopCamp  dr | Fairfax   | Virginia | 76112 | MasterCard       | 1111222233334445 | 12/25 |