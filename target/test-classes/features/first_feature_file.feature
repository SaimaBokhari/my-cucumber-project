@google_search
Feature: first feature file

  Background: user_goes_to_google_page
    Given user is on the google home page

  @iphone_search
  Scenario: TC_01_iphone_search
    When user search for iPhone
    Then verify page title contains iPhone
    Then close the application


    @teapot_search
  Scenario: TC_02_teapot_search
  When user search for Teapot
  Then verify page title contains Teapot
  Then close the application






# NOTES:
# All feature files must begin with "Feature" keyword
# Feature: To declare the file as a cucumber feature file. MANDATORY. There can only be ONE Feature keyword.
# Scenario: To create test case. In a feature file, there may be more than one scenarios.
# Runner : To run the feature files

# Cucumber runs the tests in the order of Features file
#  Background: user_goes_to_google_page works like before method.. runs before each scenario. This is used for repeated PRE-CONDITIONS.

# Cucumber STEPS:
#  1. create feature file and test scenarios
#  2. run the feature file and generate step definitions. dryRun=true
#  3. use the step definitions to complete the java code
#  4. dryRun=false to execute test cases

# tags
