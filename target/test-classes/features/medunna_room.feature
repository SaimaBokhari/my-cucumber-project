@MedunnaRoom
Feature: medunna_room_creation

  Background: Sign In Medunna
    Given user is on "https://medunna.com/" page
    When click on user icon
    And click on Sign In option
    And enter "john_doe" in Username input
    And enter "John.123" in Password input
    And click on Remember Me checkbox
    Then click on Sign In submit button

  Scenario Outline: Create Room
    And click on Items&Titles
    And click on Room option
    And click on Create a new room button
    And enter "<room_number>" room number input
    And select Suite option from Room Type dropdown
    And click on Status checkbox
    And enter "<price>" in Price input
    And enter "<description>" in Description input
    And click on Save button
    And click on Created Date
    Then assert that room is created via "<room_number>"
    And close the application
    Examples:
      | room_number | price | description |
      | 6691         | 4300  | Seaview     |
      | 4142        | 4000  | Parkview    |
      | 3843         | 2500  | Extra drinks |
      | 9344         | 1400  | BabyCot     |