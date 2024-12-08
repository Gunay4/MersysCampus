package StepDefination;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class US_20_Assignments {

    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
    DialogContent dc = new DialogContent();
    int rndNumber;


    @Given("Verify Icons on the right side of the homework list")
    public void verifyIconsOnTheRightSideOfTheHomeworkList() {

        rndNumber=(int) (Math.random()*13);
        wait.until(ExpectedConditions.visibilityOf(dc.biologyLocator));
        wait.until(ExpectedConditions.elementToBeClickable(dc.infoIcon.get(rndNumber)));
        dc.infoIcon.get(rndNumber).click();
        wait.until(ExpectedConditions.visibilityOf(dc.backButton));
        dc.myClick(dc.backButton);

        wait.until(ExpectedConditions.visibilityOf(dc.fileImportIcon.get(rndNumber)));
        dc.fileImportIcon.get(rndNumber).click();
        dc.myClick(dc.closeWindowBtn);

        dc.starIcon.get(rndNumber).click();
        Assert.assertTrue(dc.starIconMarked.get(rndNumber).isSelected()," Favoriye alınamadı");

        dc.rndmIconPlace.get((rndNumber*dc.rndmIconPlace.size())).click();


    }
}
