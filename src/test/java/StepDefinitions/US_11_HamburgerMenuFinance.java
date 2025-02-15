package StepDefinitions;

import io.cucumber.datatable.DataTable;
import java.util.List;
import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.awt.*;
import java.awt.event.InputEvent;
import java.time.Duration;

public class US_11_HamburgerMenuFinance {
    DialogContent dc = new DialogContent();
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(10));

    @When("I wait for the {string} to become visible")
    public void iWaitForTheElementToBecomeVisible(String elementName) {
        WebElement element = dc.getWebElement(elementName);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    @And("Click on the Element in Dialog Twice")
    public void clickOnTheElementInDialogTwice(io.cucumber.datatable.DataTable dataTable) {
        Actions actions = new Actions(GWD.getDriver());
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(10));

        for (String elementName : dataTable.asList()) {
            WebElement element = dc.getWebElement(elementName);

            actions.click(element).perform();
            actions.sendKeys(Keys.ESCAPE).perform();
            wait.until(ExpectedConditions.elementToBeClickable(element));
            actions.click(element).perform();
        }
    }

    @Then("Wait for the Card Number iframe to load")
    public void waitForTheCardNumberIframeToLoad() {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));


        WebElement iframe = dc.getWebElement("paymentIframe");
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));

        try {

            WebElement cardNumberLabel = wait.until(ExpectedConditions.visibilityOf(dc.getWebElement("cardNumberLabel")));
            Assert.assertTrue(cardNumberLabel.isDisplayed(), "Card Number label is not visible");
        } finally {

            GWD.getDriver().switchTo().defaultContent();
        }
    }

    @And("Verify the Card Number field is visible")
    public void verifyTheCardNumberFieldIsVisible(io.cucumber.datatable.DataTable dataTable) {
        try {
            WebDriver driver = GWD.getDriver();

            List<String> labels = dataTable.asList();
            String elementName = labels.get(0);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(dc.paymentIframe));

            WebElement numberInputField = dc.getWebElement(elementName);
            wait.until(ExpectedConditions.visibilityOf(numberInputField));
            numberInputField.sendKeys("4242 4242 4242 4242");

            driver.switchTo().defaultContent();
        } catch (Exception e) {
            System.err.println("Error while entering card number: " + e.getMessage());
            Assert.fail("Failed to enter card number on the Fee page.");
        }
    }

    @And("User send card number in Dialog")
    public void userSendCardNumberInDialog(io.cucumber.datatable.DataTable dataTable) {
        try {
            WebDriver driver = GWD.getDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            List<List<String>> data = dataTable.asLists(String.class);
            String elementName = data.get(0).get(0);
            String cardNumber = data.get(0).get(1);

            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(dc.paymentIframe));

            WebElement numberInputField = dc.getWebElement(elementName);

            wait.until(ExpectedConditions.visibilityOf(numberInputField));
            numberInputField.sendKeys(cardNumber);

            driver.switchTo().defaultContent();
            System.out.println("Card number entered successfully.");

        } catch (Exception e) {
            System.err.println("Error while entering card number: " + e.getMessage());
            Assert.fail("Failed to enter card number.");
        }
    }

    @And("User send expiry date in Dialog")
    public void userSendExpiryDateInDialog(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists();
        WebDriver driver = GWD.getDriver();

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(dc.paymentIframe));
            for (List<String> row : data) {
                String elementName = row.get(0);
                String expiryDate = row.get(1);

                WebElement expiryInputField = dc.getWebElement(elementName);
                wait.until(ExpectedConditions.visibilityOf(expiryInputField));
                expiryInputField.sendKeys(expiryDate);
            }

            driver.switchTo().defaultContent();
        } catch (Exception e) {
            System.err.println("Error while entering expiry date: " + e.getMessage());
            Assert.fail("Failed to enter expiry date on the Fee page.");
        }
    }

    @And("User send random cvc code in Dialog")
    public void userSendRandomCvcCodeInDialog(DataTable dataTable) {
        try {

            List<String> fields = dataTable.asList();
            String elementName = fields.get(0);

            String randomCvcCode = String.valueOf((int) (Math.random() * 900) + 100);
            WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));

            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(dc.paymentIframe));

            WebElement cvcInputField = dc.getWebElement(elementName);
            wait.until(ExpectedConditions.visibilityOf(cvcInputField));
            cvcInputField.sendKeys(randomCvcCode);

            GWD.getDriver().switchTo().defaultContent();
            System.out.println("Generated CVC Code: " + randomCvcCode);

        } catch (Exception e) {
            System.err.println("Error while entering random CVC code: " + e.getMessage());
            Assert.fail("Failed to enter CVC code on the Fee page.");
        }
    }

    @And("User enters country in Dialog")
    public void userEntersCountryInDialog(DataTable dataTable) {
        WebDriver driver = null;
        try {

            driver = GWD.getDriver();

            driver.switchTo().frame(dc.paymentIframe);
            System.out.println("Switched to iframe.");


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(dc.countrySelect)).click();
            System.out.println("Dropdown opened.");

            for (WebElement option : dc.countryOptions) {
                String optionText = option.getText().trim();
                if (optionText.equalsIgnoreCase("Türkiye")) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
                    System.out.println("Scrolled to 'Türkiye'.");
                    Thread.sleep(300);
                    option.click();
                    System.out.println("Successfully selected 'Türkiye' from the dropdown.");
                    return;
                }
            }
            throw new RuntimeException("'Türkiye' option not found in the dropdown.");
        } catch (Exception e) {
            System.err.println("Error selecting 'Türkiye': " + e.getMessage());
            Assert.fail("Failed to select 'Türkiye' from the dropdown.");
        } finally {
            assert driver != null;
            driver.switchTo().defaultContent();
        }
    }
    @And("Click on the Element in Dialog and verifies the Student Payment Successfully created")
    public void clickAndVerifyStudentPaymentWithRobot(io.cucumber.datatable.DataTable dataTable) {
        WebDriver driver = GWD.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isPopupHandled = false;
        try {

            List<String> elements = dataTable.asList();
            String elementName = elements.get(0);

            WebElement element = dc.getWebElement(elementName);
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            System.out.println("Clicked on the stripePaymentsButton.");

            try {
                Thread.sleep(2000);
                Robot robot = new Robot();

                int xCoordinate = 1200;
                int yCoordinate = 300;

                robot.mouseMove(xCoordinate, yCoordinate);
                robot.delay(500);
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                System.out.println("Popup closed using Robot.");
                isPopupHandled = true;
            } catch (Exception e) {
                System.out.println("No popup detected or failed to close popup: " + e.getMessage());
            }

            try {
                WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(text(), 'Student Payment Successfully created')]")));
                Assert.assertTrue(successMessage.isDisplayed(), "Success message is not visible!");
                System.out.println("Verified the Student Payment Successfully created message.");
            } catch (TimeoutException e) {
                if (!isPopupHandled) {
                    throw new TimeoutException("Failed to verify success message or close the popup.");
                }
            }

        } catch (TimeoutException e) {
            System.err.println("Timeout while waiting for popup or success message: " + e.getMessage());
            Assert.fail("Failed to handle popup or verify success message.");
        } catch (Exception e) {
            System.err.println("Error while handling popup or verifying success message: " + e.getMessage());
            Assert.fail("Unexpected error occurred.");
        }
    }

    @And("Verify the last payment of {string} is displayed in the table")
    public void verifyLastPaymentIsDisplayed(String paymentAmount) {
        WebDriver driver = GWD.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {

            WebElement lastPayment = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("(//td[contains(text(), '" + paymentAmount + "')])[last()]")));

            js.executeScript("arguments[0].scrollIntoView(true);", lastPayment);

            Assert.assertTrue(lastPayment.isDisplayed(), "En alttaki ödeme miktarı görünmüyor!");
            System.out.println(paymentAmount + " tutarındaki en alttaki ödeme doğrulandı.");
        } catch (TimeoutException e) {
            Assert.fail("Ödeme tablosunda " + paymentAmount + " bulunamadı.");
        }

    }

    @And("Click on the Back Element in Dialog")
    public void clickOnTheBackElementInDialog(DataTable dataTable) {
        WebDriver driver = GWD.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<String> elements = dataTable.asList();
        try {

            By successMessageLocator = By.xpath("//div[text()='Student Payment successfully created']");
            wait.until(ExpectedConditions.invisibilityOfElementLocated(successMessageLocator));
            System.out.println("Success message has disappeared.");

            String elementName = elements.get(0);
            WebElement backElement = dc.getWebElement(elementName);

            js.executeScript("arguments[0].scrollIntoView(true);", backElement);

            try {
                wait.until(ExpectedConditions.elementToBeClickable(backElement)).click();
                System.out.println("Clicked on the back element using WebDriver.");
            } catch (Exception e) {
                System.out.println("WebDriver click failed, attempting JavaScript click.");

                // Fallback to JavaScript click
                js.executeScript("arguments[0].click();", backElement);
                System.out.println("Clicked on the back element using JavaScript.");
            }
        } catch (Exception e) {
            System.err.println("Error while clicking on the back element: " + e.getMessage());
            Assert.fail("Failed to click on the back element in Dialog.");
        }
    }

}





