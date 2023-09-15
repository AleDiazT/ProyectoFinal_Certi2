Feature: Login Orange Demo App

  Background: User login into Orange Demo
    Given I am in orange demo web page

    @loginWithValidCredentials
    Scenario: Login into Orange page with valid credentials
      Given I set the user name field with "Admin"
      And I set the password field with "admin123"
      When I click on the login button
      Then The home page should be displayed

    @loginWithInvalidCredentials
    Scenario: Login into Orange page with invalid credentials
      Given I set the user name field with "wrong_user"
      And I set the password field with "wrong_password"
      When I click on the login button
      Then An error message that says "Invalid credentials" should be displayed