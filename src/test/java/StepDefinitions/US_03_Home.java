package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class US_03_Home {
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(10));
    DialogContent dc = new DialogContent();
    Robot robot;

    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    @Given("The user clicks on the calendar menu item")
    public void theUserClicksOnTheCalendarMenuItem(DataTable datatable) {
        List<String> listLinkler = datatable.asList(String.class);
        for (int i = 0; i < listLinkler.size(); i++) {
            dc.myClick(dc.getWebElement(listLinkler.get(i)));
        }
    }

    @Then("The calendar page should be displayed")
    public void theCalendarPageShouldBeDisplayed( ) {
        wait.until(ExpectedConditions.visibilityOf(dc.VerifyLeftHeader));
        Assert.assertEquals(dc.VerifyLeftHeader.getText().toLowerCase(),"Calendar".toLowerCase());

    }

    @When("The user clicks on the Attendance menu item")
    public void theUserClicksOnTheAttendanceMenuItem(DataTable datatable) {
        List<String> listLinkler = datatable.asList(String.class);
        for (int i = 0; i < listLinkler.size(); i++) {
            dc.myClick(dc.getWebElement(listLinkler.get(i)));
        }
    }

    @Then("The Attendance page should be displayed")
    public void theAttendancePageShouldBeDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(dc.attendanceLoad));
        wait.until(ExpectedConditions.visibilityOf(dc.VerifyLeftHeader));
        Assert.assertEquals(dc.VerifyLeftHeader.getText().toLowerCase(),"Attendance".toLowerCase());
    }

    @When("The user clicks on the Assignments menu item")
    public void theUserClicksOnTheAssignmentsMenuItem(DataTable datatable) {
        List<String> listLinkler = datatable.asList(String.class);
        for (int i = 0; i < listLinkler.size(); i++) {
            dc.myClick(dc.getWebElement(listLinkler.get(i)));
        }
    }

    @Then("The Assignments page should be displayed")
    public void theAssignmentsPageShouldBeDisplayed() {
        wait.until(ExpectedConditions.elementToBeClickable(dc.calenderSearch));
        wait.until(ExpectedConditions.visibilityOf(dc.VerifyLeftHeader));
        Assert.assertEquals(dc.VerifyLeftHeader.getText().toLowerCase(),"Assignments".toLowerCase());
    }

    @When("The user clicks on the Grading menu item")
    public void theUserClicksOnTheGradingMenuItem(DataTable datatable) {
        List<String> listLinkler = datatable.asList(String.class);
        for (int i = 0; i < listLinkler.size(); i++) {
            dc.myClick(dc.getWebElement(listLinkler.get(i)));
        }
    }

    @Then("The Grading page should be displayed")
    public void theGradingPageShouldBeDisplayed() {
        wait.until(ExpectedConditions.elementToBeClickable(dc.waitForPrint));
        wait.until(ExpectedConditions.visibilityOf(dc.VerifyLeftHeader));
        Assert.assertEquals(dc.VerifyLeftHeader.getText().toLowerCase(),"Grading".toLowerCase());
    }

    @When("The user clicks on the Hamburger Menu menu item")
    public void theUserClicksOnTheHamburgerMenuMenuItem(DataTable datatable) {
        List<String> listLinkler = datatable.asList(String.class);
        for (int i = 0; i < listLinkler.size(); i++) {
            dc.myClick(dc.getWebElement(listLinkler.get(i)));
        }
    }

    @Then("The Hamburger menu should open")
    public void theHamburgerMenuShouldOpen() {
        wait.until(ExpectedConditions.visibilityOf(dc.waitForWindow));
        Assert.assertEquals(dc.messagingButton.getText().toLowerCase(),"messaging".toLowerCase());
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);

    }

    @When("The user clicks on the Chat Msg. menu item")
    public void theUserClicksOnTheChatMsgMenuItem(DataTable datatable) {
        List<String> listLinkler = datatable.asList(String.class);
        for (int i = 0; i < listLinkler.size(); i++) {
            dc.myClick(dc.getWebElement(listLinkler.get(i)));
        }
    }

    @Then("The Chat Messages section should open")
    public void theChatMessagesSectionShouldOpen() {
    }

    @When("The user clicks on the Messages menu item")
    public void theUserClicksOnTheMessagesMenuItem(DataTable datatable) {
        List<String> listLinkler = datatable.asList(String.class);
        for (int i = 0; i < listLinkler.size(); i++) {
            dc.myClick(dc.getWebElement(listLinkler.get(i)));
        }
    }

    @Then("The Messages section should open")
    public void theMessagesSectionShouldOpen() {
        wait.until(ExpectedConditions.visibilityOf(dc.VerifyRightHeader));
        Assert.assertEquals(dc.VerifyRightHeader.getText().toLowerCase(),"messages".toLowerCase());
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }

    @When("The user clicks on the {string} menu item")
    public void theUserClicksOnTheMenuItem(String arg0) {
    }

    @Then("The {string} section should open")
    public void theSectionShouldOpen(String arg0) {
    }

    @Then("The {string} page should be displayed")
    public void thePageShouldBeDisplayed(String arg0) {
    }

    @When("The user clicks on the Profile menu item")
    public void theUserClicksOnTheProfileMenuItem(DataTable datatable) {
        List<String> listLinkler = datatable.asList(String.class);
        for (int i = 0; i < listLinkler.size(); i++) {
            dc.myClick(dc.getWebElement(listLinkler.get(i)));
        }
    }

    @Then("The Profile section should open")
    public void theProfileSectionShouldOpen() {
        wait.until(ExpectedConditions.visibilityOf(dc.verifySignOut));
        Assert.assertEquals(dc.verifySignOut.getText().toLowerCase(),"Sign Out".toLowerCase());
    }

    @When("The user clicks on the Courses menu item")
    public void theUserClicksOnTheCoursesMenuItem() {
    }

    @Then("The Courses page should be displayed")
    public void theCoursesPageShouldBeDisplayed() {
    }
}