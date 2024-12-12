package StepDefinitions;

import Pages.DialogContent;
import io.cucumber.java.en.When;
import org.testng.Assert;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class US_19_Assignments {

    DialogContent dc = new DialogContent();

    @When("Navigate to Discussion")
    public void navigateToDiscussion() {
        Robot rbt;

        try {
            rbt = new Robot();

            for (int i = 1; i <= 30; i++) {
                rbt.keyPress(KeyEvent.VK_TAB);
                rbt.keyRelease(KeyEvent.VK_TAB);
            }
            rbt.keyPress(KeyEvent.VK_ENTER);
            rbt.keyRelease(KeyEvent.VK_ENTER);

            dc.myClick(dc.discussUsers);
            dc.myClick(dc.contacts);

            for (int i = 1; i <= 11; i++) {
                rbt.keyPress(KeyEvent.VK_TAB);
                rbt.keyRelease(KeyEvent.VK_TAB);
            }

            rbt.keyPress(KeyEvent.VK_ENTER);
            rbt.keyRelease(KeyEvent.VK_ENTER);


            Thread.sleep(2000);


            StringSelection folderWay = new StringSelection("C:\\Users\\deniz\\Desktop\\test\\test.txt");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(folderWay, null);
            rbt.keyPress(KeyEvent.VK_CONTROL);
            rbt.keyPress(KeyEvent.VK_V);

            rbt.keyRelease(KeyEvent.VK_V);
            rbt.keyRelease(KeyEvent.VK_CONTROL);

            for (int i = 1; i <= 2; i++) {
                rbt.keyPress(KeyEvent.VK_TAB);
                rbt.keyRelease(KeyEvent.VK_TAB);
            }
            rbt.keyPress(KeyEvent.VK_ENTER);
            rbt.keyRelease(KeyEvent.VK_ENTER);
            dc.mySendKeys(dc.discussTextField, "Mesaj kontrolü yapıldı");
            dc.myClick(dc.discussSendButton);
            Assert.assertTrue(dc.discussDate.isDisplayed(), "Gönderim Hatalı-Tarih görünmedi");

        } catch (AWTException | InterruptedException e) {
            throw new RuntimeException(e);

        }
    }
}
