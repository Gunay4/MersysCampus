Feature: All Assignments Functionality

  Background:
    Given Navigate to website
    When User send keys in Dialog
      | loginUsername | Student_2 |
      | loginPassword | S12345    |
    When Click on the Element in Dialog
      | loginButton |
    Then User should login successfully

  Scenario: Student assignment submission process control
    Given Navigate to the assignment select filter and search
    Then Checking the transactions on the homework page
