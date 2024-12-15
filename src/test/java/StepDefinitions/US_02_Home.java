package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Set;


public class US_02_Home {
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));
    DialogContent dc = new DialogContent();
    static String homeWindowID = "";

    @And("Click on the element in Dialog")
    public void clickOnTheElementInDialogAnd(io.cucumber.datatable.DataTable dtButtons) {
        homeWindowID = GWD.getDriver().getWindowHandle();
        List<String> listButton = dtButtons.asList(String.class);
        for (int i = 0; i < listButton.size(); i++) {
            dc.myClick(dc.getWebElement(listButton.get(i)));
        }
    }

    @Then("Verify that home page logo is visible")
    public void verifyThatHomePageLogoIsVisible() {
        Set<String> windowsIdler = GWD.getDriver().getWindowHandles();

        for (String a : windowsIdler)
            if (!a.equals(homeWindowID))
                GWD.getDriver().switchTo().window(a);
        wait.until(ExpectedConditions.elementToBeClickable(dc.homeTSLogo));
        Assert.assertEquals(GWD.getDriver().getCurrentUrl(),"https://techno.study/");

    }


}
