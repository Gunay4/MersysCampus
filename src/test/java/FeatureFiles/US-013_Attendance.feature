Feature:Attendance

  Background:
    Given Navigate to website
    When User send keys in Dialog
      | loginUsername | Student_2 |
      | loginPassword | S12345    |
    When Click on the Element in Dialog
      | loginButton |
    Then User should login successfully

  Scenario: Attendance Excuse Report
    And Click on the Element in Dialog
      | attendanceBtn |
    And Wait for load and click on the Element in Dialog via Java Script
      | attendanceExcBtn |
    And Click on the Element in Dialog
      | attendanceExcAdd |
    And User send excuses in Dialog
      | attendanceExcReason |
    And Click on the Element in Dialog
      | attendanceAttach    |
      | attendanceAttachFMF |
    And User send keys in Dialog
      | attendanceFileSearch | technoStudyAttendanceExcuseTest |
    And Click on the Element in Dialog
      | attendanceFileSearchSend |
    And Check the CheckBox
    And Click on the Element in Dialog
      | attendanceFileConfirm |
    And Click on the Element in Dialog via Java Script
      | attendanceReasonSend |
    Then Verify that excuse message sent