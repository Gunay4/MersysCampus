Feature: Discussion Functionality

  Background:
    Given Navigate to website
    When User send keys in Dialog
      | loginUsername | Student_2 |
      | loginPassword | S12345    |
    When Click on the Element in Dialog
      | loginButton |
    Then User should login successfully


  Scenario: Send Discuss Message

    Given Navigate to the assignment select filter and search
    And The user send discussion and verify all necessary steps