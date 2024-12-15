Feature: Hamburger Menu / Messaging US_04
  Background:
    Given Navigate to website
    When User send keys in Dialog
      | loginUsername | Student_2 |
      | loginPassword | S12345    |
    When Click on the Element in Dialog
      | loginButton   |
    Then User should login successfully
  Scenario: Messaging Detail
    When Click on the Element in Dialog
      | hamburgerMenuButton |
    Then Hover over the Element in Messaging
    Then The following links should be visible and clickable:
      | sendMessage |
      | Inbox       |
      | outbox      |
      | Trash       |






