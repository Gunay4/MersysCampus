package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.Given;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class US_21_Assignments {

    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(10));
    Actions actions =new Actions(GWD.getDriver());
    DialogContent dc = new DialogContent();
    Robot robot;


    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    @Given("Checking the transactions on the homework page")
    public void checkingTheTransactionsOnTheHomeworkPage() throws InterruptedException {

        for (int i = 0; i <dc.fileImportIcon.size() ; i++) {
            Assert.assertTrue(dc.fileImportIcon.get(i).isDisplayed());
        }

        wait.until(ExpectedConditions.elementToBeClickable(dc.fileImportIcon.get(3)));
        dc.fileImportIcon.get(3).click();
        wait.until(ExpectedConditions.visibilityOf(dc.notePad));
        actions.moveToElement(dc.notePad).click().build().perform();
        actions.sendKeys("Example text sent").build().perform();


        //Copy
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        robot.keyPress(KeyEvent.VK_RIGHT);
        robot.keyRelease(KeyEvent.VK_RIGHT);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        //Paste
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);


        dc.attachButton.click();
        dc.fromLocal.click();
        Thread.sleep(2000);
        StringSelection folderWay = new StringSelection("C:\\Users\\GÜNAY\\Documents\\@Test.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(folderWay, null);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        for (int i = 1; i <= 2; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        actions.moveToLocation(750,420).click().build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(dc.saveAsDraft));
        dc.saveAsDraft.click();

        wait.until(ExpectedConditions.visibilityOf(dc.successMessage));
        Assert.assertTrue(dc.successMessage.getText().toLowerCase().contains("successfully".toLowerCase()));


        dc.submitBtn.click();
        dc.yesBtn.click();
        wait.until(ExpectedConditions.visibilityOf(dc.successSendMessagge));
        Assert.assertTrue(dc.successSendMessagge.getText().toLowerCase().contains("successfully submitted"));

        dc.rndmIconPlace.get((int) (Math.random()*dc.rndmIconPlace.size())).click();
        wait.until(ExpectedConditions.visibilityOf(dc.newSubmission));
        Assert.assertTrue(dc.newSubmission.isDisplayed(),"New Submission butonu görünmüyor");
        dc.newSubmission.click();
        wait.until(ExpectedConditions.visibilityOf(dc.notePad));
        Assert.assertTrue(dc.notePad.isDisplayed(),"Metin editörü açılmadı");
    }
}
