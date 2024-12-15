package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class US_15_Profile {
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(100));
    DialogContent dc = new DialogContent();

    @Then("Confirm purple theme selected")
    public void confirmPurpleThemeSelected() {
        wait.until(ExpectedConditions.attributeContains(
                dc.profileSelectedTheme,
                "href",
                "purple-theme"));
        Assert.assertTrue(dc.profileSelectedTheme
                .getDomProperty("href")
                .toLowerCase()
                .contains("purple-theme"));
    }

    @Then("Confirm dark purple theme selected")
    public void confirmDarkPurpleThemeSelected() {
        wait.until(ExpectedConditions.attributeContains(
                dc.profileSelectedTheme,
                "href",
                "dark-purple-theme"));
        Assert.assertTrue(dc.profileSelectedTheme
                .getDomProperty("href")
                .toLowerCase()
                .contains("dark-purple-theme"));

    }

    @Then("Confirm indigo theme selected")
    public void confirmIndigoThemeSelected() {
        wait.until(ExpectedConditions.attributeContains(
                dc.profileSelectedTheme,
                "href",
                "indigo-theme"));
        Assert.assertTrue(dc.profileSelectedTheme
                .getDomProperty("href")
                .toLowerCase()
                .contains("indigo-theme"));
    }
}
