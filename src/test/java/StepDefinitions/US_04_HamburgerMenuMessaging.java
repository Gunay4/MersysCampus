package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class US_04_HamburgerMenuMessaging {
    DialogContent dc = new DialogContent();
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(15));
    JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
    Actions actions = new Actions(GWD.getDriver());

    @Then("Hover over the Element in Messaging")
    public void hoverOverTheElementInMessaging() {
        wait.until(ExpectedConditions.visibilityOf(dc.messagingButton));
        actions.moveToElement(dc.messagingButton).perform();
    }
    @Then("The following links should be visible:")
    public void theFollowingLinksShouldBeVisible(io.cucumber.datatable.DataTable dataTable) {
        DialogContent dc = new DialogContent();

        List<String> links = dataTable.asList();
        for (String link : links) {
            switch (link.toLowerCase()) {
                case "sendmessage":
                    wait.until(ExpectedConditions.visibilityOf(dc.sendMessage));
                    break;
                case "inbox":
                    wait.until(ExpectedConditions.visibilityOf(dc.Inbox));
                    break;
                case "outbox":
                    wait.until(ExpectedConditions.visibilityOf(dc.outbox));
                    break;
                case "trash":
                    wait.until(ExpectedConditions.visibilityOf(dc.Trash));
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected link: " + link);
            }
        }
    }
    public void javascriptClick(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }
    @Then("The following links should be visible and clickable:")
    public void theFollowingLinksShouldBeVisibleAndClickable(io.cucumber.datatable.DataTable dataTable) {
        List<String> links = dataTable.asList();

        for (String link : links) {
            WebElement element = null;
            switch (link.toLowerCase()) {
                case "sendmessage":
                    element = dc.sendMessage;
                    break;
                case "inbox":
                    element = dc.Inbox;
                    break;
                case "outbox":
                    element = dc.outbox;
                    break;
                case "trash":
                    element = dc.Trash;
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected link: " + link);
            }

            try {
                wait.until(ExpectedConditions.visibilityOf(element));
                Assert.assertTrue(element.isDisplayed(), link + " is not visible.");
                javascriptClick(element);
                switch (link.toLowerCase()) {
                    case "sendmessage":
                        wait.until(ExpectedConditions.visibilityOf(dc.newMessage));
                        Assert.assertTrue(dc.newMessage.isDisplayed(), "Send Message page did not load correctly.");
                        break;
                    case "inbox":
                        wait.until(ExpectedConditions.visibilityOf(dc.inboxElement));
                        Assert.assertTrue(dc.inboxElement.isDisplayed(), "Inbox page did not load correctly.");
                        break;
                    case "outbox":
                        wait.until(ExpectedConditions.visibilityOf(dc.outboxElement));
                        Assert.assertTrue(dc.outboxElement.isDisplayed(), "Outbox page did not load correctly.");
                        break;
                    case "trash":
                        wait.until(ExpectedConditions.visibilityOf(dc.trashElement));
                        Assert.assertTrue(dc.trashElement.isDisplayed(), "Trash page did not load correctly.");
                        break;
                }

                WebElement backButton = dc.backButton;
                wait.until(ExpectedConditions.visibilityOf(backButton));
                javascriptClick(backButton);

                WebElement hamburgerMenuButton = dc.hamburgerMenuButton;
                wait.until(ExpectedConditions.visibilityOf(hamburgerMenuButton));
                javascriptClick(hamburgerMenuButton);

                WebElement messagingButton = dc.messagingButton;
                wait.until(ExpectedConditions.visibilityOf(messagingButton));
                actions.moveToElement(messagingButton).perform();

            } catch (StaleElementReferenceException e) {
                System.out.println("StaleElementReferenceException encountered. Retrying the step for: " + link);
                GWD.getDriver().navigate().refresh();
            }
        }
    }
}




