Feature: Finance Functionality
  Background:
    Given Navigate to website
    When User send keys in Dialog
      | loginUsername | Student_2 |
      | loginPassword | S12345    |
    When Click on the Element in Dialog
      | loginButton   |
    Then User should login successfully

  Scenario: Finance Page
    And Click on the Element in Dialog
      |hamburgerMenuButton|
      |financeButton      |
      |myFinanceButton    |
    Then Page should be Finance