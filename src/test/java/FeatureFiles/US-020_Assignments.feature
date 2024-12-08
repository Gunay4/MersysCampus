Feature: Assignments Functionality

  Background:
    Given Navigate to website
    When User send keys in Dialog
      | loginUsername | Student_2 |
      | loginPassword | S12345    |
    When Click on the Element in Dialog
      | loginButton |
    Then User should login successfully

    Given Navigate to the assignment select filter and search

    Scenario:Assignments Icons Control

      Given Verify Icons on the right side of the homework list


