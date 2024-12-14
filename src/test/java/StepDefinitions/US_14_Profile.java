package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class US_14_Profile {
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(100));
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

    @And("Upload the picture")
    public void uploadThePicture() {
        try {
            Thread.sleep(Duration.ofSeconds(2));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        StringSelection dosyaYolu= new StringSelection("C:\\Users\\aliki\\Desktop\\shrek.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(dosyaYolu, null);

       robot.keyPress(KeyEvent.VK_CONTROL);
       robot.keyPress(KeyEvent.VK_V);
       robot.keyRelease(KeyEvent.VK_CONTROL);
       robot.keyRelease(KeyEvent.VK_V);
       robot.keyPress(KeyEvent.VK_ENTER);
       robot.keyRelease(KeyEvent.VK_ENTER);
    }

    @Then("Confirm Success Message")
    public void confirmSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOf(dc.profileSccssMsg));
        Assert.assertTrue(dc.profileSccssMsg.getText().toLowerCase().contains("success".toLowerCase()));
    }
}
