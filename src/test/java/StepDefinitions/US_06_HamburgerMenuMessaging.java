package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class US_06_HamburgerMenuMessaging {
    DialogContent dc = new DialogContent();
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(15));


    @And("Verify That the Trash Icon is Visible")
    public void verifyThatTheTrashIconIsVisible() {
        wait.until(ExpectedConditions.visibilityOf(dc.trashIcon));
        Assert.assertTrue(dc.trashIcon.isDisplayed());
    }


    @Then("Verify that the Trash Success Message")
    public void verifyThatTheTrashSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOf(dc.trashSuccessMessage));
        Assert.assertTrue(dc.trashSuccessMessage.isDisplayed());
        Assert.assertTrue(dc.trashSuccessMessage.getText().toLowerCase().contains("success".toLowerCase()));
    }
}


