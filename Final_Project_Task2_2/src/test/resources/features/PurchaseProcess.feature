Feature: The purchase process

  Scenario Outline: Purchase of good on the website
    Given the user is logged in as an existing user
    And the user chooses Hummingbird Printed Sweater
    And the user checks if the discount is 20%
    When the user chooses size "<size>"
    And the user chooses quantity <quantity>
    And the user add the product to the cart
    And the user proceeds to checkout
    And the user confirms the shipping address
    And the user chooses Pick up in store shipping method
    And the user selects Pay by Check payment option
    And the user places the order
    Then screenshot should be taken with the order confirmation and the payment amount

    Examples:
      | size | quantity |
      | M    | 5        |
