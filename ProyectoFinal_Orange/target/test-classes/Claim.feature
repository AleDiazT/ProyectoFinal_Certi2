Feature: Leave Page
  Background: Home page should display the Dashboard part
    Given I am in orange demo web page
    Given I set the user name field with "Admin"
    And I set the password field with "admin123"
    And I click on the login button

  @SubmitClaim
  Scenario: Verify the customer addition
    Given I click on the "Claim" button
    And I click on the submit claim button
    And select event "Medical Reimbursement"
    And select currency "Argentina Pesos"
    And Put the remarks "Accident on Palermo"
    And click the create button
    And I click on the add expenses
    And select "Accommodation" in the expense type
    Given and the date of "11" of the current month
    And the ammount of "150300"
    And click on the save button
    And click on submit
    When I click on My claims
    Then the claim with the description "Accident on Palermo" should be displayed
    And I logout from the page