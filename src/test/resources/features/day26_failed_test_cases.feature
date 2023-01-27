@failed_tests, @smoke_tests
Feature: hooks_test
  Scenario: TC_01_Test
    Given user is on "https://www.bluerentalcars.com/login" page
    When user enters customer email and customer password
      | username       | password |
      | jack@gmail.com | 12345    |
    Then verify the next page url contains login keyword






