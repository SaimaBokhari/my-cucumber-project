@reg_ex
Feature: url_feature

  Scenario: TC01_open_URLS
    When  I open "https://bluerentalcars.com" page
    When  i open "https://amazon.com" page
    And close the application