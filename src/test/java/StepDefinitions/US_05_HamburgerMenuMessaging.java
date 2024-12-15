package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class US_05_HamburgerMenuMessaging {
    DialogContent dc = new DialogContent();
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));  // Bekleme süresi artırıldı
    Robot robot;

    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }
    @And("User Should Successfully Added")
    public void userShouldSuccessfullyAdded() {
        wait.until(ExpectedConditions.visibilityOf(dc.userSccssMsg));
        Assert.assertTrue(dc.userSccssMsg.isDisplayed());
        Assert.assertTrue(dc.userSccssMsg.getText().toLowerCase().contains("was successfully".toLowerCase()));

    }

    @And("Clean The Placeholder")
    public void cleanThePlaceholder() {
        for (int i = 0; i <= 7; i++) {
            robot.keyPress(KeyEvent.VK_BACK_SPACE);
            robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        }
    }
    @And("Switch to Rich Text Area")
    public void switchToRichTextArea() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(dc. iFrame));
    }

    @And("Navigate and Click the file and Open Button")
    public void navigateAndClickTheFileAndOpenButton() {
        GWD.getDriver().switchTo().parentFrame();
        StringSelection dosyaYolu= new StringSelection("/Users/umitsimsek/Desktop/UI_InternshipProject_UserStories_TR.pdf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(dosyaYolu, null);

        try {
            Thread.sleep(Duration.ofSeconds(2));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    @And("Verify that the Success Message")
    public void verifyThatTheSuccessSendMessage() {
        wait.until(ExpectedConditions.visibilityOf(dc.messageSuccessfully));
        Assert.assertTrue(dc.messageSuccessfully.isDisplayed());
        Assert.assertTrue(dc.messageSuccessfully.getText().toLowerCase().contains("success".toLowerCase()));

    }

    @And("Verify that the Outbox Message is Visible")
    public void verifyThatTheOutboxMessageIsVisible(DataTable dtTitle) {
        List<String> listTitle = dtTitle.asList(String.class);
        wait.until(ExpectedConditions.visibilityOf(dc.subjectTitle));
        Assert.assertEquals(dc.subjectTitle.getText(),listTitle.getFirst());
    }


    @And("Switch Back to Parent Frame")
    public void switchBackToParentFrame() {
        GWD.getDriver().switchTo().parentFrame();
    }
}


