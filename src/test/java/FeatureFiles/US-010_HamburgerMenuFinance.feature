Feature:Home Page

  Background:
    Given Navigate to website
    When User send keys in Dialog
      | loginUsername | Student_2 |
      | loginPassword | S12345    |
    When Click on the Element in Dialog
      | loginButton |
    Then User should login successfully

  Scenario Outline: Stripe Payment
    And Click on the Element in Dialog
      | calendarDDMenu |
    And Click on the Element in Dialog via Java Script
      | hMFinance   |
      | hMMyFinance |
    And Remember the revenue amount
    And Click on the Element in Dialog
      | hMStudentFinance       |
    And Check the Stripe Box
    And User send keys in Dialog
      | hMCustomAmountField | <amount> |
    And Press Tab to leave input box
    And Click on the Element in Dialog
      | hMPaymentButton |
    And Switch to payment frame
    And User send keys in Dialog
      | hMCardNumber     | 4242424242424242 |
      | hMCardExpiration | 1030             |
      | hMCVCInput       | 100              |
    And User select the element from Dialog
      | hMSelectCountry | 218 |
    And Switch back to payment frame
    And Click on the Element in Dialog
      | hMStripePayButton |
    Then Confirm that payment message appeared
    And Navigate back
    And Compare the revenue amount
      | <amount> |
    And Click on the Element in Dialog via Java Script
    |hMMessageBox|
    Then Verify that message box contains payment message

    Examples:
      | amount |
      | 100    |
