package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class US_08_HamburgerMenuFinance {

    DialogContent dc = new DialogContent();
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(10));


    @Then("Page should be Finance")
    public void pageShouldBeFinance(){
        wait.until(ExpectedConditions.visibilityOf(dc.financePage));
        Assert.assertTrue(dc.financePage.isDisplayed());
        Assert.assertTrue(dc.financePage.getText().toLowerCase().contains("fees".toLowerCase()));

    }
}
