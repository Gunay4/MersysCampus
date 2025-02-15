package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import Utilities.Tools;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Set;

public class US_17_Grading {
    String downloads = System.getProperty("user.home") + "/Downloads";
    Tools tools=new Tools();
    Robot robot;

    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    @When("The user views a Download icon and clicks on it")
    public void theUserViewsADownloadIconAndClicksOnIt() {

        String mainHandle = GWD.getDriver().getWindowHandle();
        Set<String> handles = GWD.getDriver().getWindowHandles();

        for (String handle : handles)
            if (!handle.equals(mainHandle))
                GWD.getDriver().switchTo().window(handle);

        tools.robotClick(15);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        tools.wait(3);


    }

    @Then("The user views PDF Document page and clicks on the Save button")
    public void theUserViewsPDFDocumentPageAndClicksOnTheSaveButton() {
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        File downloadFolder = new File(downloads);
        File[] files = downloadFolder.listFiles((downloads, name) -> name.contains(".pdf"));
        Assert.assertNotNull(files);
        Assert.assertTrue(files.length > 0);

    }
}