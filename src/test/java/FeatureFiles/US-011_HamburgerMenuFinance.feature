Feature: Hamburger Menu / Finance US_11

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
    And Click on the Element in Dialog
      | stripeCircle |
    And Click on the Element in Dialog
      | payInFullIndicator |
    And Click on the Element in Dialog
      | payIndicator |
    And User send keys in Dialog
      | amountField | 235 |
    And Click on the Element in Dialog Twice
      | payButton |
    Then Wait for the Card Number iframe to load
    And User send card number in Dialog
      | numberInputField | 4242 4242 4242 4242 |
    And User send expiry date in Dialog
      | expiryInputField | 1226 |
    And User send random cvc code in Dialog
      | cvcInputField |
    And User enters country in Dialog
      | countrySelect | Türkiye |
    And Click on the Element in Dialog and verifies the Student Payment Successfully created
      | stripePaymentsButton |
    And Click on the Element in Dialog
      | feeBalanceDetail |
    And Verify the last payment of "235" is displayed in the table





