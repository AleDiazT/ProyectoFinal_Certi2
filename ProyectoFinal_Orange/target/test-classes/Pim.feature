Feature: Pim Page
  Background: Home page should display the Dashboard part
    Given I am in orange demo web page
    Given I set the user name field with "Admin"
    And I set the password field with "admin123"
    And I click on the login button

  @AddEmployeeVerification
  Scenario: Verify the addition of a employee in the PIM page
    When I click on the "PIM" button
    And I click on the Add Employee button
    And fill the information with the following data
      | Maria | Jose | Vargas |
    When I click on the save button
    When I click on the Emplooyee list
    And Search the name "Maria Jose Vargas"
    Then the employee should be listed
    And I logout from the page

  @DeleteEmployeeVerification
  Scenario: Verify the deletion of a employee in the PIM page
    Given I click on the "PIM" button
    And Search the name "Maria Jose Vargas"
    When click the delete button
    And Search the name again
    Then the search should return "No Records Found"
    And I logout from the page

  @VerifyPlantEmployee
  Scenario Outline: Verify the deletion of a employee in the PIM page
    Given I click on the "PIM" button
    And Select the subunit "<subunit>"
    When Search the name "<employee>"
    Then the search should found the employee "<employee>"
    And I logout from the page
    Examples:
      | subunit           | employee        |
      | Administration    | John Smith      |
      | Engineering       | Maggie Manning  |
      | Development       | Russel Hamilton |
      | Quality Assurance | Rebecca Harmony |