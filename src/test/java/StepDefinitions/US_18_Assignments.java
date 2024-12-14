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

    @When("Hover over the Element in Assignment")
    public void hoverOverTheElementInAssignment() {
        wait.until(ExpectedConditions.visibilityOf(dc.assignment));
        actions.moveToElement(dc.assignment).perform();
        wait.until(ExpectedConditions.visibilityOf(dc.assignmentsNumber));
    }
    @Then("The assignmentsNumber should display the total number and click Assignments")
    public void theAssignmentsNumberShouldDisplayTheTotalNumberAndClickAssignments() {
        wait.until(ExpectedConditions.visibilityOf(dc.assignmentsNumber));
        String assignmentsText = dc.assignmentsNumber.getText();
        System.out.println("Displayed Assignments Number: " + assignmentsText);
        wait.until(ExpectedConditions.elementToBeClickable(dc.assignment)).click();
    }
    @Then("the number of assignments displayed should be verified")
    public void theNumberOfAssignmentsDisplayedShouldBeVerified() {
        wait.until(ExpectedConditions.visibilityOf(dc.assignment));
        actions.moveToElement(dc.assignment).perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='16']")));
    }
}

