@data_tables
Feature: data_table

  Scenario Outline: TC_Create_And_Verify_Testdata_Creation
    Given user is on "https://editor.datatables.net/"
    When user clicks on New button
    And user enters the first name in "<firstname>" input
    And user enters the last name in "<lastname>" input
    And user enters the position in "<position>" input
    And user enters the office in "<office>" input
    And user enters the extension in "<extension>" input
    And user enters the start date in "<start_date>" input
    And user enters the salary in "<salary>" input
    And user clicks on create button
    And user search for the first name "<firstname>"
    Then verify the name field contains the "<firstname>"
    Then close the application

    Examples: data_for_test
      | firstname | lastname | position    | office | extension | start_date | salary |
      | John      | Doe      | QA          | Dubai  | 12345     | 2023-01-25 | 5000   |
      | Sam       | Walton   | Tester      | London | 23455     | 2023-01-28 | 8000   |
      | Nancy     | Brown    | Businessman | Lahore | 44563     | 2023-01-21 | 50000  |
      | George    | Bush     | Developer   | HK     | 12678     | 2023-01-29 | 15000  |


# These are external files just like excel