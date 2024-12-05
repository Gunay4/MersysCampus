Feature: Login

  Scenario: Valid Login
    Given Navigate to website
    When User send keys in Dialog
      | loginUsername | Student_2 |
      | loginPassword | S12345    |
    When Click on the Element in Dialog
      | loginButton |
    Then User should login successfully

  Scenario: Invalid Login
    Given Navigate to website
    When User send keys in Dialog
      | loginUsername | InvalidUserName |
      | loginPassword | InvalidPassword    |
    When Click on the Element in Dialog
      | loginButton |
    Then User should not be able to login