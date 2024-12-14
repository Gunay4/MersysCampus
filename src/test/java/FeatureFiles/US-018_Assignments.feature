Feature: Assignments US_18

  Background:
    Given Navigate to website
    When User send keys in Dialog
      | loginUsername | Student_2 |
      | loginPassword | S12345    |
    When Click on the Element in Dialog
      | loginButton |
    Then User should login successfully

  Scenario: Verify assignmentsNumber control

    When Hover over the Element in Assignment
    Then The assignmentsNumber should display the total number and click Assignments
    Then the number of assignments displayed should be verified






