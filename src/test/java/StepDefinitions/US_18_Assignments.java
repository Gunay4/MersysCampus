package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class US_18_Assignments {

    DialogContent dc = new DialogContent();
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(15));
    JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
    Actions actions = new Actions(GWD.getDriver());
    String assignmentsText;

    @When("The user hovers over the assignments item")
    public void theUserHoversOverTheAssignmentsItem() {
        wait.until(ExpectedConditions.visibilityOf(dc.assignment));
        actions.moveToElement(dc.assignment).build().perform();
        wait.until(ExpectedConditions.visibilityOf(dc.assignmentsNumber));

    }

    @Then("Total number of assignments task should appear")
    public void totalNumberOfAssignmentsTaskShouldAppear() {
        assignmentsText = dc.assignmentsNumber.getText();
        System.out.println("Displayed Assignments Number: " + assignmentsText);
        Assert.assertTrue(assignmentsText.contains("16"));

    }

    @And("The user should see the tasks when click on the assignments item")
    public void theUserShouldSeeTheTasksWhenClickOnTheAssignmentsItem() {
        wait.until(ExpectedConditions.elementToBeClickable(dc.assignment)).click();
        dc.myClick(dc.assignment);

        wait.until(ExpectedConditions.visibilityOf(dc.course));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", dc.course);
        wait.until(ExpectedConditions.elementToBeClickable(dc.course));
        dc.course.click();

        actions.moveToLocation(750,420).click().build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(dc.status));
        dc.status.click();
        wait.until(ExpectedConditions.visibilityOf(dc.checkBox));
        dc.checkBox.click();

        actions.moveToLocation(750,420).click().build().perform();
        dc.semester.click();
        wait.until(ExpectedConditions.visibilityOf(dc.all));
        dc.all.click();
    }
}
