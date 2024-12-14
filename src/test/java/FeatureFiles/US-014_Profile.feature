Feature: Profile

  Background:
    Given Navigate to website
    When User send keys in Dialog
      | loginUsername | Student_2 |
      | loginPassword | S12345    |
    When Click on the Element in Dialog
      | loginButton |
    Then User should login successfully

  Scenario: Profile Picture Update
    And Click on the Element in Dialog
      | profileDDMenu   |
      | profileSettings |
      | profileImage    |
      | profileUpload   |
    And Upload the picture
    And Click on the Element in Dialog
      | profileUploadConfirm |
      | profileSave          |
    Then Confirm Success Message
