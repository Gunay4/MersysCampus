package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class US_10_HamburgerMenuFinance {
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(100));
    DialogContent dc = new DialogContent();
    Actions actions = new Actions(GWD.getDriver());
    Robot robot;
    static String revenueFirst = "";
    static String revenueSecond = "";

    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    @And("Check the Stripe Box")
    public void checkTheStripeBox() {
        try {
            Thread.sleep(Duration.ofSeconds(2));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 4; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.keyRelease(KeyEvent.VK_SPACE);
        dc.myClick(dc.hMOnlinePayment);
        for (int i = 0; i < 4; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_UP);
        robot.keyRelease(KeyEvent.VK_UP);
    }

    @And("Press Tab to leave input box")
    public void pressTabToLeaveInputBox() {
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
    }

    @And("Remember the revenue amount")
    public void rememberTheRevenueAmount() {
        wait.until(ExpectedConditions.visibilityOf(dc.hMTotalRevenue));
        revenueFirst = dc.hMTotalRevenue.getText();
    }

    @Then("Confirm that payment message appeared")
    public void confirmThatPaymentMessageAppeared() {
        wait.until(ExpectedConditions.visibilityOf(dc.hMPayConfirmationMsg));
        Assert.assertEquals(dc.hMPayConfirmationMsg.getText(),
                "Student Payment successfully created");
    }

    @And("Compare the revenue amount")
    public void compareTheRevenueAmount(DataTable dtAmount) {
        List<Integer> listAmount = dtAmount.asList(Integer.class);
        wait.until(ExpectedConditions.visibilityOf(dc.hMTotalRevenue));
        revenueSecond = dc.hMTotalRevenue.getText();
        Assert.assertTrue(
                (Integer.parseInt(revenueSecond.replaceAll("[^0-9]", "")) -
                        Integer.parseInt(revenueFirst.replaceAll("[^0-9]", "")))
                        == listAmount.getFirst());
    }


    @And("Switch to payment frame")
    public void switchToPaymentFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(dc.hMIframe));
    }


    @And("Switch back to payment frame")
    public void switchBackToPaymentFrame() {
        GWD.getDriver().switchTo().parentFrame();
    }

    @And("Navigate back")
    public void navigateBack() {
        GWD.getDriver().navigate().back();
    }

    @Then("Verify that message box contains payment message")
    public void verifyThatMessageBoxContainsPaymentMessage() {
        wait.until(ExpectedConditions.visibilityOf(dc.hMMessageTitle));
        Assert.assertTrue(dc.hMMessageTitle.getText().toLowerCase().contains("stripe".toLowerCase()));
    }
}
