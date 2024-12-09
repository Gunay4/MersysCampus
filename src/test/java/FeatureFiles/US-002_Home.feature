Feature:Home Page
  Background:
    Given Navigate to website
    When User send keys in Dialog
      | loginUsername | Student_2 |
      | loginPassword | S12345    |
    When Click on the Element in Dialog
      | loginButton |
    Then User should login successfully

    Scenario: Main Page Logo Interaction
      And Click on the element in Dialog
      |homeMLogo|
      Then Verify that home page logo is visible