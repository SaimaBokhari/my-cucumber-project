@scenario_outline
Feature: search_feature

  Background: user_goes_to_google_page
    Given user is on the google home page

  Scenario Outline: search_scenario
    When user search for "<search_item>" on google
    Then verify page title contains "<search_item>"
    Then close the application
    Examples: Test Data
      | search_item |
      | tesla       |
      | nio         |
      | mercedes    |
      | bmw         |
      | lexus       |
      | toros       |
      | acura       |




# scenario_outline is used to run same scenario with multiple data as it is parameterised
# it must be followed by an Examples keyword. It is used to pass data
# scenario_outline is used for parameterizing of the feature file
# to make steps reusable
# it is used to pass test data dynamically
# it can have more than one columns
# name in front of Examples is optional

  # Cucumber reports plugins
  # add in runner class
  # easily generate reports
  # different types of reports suach as HTML, json, xml, but the most common one is the HTML report

  # Most important parts in Cucumber are FEATURE FILES and HOOKS