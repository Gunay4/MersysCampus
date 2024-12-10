package StepDefination;


import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class US_16_Grading {
    DialogContent dc = new DialogContent();
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(8));


    @Then("User Should Be Redirected To The Grading Page")
    public void userShouldBeRedirectedToTheGradingPage() {
        wait.until(ExpectedConditions.visibilityOf(dc.gradingMenu));
        Assert.assertTrue(dc.gradingMenu.isDisplayed(), "User is not redirected to the Grading Menu page.");
    }


    @Then("Verify That The Student Transcript Working Properly")
    public void verifyThatTheStudentTranscriptWorkingProperly() {
        wait.until(ExpectedConditions.visibilityOf(dc.studentTranscript));
        Assert.assertTrue(dc.studentTranscript.isDisplayed(), "User is not redirected to the Student Transcript page.");
    }

    @Then("Verify That The Transcript By Subject Working Properly")
    public void verifyThatTheTranscriptBySubjectWorkingProperly() {
        wait.until(ExpectedConditions.visibilityOf(dc.transcriptBySubject));
        Assert.assertTrue(dc.transcriptBySubject.isDisplayed(), "User is not redirected to the Transcript By Subject page.");
    }

    @Then("Verify that The Course Grade Working Properly")
    public void verifyThatTheCourseGradeWorkingProperly() {
        wait.until(ExpectedConditions.visibilityOf(dc.courseGrade));
        Assert.assertTrue(dc.courseGrade.isDisplayed(), "User is not redirected to the Course Grade page.");
    }
}
