Feature: Employees endpoint
  Background: Employees endpoints should allow to get, create, update and delete employees

    @getOne
    Scenario: /employee should be returned
      Given I perform a GET to the employee endpoint with id "1"
      Then I verify status code 200 is returned
      And I verify the following in the body response
        | 1 | Tiger Nixon |

    @getOneIdNoneExistent
    Scenario: /employee should be returned
      Given I perform a GET to the employee endpoint with id "77"
      Then I verify status code 404 is returned

    @getAll
      Scenario: /employees should return all the employees
        Given I perform a GET to the employees endpoint
        Then I verify status code 200 is returned
        And I verify that the body does not have size 0

    @post
    Scenario: /create should create an employee
      Given I perform a POST to the create endpoint with the following data
        | Alejandro | 3500 | 26 |
      Then I verify status code 200 is returned
      And I verify that the body does not have size 0
      And I verify the following data in the body response
        | Alejandro | 3500 | 26 |

    @put
      Scenario: /update/{id} should update the employee
        Given I perform a PUT to the employee endpoint with id "10"
          | Alejandro | 8400 | 21 |
        Then I verify status code 200 is returned
        And I verify the following data in the body response
          | Alejandro | 8400 | 21 |

    @putWithBadValues
    Scenario: /update/{id} should update the employee
      Given I perform a PUT to the employee endpoint with id "15"
        | 15 |  | Ad |
      Then I verify status code 400 is returned

    @delete
      Scenario: /delete/{id} should delete an employee
        Given I perform a DELETE to the employee endpoint with id "15"
        Then I verify status code 200 is returned
        And I verify the employee "15" was deleted

    @deleteNoneExistent
    Scenario: /delete/{id} should delete an employee
      Given I perform a DELETE to the employee endpoint with id "75"
      Then I verify status code 404 is returned
