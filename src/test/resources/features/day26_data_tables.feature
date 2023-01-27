@data_tables_1, @smoke_tests
Feature: data_tables

  Scenario: customer_login
    Given user is on "https://www.bluerentalcars.com/login" page
    When user enters customer email and customer password
      | username       | password |
      | jack@gmail.com | 12345    |
    Then verify application login is successful
     And close the application

