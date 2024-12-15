Feature:Calender

  Background:
    Given Navigate to website
    When User send keys in Dialog
      | loginUsername | Student_2 |
      | loginPassword | S12345    |
    When Click on the Element in Dialog
      | loginButton |
    Then User should login successfully

  Scenario: Accessing Lecture Recordings
    And Click on the Element in Dialog
      | calendarDDMenu |
    And Click on the Element in Dialog via Java Script
      | calenderVC |
      | calenderVM |
    And Click on the Element in Dialog
      | calenderOpenCal |
    And Click on the Element in Dialog via Java Script
      | calenderThisYear    |
      | calenderStatus      |
      | calenderStatusEnded |
      | calenderSearch      |
    And Wait for page to load
    And Click on the Element in Dialog via Java Script
      | calenderPresentation |
    And Play the video
    Then Verify that the video is playing