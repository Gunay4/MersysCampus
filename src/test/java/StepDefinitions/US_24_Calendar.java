package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;

public class US_24_Calendar {

    DialogContent dc = new DialogContent();
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(8));

    @When("Click on a lesson on the Weekly Course Plan page and verify the lesson name")
    public void clickOnALessonOnTheWeeklyCoursePlanPageAndVerifyTheLessonName() {
        wait.until(ExpectedConditions.visibilityOf(dc.weeklyCoursePlan));

        wait.until(ExpectedConditions.visibilityOf(dc.letterE));
        wait.until(ExpectedConditions.elementToBeClickable(dc.geoMetry));
        Assert.assertTrue(dc.geoMetry.isDisplayed());
        dc.myClick(dc.geoMetry);
        wait.until(ExpectedConditions.visibilityOf(dc.lessonNames));
        Assert.assertTrue(dc.lessonNames.getAttribute("value").contains("11A- Geometry"));
        dc.myClick(dc.closeWindowBtn);

    }

    @And("Click on a course that is in the weekly course schedule but has not yet been published.")
    public void clickOnACourseThatIsInTheWeeklyCourseScheduleButHasNotYetBeenPublished() {

       dc.myClick(dc.mathLesson);
       wait.until(ExpectedConditions.visibilityOf(dc.courseNotStartedMessage));
       Assert.assertTrue(dc.courseNotStartedMessage.getText().toLowerCase().contains("Meeting has not been started".toLowerCase()));

    }

    @Then("Confirm the course and teacher name, course date and time")
    public void confirmTheCourseAndTeacherNameCourseDateAndTimeAndTheMessageThatTheMeetingHasNotStartedYet() {
        wait.until(ExpectedConditions.visibilityOf(dc.dateCourseMath));
        Assert.assertTrue(dc.dateCourseMath.getText().equalsIgnoreCase("December 11, 2024"));
        Assert.assertTrue(dc.startTime.getText().equalsIgnoreCase("12:00"));
        Assert.assertTrue(dc.endTime.getText().equalsIgnoreCase("12:50"));
        Assert.assertTrue(dc.type.getText().equalsIgnoreCase("Online"));
        dc.myClick(dc.closeWindowBtn);
    }

    @When("A student clicks on a course that has been published\\(P), started\\(S), or finished\\(E)")
    public void aStudentClicksOnACourseThatHasBeenPublishedPStartedSOrFinishedE() {


        wait.until(ExpectedConditions.visibilityOf(dc.iconE));
        Assert.assertTrue(dc.geoMetry.isDisplayed());
        dc.myClick(dc.geoMetry);
    }

    @Then("Verify that the Information, Subject, Attachments and Recent Events links in the window that opens are working properly.")
    public void verifyThatTheInformationSubjectAttachmentsAndRecentEventsLinksInTheWindowThatOpensAreWorkingProperly() {

        wait.until(ExpectedConditions.visibilityOf(dc.lessonNames));
        Assert.assertTrue(dc.lessonNames.getAttribute("value").contains("11A- Geometry"));
        dc.myClick(dc.topicButton);
        Assert.assertTrue(dc.topicButton.isDisplayed());
        dc.myClick(dc.atttachmensBtn);
        Assert.assertTrue(dc.atttachmensBtn.isDisplayed());
        dc.myClick(dc.recentEvents);
        Assert.assertTrue(dc.recentEvents.isDisplayed());
        dc.myClick(dc.closeWindowBtn);

    }
}
