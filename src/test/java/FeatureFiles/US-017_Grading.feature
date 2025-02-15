Feature: Grading Menu Functionality

  Background:
    Given Navigate to website
    When User send keys in Dialog
      | loginUsername | Student_2 |
      | loginPassword | S12345    |
    When Click on the Element in Dialog
      | loginButton |
    Then User should login successfully

  Scenario: Print and download grades
    When Click on the Element in Dialog
      | gradingButton  |
      | downloadButton |
    When The user views a Download icon and clicks on it
    Then The user views PDF Document page and clicks on the Save button
