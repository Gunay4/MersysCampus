package StepDefination;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class US_23_Calendar {

    DialogContent dc = new DialogContent();
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(8));

    @Given("Navigate to Calendar")
    public void navigateToCalendar(DataTable dataTable) {
        List<String> linkbutton=dataTable.asList(String.class);
        for (int i = 0; i < linkbutton.size(); i++) {
            dc.myClick(dc.getWebElement(linkbutton.get(i)));
        }

    }

    @And("The student must be able to see and click on the weekly lesson plan link and the link to access the calendar pages.")
    public void theStudentMustBeAbleToSeeAndClickOnTheWeeklyLessonPlanLinkAndTheLinkToAccessTheCalendarPages() {
        /*List<String > buttons=dataTable.asList(String.class);
        for (int i = 0; i < buttons.size(); i++) {
          //  wait.until(ExpectedConditions.visibilityOf(dc.getWebElement(buttons.get(i))));
            dc.myClick(dc.getWebElement(buttons.get(i)));
        }*/

       /* wait.until(ExpectedConditions.visibilityOf(dc.calenderMenu));
        dc.myClick(dc.calenderMenu);
        wait.until(ExpectedConditions.elementToBeClickable(dc.weeklyCoursePlan));
        dc.weeklyCoursePlan.click();*/
    }

    @And("The student should be able to see what the symbols P, S, E, C mean on the page.")
    public void theStudentShouldBeAbleToSeeWhatTheSymbolsPSECMeanOnThePage() {
    }

    @And("On the weekly course plan page, the student should be able to click on the icons to go back and forth in the calendar and directly to today.")
    public void onTheWeeklyCoursePlanPageTheStudentShouldBeAbleToClickOnTheIconsToGoBackAndForthInTheCalendarAndDirectlyToToday() {
    }

    @And("The courses that the student is responsible for should be visible and clickable.")
    public void theCoursesThatTheStudentIsResponsibleForShouldBeVisibleAndClickable() {
    }
}
