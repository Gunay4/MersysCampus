Feature: HamburgerMenuMessaging


Given Navigate to website
When User send keys in Dialog
| loginUsername | Student_2 |
| loginPassword | S12345    |
When Click on the Element in Dialog
| loginButton |
Then User should login successfully


  Scenario: Deleting a message

    When Click on the Element in Dialog
    | hamburgerMenuButton |
    | messagingButton |
    | outboxButton |
  And Verify That the Trash Icon is Visible
    | checkBox4 |
    | trashButton |
    | confirmButton |
    Then Success message should be displayed
