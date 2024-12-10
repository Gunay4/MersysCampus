Feature: Grading Menu Functionality

  Background:
    Given Navigate to website
    When User send keys in Dialog
      | loginUsername | Student_2 |
      | loginPassword | S12345    |
    When Click on the Element in Dialog
      | loginButton |
    Then User should login successfully

  Scenario: Grading Menu Detail
    When Click on the Element in Dialog
      | gradingMenu |
    Then User Should Be Redirected To The Grading Page
    When Click on the Element in Dialog
      | studentTranscript   |
      | transcriptBySubject |
      | courseGrade         |
    Then Verify That The Student Transcript Working Properly
    Then Verify That The Transcript By Subject Working Properly
    Then Verify that The Course Grade Working Properly