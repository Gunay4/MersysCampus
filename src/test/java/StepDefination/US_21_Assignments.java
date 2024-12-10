package StepDefination;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class US_21_Assignments {

    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(10));
    Actions action=new Actions(GWD.getDriver());
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
        action.moveToElement(dc.notePad).click().build().perform();
        action.sendKeys("Example text sent").build().perform();
//
//        String textToCopy = "Bu bir test metnidir.";
//        StringSelection stringSelection = new StringSelection(textToCopy);
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
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

        dc.insertBtn.click();
        dc.table.click();
        wait.until(ExpectedConditions.elementToBeClickable(dc.tableSave));
        dc.tableSave.click();

        dc.attachButton.click();
        dc.fromLocal.click();
        Thread.sleep(2000);
        StringSelection folderWay = new StringSelection("C:\\Users\\deniz\\Desktop\\test\\test.txt");
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

        dc.saveAsDraft.click();
        Assert.assertTrue(dc.successMessage.getText().toLowerCase().contains("successfully"));

        Assert.assertFalse(dc.submitBtn.isDisplayed(),"Buton hala aktif");

        dc.submitBtn.click();
        dc.yesBtn.click();
        Assert.assertTrue(dc.successSendMessagge.getText().toLowerCase().contains("successfully submitted"));





    }
}
