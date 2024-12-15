Feature: Home

  Background:
    Given Navigate to website
    When User send keys in Dialog
      | loginUsername | Student_2 |
      | loginPassword | S12345    |
    When Click on the Element in Dialog
      | loginButton |
    Then User should login successfully

  Scenario: Verify main menu visibility and functionally

    Given The user clicks on the calendar menu item
      | calendar |
    Then The calendar page should be displayed

    When The user clicks on the Attendance menu item
      | attendance |
    Then The Attendance page should be displayed

    When The user clicks on the Assignments menu item
      | assigments |
    Then The Assignments page should be displayed

    When The user clicks on the Grading menu item
      | grading |
    Then The Grading page should be displayed

    When The user clicks on the Hamburger Menu menu item
      | burgerMenu |
    Then The Hamburger menu should open

    When Click on the Element in Dialog via Java Script
      | messages |
    Then The Messages section should open

    When The user clicks on the Profile menu item
      | profile |
    Then The Profile section should open