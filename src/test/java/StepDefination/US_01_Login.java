package StepDefination;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class US_01_Login {
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(10));
    DialogContent dc = new DialogContent();

    @Given("Navigate to website")
    public void clickOnTheElementInLeftNav() {
        GWD.getDriver().get("https://test.mersys.io/");
    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {
        wait.until(ExpectedConditions.visibilityOf(dc.loginWelcome));
        Assert.assertTrue(dc.loginWelcome.getText().toLowerCase().contains("welcome"));
    }

    @Then("User should not be able to login")
    public void userShouldNotBeAbleToLogin() {
        wait.until(ExpectedConditions.visibilityOf(dc.loginInvMsg));
        Assert.assertTrue(dc.loginInvMsg.getText().toLowerCase().contains("invalid"));

    }
}
