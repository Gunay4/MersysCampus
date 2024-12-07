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
    When User clicks on the "hamburgerMenuButton" from the header
    And User clicks on the "financeButton" from the drop-down menu
    And User clicks on the "myFinanceButton" from the sub-menu
    Then User should be redirected to the Finance page
    When User clicks on the "studentRow" in the Finance table
    Then User should be redirected to the Student's Fee page
    Then User clicks on the "feeBalanceDetail"
