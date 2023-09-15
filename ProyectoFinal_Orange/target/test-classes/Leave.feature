Feature: Leave Page
  Background: Home page should display the Dashboard part
    Given I am in orange demo web page
    Given I set the user name field with "Admin"
    And I set the password field with "admin123"
    And I click on the login button

  @ApplyVerification
  Scenario: Verify the Leave appliance
    When I click on the leave button
    And I click on the apply button
    And click the Leave Type with the option "CAN - Personal"

  @AssignVerification
  Scenario: Verify the Leave appliance
    When I click on the leave button
    And I click on the assign button
    Given I set the name with "Alejandro Diaz"

    And click the Leave Type with the option "CAN - Personal"