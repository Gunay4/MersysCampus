Feature: Assignments Functionality

  Background:
    Given Navigate to website
    When User send keys in Dialog
      | loginUsername | Student_2 |
      | loginPassword | S12345    |
    When Click on the Element in Dialog
      | loginButton |
    Then User should login successfully

  Scenario: Verify Assignments Number

    When The user hovers over the assignments item
    Then Total number of assignments task should appear
    And The user should see the tasks when click on the assignments item


