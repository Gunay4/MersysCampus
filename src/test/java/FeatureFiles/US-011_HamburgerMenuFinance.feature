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
    When User clicks on the "stripeCircle" payment option
    And User clicks on the "payInFullIndicator" in the Fee page
    And User clicks on the "payIndicator" in the Fee page
    Then User clicks on the "amountInputField" in the Fee page
    And User enters the amount "235"
    When I click on the "payButton" once
    Then User clicks on the "payButton" again
    Then User should see the "cardNumberLabel" label on the Fee page
    Then User enters the "cardNumberInput" and sends "4242 4242 4242 4242" card number in the Fee page
    Then User enters the "expiryInputField" and sends "12/26" as expiry date in the Fee page
    Then User enters the "cvcInputField" and sends a random CVV number in the Fee page
    And User selects Türkiye from the country dropdown on the Fee page













