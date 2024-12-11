Feature: Grading Functionality
  Background:
    Given Navigate to website
    When User send keys in Dialog
      | loginUsername | Student_2 |
      | loginPassword | S12345    |
    When Click on the Element in Dialog
      | loginButton   |
    Then User should login successfully

  Scenario: Grading Page Buttons
    And Click on the Element in Dialog
     |gradingButton       |
     |studentTransButton  |
    Then Verify the button was clicked
    And Click on the Element in Dialog
     |transBySubjectButton|
    Then Verify the button was clicked
    And Click on the Element in Dialog
     |courseGradingButton |
    Then Verify the button was clicked