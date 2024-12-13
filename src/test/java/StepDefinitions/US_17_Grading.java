package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.awt.*;
import java.awt.event.KeyEvent;

public class US_17_Grading {
    Robot robot;

    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    @When("Navigate and Click firstDownload button")
    public void navigateAndClickFirstDownloadButton()
            throws InterruptedException {
        for (int i = 0; i <= 14; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(100);
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    @And("Navigate and Click the Save Button")
    public void navigateAndClickTheSaveButton() {
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    @Then("Close to screen to Switch Campus")
    public void closeToScreenToSwitchCampus() {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_CONTROL);

    }

    @When("Navigate and Click secondDownload button")
    public void navigateAndClickSecondDownloadButton()
            throws InterruptedException {
            for (int i = 0; i <= 14; i++) {
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);
                Thread.sleep(100);
            }
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }

    @And("Navigate and Click the Save Button Again")
    public void navigateAndClickTheSaveButtonAgain() {
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}