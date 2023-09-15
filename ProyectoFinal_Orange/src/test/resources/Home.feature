Feature: Home Page

  Background: Home page should display the Dashboard part
    Given I am in orange demo web page
    Given I set the user name field with "Admin"
    And I set the password field with "admin123"
    And I click on the login button

    @VerifyDashboardSection
    Scenario: Verify the dashboard part is the displayed in the home page
      Given The home page should be displayed
      Then The dashboard item "Time at Work" should be displayed
      And I logout from the page