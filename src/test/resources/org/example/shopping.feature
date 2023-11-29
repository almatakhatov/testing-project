Feature: Shopping

  Background:
    Given the home page is opened
    And the 'LoginLink' is clicked
    And user redirected to 'https://demowebshop.tricentis.com/login'
    And the 'email' is filled with 'i.drive@gmail.com'
    And the 'password' is filled with 'nightcall'
    When the 'LoginButton' is clicked
    Then user redirected to 'https://demowebshop.tricentis.com/'

  Scenario: Adding a stuff to cart
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

