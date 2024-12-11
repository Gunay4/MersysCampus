package StepDefination;


import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class US_16_Grading {
    DialogContent dc = new DialogContent();
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(10));


    @Then("Verify the button was clicked")
    public void verifyTheButtonWasClicked(){

        wait.until(ExpectedConditions.attributeToBe(dc.verifyClick, "aria-selected", "true"));
        String valueSelect = dc.verifyClick.getAttribute("aria-selected");
        Assert.assertTrue(valueSelect.contains("true"),
                "Tabindex value is not correct! Current value: " + valueSelect);

        System.out.println("Clicked on " + dc.verifyClick.getText());
    }
}
