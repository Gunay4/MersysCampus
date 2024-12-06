Feature: Fonksiyon

  Background:
    Given Navigate to website
    When User send keys in Dialog
      | loginUsername | Student_2 |
      | loginPassword | S12345    |
    When Click on the Element in Dialog
      | loginButton |
    Then User should login successfully

  Scenario: Assignment
    Given Navigate to the assignment select filter and search
    And from the drop-down sort menu select and verify show by course, type, date and chart
