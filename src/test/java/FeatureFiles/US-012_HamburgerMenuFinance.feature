Feature: Hamburger Menu / Finance

  Background:
    Given Navigate to website
    When User send keys in Dialog
      | loginUsername | Student_2 |
      | loginPassword | S12345    |
    When Click on the Element in Dialog
      | loginButton |
    Then User should login successfully

  Scenario: Download payment details as Excel or PDF

  Scenario: Fee Balance Detail
    When Click on the Element in Dialog
      | hamburgerMenuButton |
      | financeButton       |
      | myFinanceButton     |
    Then User should be redirected to the Finance page
    And User clicks on the "threeDotButton" on the Finance page
    And User selects the "excelButton" option from the dropdown
    Then The "Excel" file should be downloaded successfully

    When Click on the Element in Dialog
      | hamburgerMenuButton |
      | financeButton       |
      | myFinanceButton     |
    Then User should be redirected to the Finance page

    And User clicks on the "threeDotButton" on the Finance page
    And User selects the "pdfButton" option from the dropdown
    Then The "PDF" file should be downloaded successfully
