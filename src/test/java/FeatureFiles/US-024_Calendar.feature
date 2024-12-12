Feature: Calendar Functionality

  Background:
    Given Navigate to website
    When User send keys in Dialog
      | loginUsername | Student_2 |
      | loginPassword | S12345    |
    When Click on the Element in Dialog
      | loginButton |
    Then User should login successfully

    Scenario: Weekly Course Plan Page

      Given Navigate to Calendar
        | calendarHeader |

      When Click on a lesson on the Weekly Course Plan page and verify the lesson name

      And Click on a course that is in the weekly course schedule but has not yet been published.
      Then Confirm the course and teacher name, course date and time

      When A student clicks on a course that has been published(P), started(S), or finished(E)
      Then Verify that the Information, Subject, Attachments and Recent Events links in the window that opens are working properly.