Feature: Hamburger Menu / Finance

  Background:
    Given Navigate to website
    When User send keys in Dialog
      | loginUsername | Student_2 |
      | loginPassword | S12345    |
    When Click on the Element in Dialog
      | loginButton |
    Then User should login successfully

  Scenario: Fee Balance Detail
    When Click on the Element in Dialog
      | hamburgerMenuButton |
      | financeButton       |
      | myFinanceButton     |
    Then User should be redirected to the Finance page
    When Click on the Element in Dialog
      | studentRow |
    Then User should be redirected to the Student's Fee page
    When Click on the Element in Dialog
      | feeBalanceDetail |
    Then Verify that fee balance detail page is visible

