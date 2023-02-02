@db_read
Feature: db_customer_testing

  @db_read_login
  Scenario: TC01_read_customer_login_info
    Given user connects to the application database
# SELECT * FROM jhi_user
    When user gets the column "*" from table "jhi_user"
# Read all of the login names of the customers
    Then user reads all column "login" data


  @db_read_firstname
  Scenario: TC02_read_customer_firstname_info
    Given user connects to the application database
# SELECT * FROM jhi_user
    When user gets the column "*" from table "jhi_user"
# Read all of the first names of the customers
    Then user reads all column "first_name" data

  @db_read_email
  Scenario: TC03_read_customer_email_info
    Given user connects to the application database
# SELECT email FROM tp_customer
    When user gets the column "*" from table "tp_customer"
# Read all of the first names of the customers
    Then user reads all column "email" data