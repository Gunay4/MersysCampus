package StepDefinitions;
import Pages.DialogContent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.GWD;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;
import java.io.File;
import java.time.Duration;
import org.openqa.selenium.WebElement;

public class US_12_HamburgerMenuFinance {

    WebDriver driver;
    WebDriverWait wait;
    DialogContent dc;
    JavascriptExecutor js;

    public US_12_HamburgerMenuFinance() {
        this.driver = GWD.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.dc = new DialogContent();
        this.js = (JavascriptExecutor) driver;
    }
    @Then("User clicks on the {string} on the Finance page")
    public void user_clicks_on_the_on_the_finance_page(String elementName) {
        try {
           WebElement element = dc.getWebElement(elementName);
           wait.until(ExpectedConditions.elementToBeClickable(element));

            js.executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(500); // Allow scrolling animation to complete

            element.click();
            System.out.println("Successfully clicked on the element: " + elementName);
        } catch (Exception e) {
            System.err.println("Error while clicking on the element: " + elementName + " - " + e.getMessage());
            Assert.fail("Failed to click on the element: " + elementName);
        }

    }
    @And("User selects the {string} option from the dropdown")
    public void userSelectsTheOptionFromTheDropdown(String elementName) {
        WebElement element = dc.getWebElement(elementName);
        dc.myClick(element);
    }
    @Then("The {string} file should be downloaded successfully")
    public void theFileShouldBeDownloadedSuccessfully(String partialFileName) {

        String downloadPath = System.getProperty("user.home") + "/Downloads/";

        boolean isFileDownloaded = false;
        File downloadedFile = null;

        for (int i = 0; i < 10; i++) {
            File[] files = new File(downloadPath).listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.getName().contains(partialFileName)) {
                        isFileDownloaded = true;
                        downloadedFile = file;
                        break;
                    }
                }
            }
            if (isFileDownloaded) break;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Assert.assertTrue(isFileDownloaded, "The file with name containing " + partialFileName + " was not downloaded successfully!");

        if (downloadedFile != null) {
            System.out.println("Downloaded file: " + downloadedFile.getName());
        }
    }


}



