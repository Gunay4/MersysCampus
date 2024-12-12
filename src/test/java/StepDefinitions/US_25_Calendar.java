package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;


public class US_25_Calendar {
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));
    DialogContent dc = new DialogContent();
    Robot robot;

    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }


    @Then("Verify that the video is playing")
    public void verifyThatTheVideoIsPlaying() {
        try {
            Thread.sleep(Duration.ofSeconds(3));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertNotEquals(dc.calenderTotalDuration.getText(),
                dc.calenderRemDuration.getText());
    }

    @And("Play the video")
    public void playTheVideo() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(dc.calenderFrame));
        wait.until(ExpectedConditions.visibilityOf(dc.calenderVideoTitle));
        wait.until(ExpectedConditions.elementToBeClickable(dc.calenderFullScreen));
        for (int i = 0; i < 6; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
