Feature: Profile

  Background:
    Given Navigate to website
    When User send keys in Dialog
      | loginUsername | Student_2 |
      | loginPassword | S12345    |
    When Click on the Element in Dialog
      | loginButton |
    Then User should login successfully

  Scenario: Profile Theme Update
    And Click on the Element in Dialog
      | profileDDMenu         |
      | profileSettings       |
      | profileThemeSelection |
      | profilePurple         |
    Then Confirm purple theme selected
    And Click on the Element in Dialog
      | profileThemeSelection |
      | profileDPurple |
    Then Confirm dark purple theme selected
    And Click on the Element in Dialog
      | profileThemeSelection |
      | profileIndigo |
    Then Confirm indigo theme selected
    And Click on the Element in Dialog
      | profileSave |
    Then Confirm Success Message