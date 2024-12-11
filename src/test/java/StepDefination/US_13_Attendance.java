package StepDefination;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class US_13_Attendance {
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(10));
    DialogContent dc = new DialogContent();
    Actions actions = new Actions(GWD.getDriver());
    Robot robot;

    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }


    @And("Click on the Element in Dialog via Java Script")
    public void clickOnTheElementInDialogViaJavaScript(DataTable dtButtons) {
        List<String> listButton = dtButtons.asList(String.class);
        for (int i = 0; i < listButton.size(); i++) {
            attendanceClick(dc.getWebElement(listButton.get(i)));
        }
    }

    @And("User send excuses in Dialog")
    public void userSendKeysInDialog(DataTable dtKutuVeYazilar) {
        List<String> listKutuVeYazilar = dtKutuVeYazilar.asList(String.class);
        List<String> excMsgs = new ArrayList<>();
        excMsgs.add("My automation script for waking up failed because my coffee machine threw a 'No Beans Found' exception.");
        excMsgs.add("My brain’s operating system needed an unexpected update this morning—still rebooting!");
        excMsgs.add("I hit a traffic jam on the way from my bed to my desk. Turns out, my blanket wouldn’t let go!");
        for (int i = 0; i < listKutuVeYazilar.size(); i++) {
            WebElement kutu = (dc.getWebElement(listKutuVeYazilar.get(0)));
            dc.mySendKeys(kutu, excMsgs.get((int) (Math.random() * 3)));
        }
    }

    @Then("Verify that excuse message sent")
    public void verifyThatExcuseMessageSent() {
       wait.until(ExpectedConditions.visibilityOf(dc.attendanceExcMsgSent));
       wait.until(ExpectedConditions.visibilityOf(dc.attendanceVerifyName));
       wait.until(ExpectedConditions.visibilityOf(dc.attendanceVerifySent));
        Assert.assertTrue(dc.attendanceExcMsgSent.getText().toLowerCase().contains("Attendance Excuse successfully sent".toLowerCase()));
        Assert.assertTrue(dc.attendanceVerifyName.getText().toLowerCase().contains("Student_2 11A".toLowerCase()));
        Assert.assertTrue(dc.attendanceVerifySent.getText().toLowerCase().contains("Sent".toLowerCase()));
    }

    public void attendanceClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        wait.until(ExpectedConditions.elementToBeClickable(element));
        js.executeScript("arguments[0].scrollIntoView({block: 'end'});", element);
        js.executeScript("arguments[0].click();", element);
    }


    @And("Check the CheckBox")
    public void checkTheCheckBox() {
        for (int i = 0; i < 8; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.keyRelease(KeyEvent.VK_SPACE);
    }

    @And("Wait for load and click on the Element in Dialog via Java Script")
    public void waitForLoadAndClickOnTheElementInDialogViaJavaScript(DataTable dtButtons) {
        wait.until(ExpectedConditions.visibilityOf(dc.attendanceLoad));
        List<String> listButton = dtButtons.asList(String.class);
        for (int i = 0; i < listButton.size(); i++) {
            attendanceClick(dc.getWebElement(listButton.get(i)));
        }
    }
}
