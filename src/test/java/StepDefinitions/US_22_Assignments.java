package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class US_22_Assignments {

    DialogContent dc = new DialogContent();
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(8));
    JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
    Actions actions=new Actions(GWD.getDriver());


    @Given("Navigate to the assignment select filter and search")
    public void navigateToTheAssignmentSelectFilterAndSearch() throws InterruptedException {

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

    @And("from the drop-down sort menu select and verify show by course, type, date and chart")
    public void fromTheDropDownSortMenuSelectAndVerifyShowByCourseTypeDateAndChart() {

        dc.defaultView.click();
        wait.until(ExpectedConditions.visibilityOf(dc.showbyCourse));
        dc.showbyCourse.click();
        wait.until(ExpectedConditions.visibilityOf(dc.math));
        Assert.assertEquals(dc.math.getText(),"11A-Mathematics");

        dc.showbyCourse.click();
        wait.until(ExpectedConditions.visibilityOf(dc.showbyType));
        dc.showbyType.click();
        wait.until(ExpectedConditions.visibilityOf(dc.homework));
        Assert.assertEquals(dc.homework.getText(),"Homework");

        dc.showbyType.click();
        wait.until(ExpectedConditions.visibilityOf(dc.showbyDate));
        js.executeScript("arguments[0].click();", dc.showbyDate);

        dc.showbyDate.click();
        wait.until(ExpectedConditions.visibilityOf(dc.showbyChart));
        js.executeScript("arguments[0].click();", dc.showbyChart);

    }
}
