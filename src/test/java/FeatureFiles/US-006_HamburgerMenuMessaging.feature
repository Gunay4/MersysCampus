Feature: HamburgerMenuMessaging

  Background:
    Given Navigate to website
    When User send keys in Dialog
      | loginUsername | Student_2 |
      | loginPassword | S12345    |
    When Click on the Element in Dialog
      | loginButton |
    Then User should login successfully

  Scenario: Deleting a messages
    When Click on the Element in Dialog via Java Script
      | hamburgerMenuButton |
      | messagingButton     |
      | outbox              |
    And Verify That the Trash Icon is Visible
    When Click on the Element in Dialog
      | trashIcon        |
      | confirmYesButton |
    Then Verify that the Trash Success Message
