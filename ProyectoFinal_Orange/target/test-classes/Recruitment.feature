Feature: Leave Page
  Background: Home page should display the Dashboard part
    Given I am in orange demo web page
    Given I set the user name field with "Admin"
    And I set the password field with "admin123"
    And I click on the login button

  @AddVacancy
  Scenario: Verify the customer addition
    Given I click on the "Recruitment" button
    And I click on the vacancies button
    And click on add button
    When Put the name vacancy "Reclutment Assesor" and description "New vacancy available"
    And the Job title as "Account Assistant"
    Given I put the manager as "Charlie Carter"
    And "1" number of positions
    And Click on save button
    When I click on the vacancies button
    Then the vacancy "Reclutment Assesor" should be displayed
    And I logout from the page