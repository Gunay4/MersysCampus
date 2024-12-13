Feature: Grading Menu Functionality

  Background:
    Given Navigate to website
    When User send keys in Dialog
      | loginUsername | Student_2 |
      | loginPassword | S12345    |
    When Click on the Element in Dialog
      | loginButton |
    Then User should login successfully

  Scenario: Grading Page and Save the Grades
    When Click on the Element in Dialog
      | gradingButton    |
      | firstPrintButton |
    When Navigate and Click firstDownload button
    Then Navigate and Click the Save Button
    Then Close to screen to Switch Campus
    When Click on the Element in Dialog
      | studentTransButton |
      | secondPrintButton  |
    When Navigate and Click secondDownload button
    And Navigate and Click the Save Button Again
    Then Close to screen to Switch Campus
