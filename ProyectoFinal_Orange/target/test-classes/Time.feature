Feature: Leave Page
  Background: Home page should display the Dashboard part
    Given I am in orange demo web page
    Given I set the user name field with "Admin"
    And I set the password field with "admin123"
    And I click on the login button

  @AddCustomer
  Scenario: Verify the customer addition
    Given I click on the "Time" button
    And I click on the Customers button
    When I click on the Add customer button
    And Put the name "Lenovo" and description "Laptop main supplier for this semester"
    And I click on save button
    Then the customer "Lenovo" should be displayed
    And I logout from the page