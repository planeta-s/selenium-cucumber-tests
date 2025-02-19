Feature: Add a new address
  As a logged in user,
  I want to add address to the account,
  so that I can select this address for delivery of the purchased product

  Scenario Outline: Add and check a new address
    Given the user is logged in as a registered user
    When the user clicks on the Addresses button
    And the user fills the address form with "<alias>", "<address>", "<city>", "<zip/postal code>","<phone>"
    And the user clicks Save button
    Then a new address should be added

    Examples:
      | alias | address        | city      | zip/postal code|  phone    |
      | Home  | Buhar Zhyrau 8 | Almaty    | 100401         | 123456789 |