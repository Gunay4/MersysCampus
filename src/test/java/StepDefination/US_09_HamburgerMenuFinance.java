package StepDefination;

import Pages.DialogContent;

import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class US_09_HamburgerMenuFinance {
    DialogContent dc = new DialogContent();
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));
    @Then("User should be redirected to the Finance page")
    public void userShouldBeRedirectedToTheFinancePage() {
        wait.until(ExpectedConditions.visibilityOf(dc.getWebElement("studentsFeesText")));
        String currentUrl = GWD.getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("student-finance/active"), "User is not redirected to the Finance page.");
    }
    @Then("User should be redirected to the Student's Fee page")
    public void userShouldBeRedirectedToTheStudentFeePage() {
        WebElement studentsFeesText = dc.getWebElement("studentsFeesText");
        wait.until(ExpectedConditions.visibilityOf(studentsFeesText));
        Assert.assertTrue(studentsFeesText.isDisplayed(), "User is not redirected to the Student's Fee page.");
    }
    @Then("Verify that fee balance detail page is visible")
    public void verifyThatFeeBalanceDetailPageIsVisible() {
        WebElement feeBalanceDetail = dc.getWebElement("feeBalanceDetail");
        Assert.assertTrue(feeBalanceDetail.isDisplayed());
    }
}