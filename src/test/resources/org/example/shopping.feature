Feature: Shopping

  Background:
    Given the home page is opened
    And the 'LoginLink' is clicked
    And user redirected to 'https://demowebshop.tricentis.com/login'
    And the 'email' is filled with 'i.drive@gmail.com'
    And the 'password' is filled with 'nightcall'
    When the 'LoginButton' is clicked
    Then user redirected to 'https://demowebshop.tricentis.com/'

  Scenario: Adding a Jewelery to cart
    Given the 'JeweleryLink' is clicked
    And user redirected to 'https://demowebshop.tricentis.com/jewelry'
    When the 'Diamond Heart' is added to the cart
    And the 'CartLink' is clicked
    And user redirected to 'https://demowebshop.tricentis.com/cart'
    Then the 'ItemQtyField' is filled with '1'
    And the 'Logout' is clicked

  Scenario: Removing a stuff from cart
    Given the 'CartLink' is clicked
    And the 'Checkbox' is clicked
    When the 'UpdateCartButton' is clicked
    Then the 'Your Shopping Cart is empty!' is shown
    And the 'Logout' is clicked

  Scenario Outline: Buying an item
    Given the '<category>' is clicked
    And user redirected to '<link>'
    And the '<item>' is added to the cart
    And the 'CartLink' is clicked
    And user redirected to 'https://demowebshop.tricentis.com/cart'
    And the sum '<sum>' is shown
    And the 'TermsOfUseCheckbox' is clicked
    And the 'CheckoutButton' is clicked
    And the 'BillAddressContinueButton' is clicked
    And the 'ShipAddressContinueButton' is clicked
    And the 'ShipMethodContinueButton' is clicked
    And the 'PayMethodContinueButton' is clicked
    And the 'PayInfoContinueButton' is clicked
    When the 'ConfirmButton' is clicked
    Then the message 'Your order has been successfully processed!' is shown
    And the 'Logout' is clicked
    Examples:
      | item          | category     | link                                            | sum    |
      | Casual Belt   | ClothLink    | https://demowebshop.tricentis.com/apparel-shoes | 1.00   |
      | Jeans         | ClothLink    | https://demowebshop.tricentis.com/apparel-shoes | 1.00   |
      | Handbag       | ClothLink    | https://demowebshop.tricentis.com/apparel-shoes | 35.00  |
      | Diamond Heart | JeweleryLink | https://demowebshop.tricentis.com/jewelry       | 130.00 |