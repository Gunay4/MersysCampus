package StepDefinitions;

import Pages.DialogContent;

import Utilities.GWD;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class US_09_HamburgerMenuFinance {
    DialogContent dc = new DialogContent();
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));

    @Then("User should be redirected to the Finance page")
    public void userShouldBeRedirectedToTheFinancePage() {
        wait.until(ExpectedConditions.visibilityOf(dc.studentsFeesText));
        String currentUrl = GWD.getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("student-finance/active"), "User is not redirected to the Finance page.");
    }
    @Then("User should be redirected to the Student's Fee page")
    public void userShouldBeRedirectedToTheStudentFeePage() {
        wait.until(ExpectedConditions.visibilityOf(dc.studentsFeesText));
        Assert.assertTrue(dc.studentsFeesText.isDisplayed(), "User is not redirected to the Student's Fee page.");
    }
    @Then("Verify that fee balance detail page is visible")
    public void verifyThatFeeBalanceDetailPageIsVisible() {
        wait.until(ExpectedConditions.visibilityOf(dc.feeBalanceDetail));
        Assert.assertTrue(dc.feeBalanceDetail.isDisplayed(), "User is not redirected to the Fee Balance Detail page.");
    }
}