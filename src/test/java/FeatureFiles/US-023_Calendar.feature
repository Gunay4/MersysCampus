Feature:Calendar Functionality

  Background:
    Given Navigate to website
    When User send keys in Dialog
      | loginUsername | Student_2 |
      | loginPassword | S12345    |
    When Click on the Element in Dialog
      | loginButton |
    Then User should login successfully

  Scenario: Calendar Features

    Given Navigate to Calendar
      | calendarHeader |

    Then The student must be able to see and click on the weekly lesson plan link and the link to access the calendar pages.
    Then The student should be able to see what the symbols P, S, E, C mean on the page.
    Then On the weekly course plan page, the student should be able to click on the icons to go back and forth in the calendar and directly to today.
    And The courses that the student is responsible for should be visible and clickable.
