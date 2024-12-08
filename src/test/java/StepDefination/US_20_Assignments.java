package StepDefination;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class US_20_Assignments {

    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
    DialogContent dc = new DialogContent();
    JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
    int rndNumber;


    @Given("Verify Icons on the right side of the homework list")
    public void verifyIconsOnTheRightSideOfTheHomeworkList() {

        rndNumber = (int) (Math.random() * 13);
        wait.until(ExpectedConditions.textToBePresentInElement(dc.Verifynumber, "11"));
        wait.until(ExpectedConditions.elementToBeClickable(dc.infoIcon.get(rndNumber)));
        dc.infoIcon.get(rndNumber).click();


        wait.until(ExpectedConditions.visibilityOf(dc.backButton));
        dc.backButton.click();

        dc.myClick(dc.assignment);
        wait.until(ExpectedConditions.textToBePresentInElement(dc.Verifynumber, "11"));

        wait.until(ExpectedConditions.visibilityOf(dc.fileImportIcon.get(rndNumber)));
        dc.fileImportIcon.get(rndNumber).click();
        dc.myClick(dc.closeWindowBtn);

        wait.until(ExpectedConditions.textToBePresentInElement(dc.Verifynumber, "11"));
        js.executeScript("arguments[0].click();", dc.starIcon.get(rndNumber));
        Assert.assertTrue(dc.starIconMarked.getFirst().isDisplayed());
        Assert.assertTrue(dc.chatsIcon.isDisplayed());
    }
}
