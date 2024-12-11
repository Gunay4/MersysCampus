package StepDefination;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.Then;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class US_07_HamburgerMenuMessaging {

    DialogContent dc = new DialogContent();
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(10));


    @Then("Elements icon to be displayed")
    public void elementsIconToBeDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(dc.deleteButton));
        Assert.assertTrue(dc.deleteButton.isDisplayed());

        wait.until(ExpectedConditions.visibilityOf(dc.restoreButton));
        Assert.assertTrue(dc.restoreButton.isDisplayed());
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(dc.successMessage));
        Assert.assertTrue(dc.successMessage.isDisplayed());
        Assert.assertTrue(dc.successMessage.getText().toLowerCase().contains("success".toLowerCase()));
    }
}
