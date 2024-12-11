Feature: TrashBox Functionality
  Background:
    Given Navigate to website
    When User send keys in Dialog
      | loginUsername | Student_2 |
      | loginPassword | S12345    |
    When Click on the Element in Dialog
      | loginButton   |
    Then User should login successfully

  Scenario: TrashBox Clean and Restore Messages

    And Click on the Element in Dialog
      |hamburgerMenuButton|
      |messagingButton    |
      |trashButton        |
    Then Elements icon to be displayed
    And Click on the Element in Dialog
      |restoreButton      |
    Then Success message should be displayed
    And Click on the Element in Dialog
      |deleteButton       |
      |confirmDeleteButton|
    Then Success message should be displayed

