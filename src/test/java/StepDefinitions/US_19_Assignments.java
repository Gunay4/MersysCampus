package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class US_19_Assignments {

    DialogContent dc = new DialogContent();
    WebDriverWait wait= new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(10));
    JavascriptExecutor js =(JavascriptExecutor) GWD.getDriver();

    @And("The user send discussion and verify all necessary steps")
    public void theUserSendDiscussionAndVerifyAllNecessarySteps() {
        Robot rbt;

        try {
            rbt = new Robot();

            for (int i = 1; i <= 28; i++) {
                rbt.keyPress(KeyEvent.VK_TAB);
                rbt.keyRelease(KeyEvent.VK_TAB);
            }
            rbt.keyPress(KeyEvent.VK_ENTER);
            rbt.keyRelease(KeyEvent.VK_ENTER);

            wait.until(ExpectedConditions.visibilityOf(dc.discussUsers));
            js.executeScript("arguments[0].click();", dc.discussUsers);
            dc.discussUsers.click();
            dc.myClick(dc.contacts);

            for (int i = 1; i <= 11; i++) {
                rbt.keyPress(KeyEvent.VK_TAB);
                rbt.keyRelease(KeyEvent.VK_TAB);
            }

            rbt.keyPress(KeyEvent.VK_ENTER);
            rbt.keyRelease(KeyEvent.VK_ENTER);


            Thread.sleep(2000);


            StringSelection folderWay = new StringSelection("\"C:\\shrek.jpg\"");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(folderWay, null);
            rbt.keyPress(KeyEvent.VK_CONTROL);
            rbt.keyPress(KeyEvent.VK_V);

            rbt.keyRelease(KeyEvent.VK_V);
            rbt.keyRelease(KeyEvent.VK_CONTROL);

            for (int i = 1; i <= 3; i++) {
                rbt.keyPress(KeyEvent.VK_TAB);
                rbt.keyRelease(KeyEvent.VK_TAB);
            }
            rbt.keyPress(KeyEvent.VK_ENTER);
            rbt.keyRelease(KeyEvent.VK_ENTER);
            dc.mySendKeys(dc.discussTextField, "Message control was done");
            dc.myClick(dc.discussSendButton);
            Assert.assertTrue(dc.discussDate.isDisplayed(), "Post is wrong - History was not appeared");

        } catch (AWTException | InterruptedException e) {
            throw new RuntimeException(e);

        }
    }
}
