package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public class US_23_Calendar {

    DialogContent dc = new DialogContent();
    LocalDate date = LocalDate.now();
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(8));

    @Given("Navigate to Calendar")
    public void navigateToCalendar(DataTable dataTable) {
        List<String> linkbutton = dataTable.asList(String.class);
        for (int i = 0; i < linkbutton.size(); i++) {
            dc.myClick(dc.getWebElement(linkbutton.get(i)));
        }

    }


    @Then("The student must be able to see and click on the weekly lesson plan link and the link to access the calendar pages.")
    public void theStudentMustBeAbleToSeeAndClickOnTheWeeklyLessonPlanLinkAndTheLinkToAccessTheCalendarPages() {

        wait.until(ExpectedConditions.visibilityOf(dc.calendarMenu));
        dc.myClick(dc.calendarMenu);

        wait.until(ExpectedConditions.visibilityOf(dc.todayBtn));
        dc.leftArrowCalendar.click();
        dc.leftArrowCalendar.click();
        dc.rightArrowCalendar.click();
        dc.todayBtn.click();
    }

    @Then("The student should be able to see what the symbols P, S, E, C mean on the page.")
    public void theStudentShouldBeAbleToSeeWhatTheSymbolsPSECMeanOnThePage() {
        wait.until(ExpectedConditions.elementToBeClickable(dc.weeklyCoursePlan));
        dc.weeklyCoursePlan.click();
        wait.until(ExpectedConditions.visibilityOf(dc.published));

        Assert.assertTrue(dc.letterP.isDisplayed());
        Assert.assertTrue(dc.letterS.isDisplayed());
        Assert.assertTrue(dc.letterE.isDisplayed());
        Assert.assertTrue(dc.letterC.isDisplayed());

        Assert.assertEquals(dc.published.getText().toLowerCase(), "published");
        Assert.assertEquals(dc.started.getText().toLowerCase(), "started");
        Assert.assertEquals(dc.ended.getText().toLowerCase(), "ended");
        Assert.assertEquals(dc.cancelled.getText().toLowerCase(), "cancelled");
    }

    @Then("On the weekly course plan page, the student should be able to click on the icons to go back and forth in the calendar and directly to today.")
    public void onTheWeeklyCoursePlanPageTheStudentShouldBeAbleToClickOnTheIconsToGoBackAndForthInTheCalendarAndDirectlyToToday() {

        dc.myClick(dc.rightArrowIcon);
        dc.myClick(dc.rightArrowIcon);
        dc.myClick(dc.leftArrowIcon);
        dc.myClick(dc.todayIcon);
    }

    @And("The courses that the student is responsible for should be visible and clickable.")
    public void theCoursesThatTheStudentIsResponsibleForShouldBeVisibleAndClickable() {
        wait.until(ExpectedConditions.visibilityOf(dc.letterE));

        dc.todayIcon.click();
        wait.until(ExpectedConditions.visibilityOf(dc.dateText));
        int dateDayOfMonth = date.getDayOfMonth();
        String dayOfMonth = String.valueOf(dateDayOfMonth);
        Assert.assertTrue(dc.dateText.getText().contains(dayOfMonth));

        wait.until(ExpectedConditions.elementToBeClickable(dc.todayIcon));
        dc.myClick(dc.statistics);
        wait.until(ExpectedConditions.visibilityOf(dc.courseNotStartedMessage));
        Assert.assertTrue(dc.courseNotStartedMessage.getText().contains("Course Meeting has not been started yet"));


    }
}
