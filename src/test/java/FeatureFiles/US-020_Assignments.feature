Feature: Icons Functionality

  Background:
    Given Navigate to website
    When User send keys in Dialog
      | loginUsername | Student_2 |
      | loginPassword | S12345    |
    When Click on the Element in Dialog
      | loginButton |
    Then User should login successfully

  Scenario: Assignments Icons Control

    Given Navigate to the assignment select filter and search

      Given Verify Icons on the right side of the homework list


