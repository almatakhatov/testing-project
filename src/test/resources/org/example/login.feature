Feature: Login

  Background:
    Given the home page is opened

  Scenario Outline: Incorrect logging in
    Given the 'LoginLink' is clicked
    And user redirected to 'https://demowebshop.tricentis.com/login'
    And the 'email' is filled with '<email>'
    And the 'password' is filled with '<password>'
    When the 'LoginButton' is clicked
    Then the '<errorMessage1>' and '<errorMessage2>' are shown
    Examples:
      | email             | password  | errorMessage1                                                    | errorMessage2                          |
      |                   |           | Login was unsuccessful. Please correct the errors and try again. | No customer account found              |
      | i.drive@gmail.com | nightcal1 | Login was unsuccessful. Please correct the errors and try again. | The credentials provided are incorrect |
      | i.drive@gmail.com |           | Login was unsuccessful. Please correct the errors and try again. | The credentials provided are incorrect |
      |                   | nightcall | Login was unsuccessful. Please correct the errors and try again. | No customer account found              |


  Scenario: Correct logging in
    Given the 'LoginLink' is clicked
    And user redirected to 'https://demowebshop.tricentis.com/login'
    And the 'email' is filled with 'i.drive@gmail.com'
    And the 'password' is filled with 'nightcall'
    When the 'LoginButton' is clicked
    Then user redirected to 'https://demowebshop.tricentis.com/'
    And the 'Logout' is clicked

  Scenario: Logging out
    Given the 'LoginLink' is clicked
    And user redirected to 'https://demowebshop.tricentis.com/login'
    And the 'email' is filled with 'i.drive@gmail.com'
    And the 'password' is filled with 'nightcall'
    And the 'LoginButton' is clicked
    And user redirected to 'https://demowebshop.tricentis.com/'
    When the 'Logout' is clicked
    Then the 'Log in' is visible


