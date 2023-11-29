Feature: Filling the forms

  Background:
    Given the home page is opened
    And the 'LoginLink' is clicked
    And user redirected to 'https://demowebshop.tricentis.com/login'
    And the 'email' is filled with 'i.drive@gmail.com'
    And the 'password' is filled with 'nightcall'
    When the 'LoginButton' is clicked
    Then user redirected to 'https://demowebshop.tricentis.com/'

  Scenario: Correct filling of the newspaper form
    When the user fills and submits the form with email 'i.drive@gmail.com'
    Then the 'Logout' is clicked

  Scenario:
    When the user fills and submits the form with wrong email 'drive.com'
    Then the 'Logout' is clicked