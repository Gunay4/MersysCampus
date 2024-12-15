Feature: Sending Message via Messaging from the Hamburger Menu

  Background:
    Given Navigate to website
    When User send keys in Dialog
      | loginUsername | Student_2 |
      | loginPassword | S12345    |
    When Click on the Element in Dialog
      | loginButton |
    Then User should login successfully

  Scenario Outline: Sending Messages
    When Click on the Element in Dialog
      | hamburgerMenuButton |
      | messagingButton     |
      | sendMessage         |
      | addReceivers        |
    Then User send keys in Dialog
      | username | stud |
    And Click on the Element in Dialog
      | checkBox1 |
      | checkBox2 |
      | addButton |
    And User Should Successfully Added
    And Clean The Placeholder
    And User send keys in Dialog
      | username | teac |
    And Click on the Element in Dialog
      | checkBox3         |
      | addButton         |
      | addAndCloseButton |
    And User Should Successfully Added
    And User send keys in Dialog
      | subject | <title> |
    And Switch to Rich Text Area
    And User send keys in Dialog
      | richTextArea | How Can I create A new Branch From My Repo? |
    And Switch Back to Parent Frame
    And Click on the Element in Dialog
      | attachFiles |
      | fromLocal1  |
    And Navigate and Click the file and Open Button
    And Click on the Element in Dialog via Java Script
      | sendButton |
    And Verify that the Success Message
    When Click on the Element in Dialog via Java Script
      | hamburgerMenuButton |
      | messagingButton     |
      | outbox              |
    And Verify that the Outbox Message is Visible
      | <title> |
    Examples:
      | title         |
      | git branching |