package StepDefination;

import Pages.DialogContent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.GWD;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;

import java.awt.*;
import java.awt.event.InputEvent;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebElement;

import static org.testng.AssertJUnit.assertTrue;

public class US_11_HamburgerMenuFinance {

    WebDriver driver;
    WebDriverWait wait;
    DialogContent dc;
    JavascriptExecutor js;

    public US_11_HamburgerMenuFinance() {
        this.driver = GWD.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.dc = new DialogContent();
        this.js = (JavascriptExecutor) driver;
    }

    @When("User clicks on the mat-radio-3-input")
    public void userClicksOnRadioButton() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
            WebElement stripeCircle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mat-radio-3-input']")));

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", stripeCircle);
            js.executeScript("arguments[0].click();", stripeCircle);

            System.out.println("Element başarıyla tıklandı (JavaScript ile).");
        } catch (Exception e) {
            System.err.println("Element tıklanamadı: " + e.getMessage());
        }
    }

    @When("User clicks on the \"stripeCircle\" payment option")
    public void userClicksOnStripeCircle() {
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement stripeCircle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mat-radio-3-input']")));
            stripeCircle = wait.until(ExpectedConditions.elementToBeClickable(stripeCircle));

            Actions actions = new Actions(driver);
            actions.moveToElement(stripeCircle).click().perform();

            System.out.println("Stripe ödeme seçeneği başarıyla tıklandı (Actions ile).");
        } catch (Exception e) {

            try {
                WebElement stripeCircle = driver.findElement(By.xpath("//*[@id='mat-radio-3-input']"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", stripeCircle);
                System.out.println("Stripe ödeme seçeneği başarıyla tıklandı (JavaScript ile).");
            } catch (Exception jsException) {
                System.err.println("Stripe ödeme seçeneği tıklanamadı: " + jsException.getMessage());
            }

        }
    }

    @And("User clicks on the {string} in the Fee page")
    public void userClicksOnTheInTheFeePage(String elementName) {
        WebElement element = dc.getWebElement(elementName);
        Assert.assertNotNull(element, "Element not found: " + elementName);

        try {
            element.click();
        } catch (ElementClickInterceptedException e) {

            js.executeScript("arguments[0].click();", element);
            System.out.println("JavaScript click performed for element: " + elementName);
        }
    }

    @And("User enters the amount {string}")
    public void userEntersTheAmount(String amount) {

        WebElement amountInputField = dc.amountInputField;
        amountInputField.sendKeys(amount);  // Enter the specified amount
    }

    @When("I click on the {string} once")
    public void iClickOnTheOnce(String element) {
        try {
            Robot robot = new Robot();
            WebElement payButton = dc.payButton;

            Point point = payButton.getLocation();
            int x = point.getX();
            int y = point.getY();

            robot.mouseMove(x, y);
            robot.mousePress(InputEvent.BUTTON1_MASK);  // Sol fare tuşu
            robot.mouseRelease(InputEvent.BUTTON1_MASK);  // Sol fare tuşunu bırak

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @When("I wait for the payButton to become visible")
    public void iWaitForThePayButtonToBecomeVisible() {

    }

    @When("I click on the payButton again")
    public void iClickOnThePayButtonAgain() {
        try {
            Robot robot = new Robot();
            WebElement payButton = dc.payButton;
            Point point = payButton.getLocation();
            int x = point.getX();
            int y = point.getY();

            robot.mouseMove(x, y);
            robot.mousePress(InputEvent.BUTTON1_MASK);  // Sol fare tuşu
            robot.mouseRelease(InputEvent.BUTTON1_MASK);  // Sol fare tuşunu bırak
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @Then("User clicks on the {string} again")
    public void userClicksOnTheAgain(String element) {
        WebElement payButton = dc.payButton;
        payButton.click();
    }

    @Then("User should see the {string} label on the Fee page")
    public void userShouldSeeTheLabelOnTheFeePage(String labelText) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(dc.paymentIframe));
            WebElement label = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//label[@for='Field-numberInput' and normalize-space(text())='Card number']")));
            assertTrue("The '" + labelText + "' label is not displayed!", label.isDisplayed());

        } catch (Exception e) {
            System.err.println("Error while verifying label: " + labelText + " - " + e.getMessage());
            Assert.fail("Label '" + labelText + "' was not found on the Fee page.");
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    @Then("User enters the {string} and sends {string} card number in the Fee page")
    public void userEntersTheAndSendsCardNumberInTheFeePage(String elementName, String cardNumber) {
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(dc.paymentIframe));
            WebElement cardNumberInput = dc.getWebElement(elementName);
            cardNumberInput.sendKeys(cardNumber);
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            System.err.println("Error while entering card number: " + e.getMessage());
            Assert.fail("Failed to enter card number on the Fee page.");
        }
    }

    @Then("User enters the {string} and sends {string} as expiry date in the Fee page")
    public void userEntersTheAndSendsExpiryDateInTheFeePage(String elementName, String expiryDate) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(dc.paymentIframe));
            WebElement expiryInputField = dc.getWebElement(elementName);
            expiryInputField.sendKeys(expiryDate);
            driver.switchTo().defaultContent();

        } catch (Exception e) {
            System.err.println("Error while entering expiry date: " + e.getMessage());
            Assert.fail("Failed to enter expiry date on the Fee page.");
        }
    }

    @Then("User enters the {string} and sends a random CVV number in the Fee page")
    public void userEntersTheAndSendsRandomCVVInTheFeePage(String elementName) {
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(dc.paymentIframe));
            Random random = new Random();
            int cvv = random.nextInt(900) + 100; // Generates a random number between 100 and 999
            WebElement cvcInputField = dc.getWebElement(elementName);
            cvcInputField.sendKeys(String.valueOf(cvv));
            driver.switchTo().defaultContent();

        } catch (Exception e) {
            System.err.println("Error while entering CVV: " + e.getMessage());
            Assert.fail("Failed to enter CVV on the Fee page.");
        }
    }

    @And("User selects Türkiye from the country dropdown on the Fee page")
    public void userSelectsTürkiyeFromTheCountryDropdown() {
        try {

            driver.switchTo().frame(dc.paymentIframe);
            System.out.println("Switched to iframe.");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(dc.countrySelect)).click();
            System.out.println("Clicked on the country dropdown.");
            for (WebElement option : dc.countrySelectOptions) {
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

            driver.switchTo().defaultContent();
        }
    }

    @Then("User clicks on the {string} on the Fee page")
    public void userClicksOnTheOnTheFeePage(String element) {
        try {

            driver.switchTo().frame(dc.paymentIframe);
            System.out.println("Switched to iframe containing the " + element);
            WebElement stripeButton = new WebDriverWait(driver, Duration.ofSeconds(30))
                    .until(ExpectedConditions.elementToBeClickable(dc.stripePaymentsButton));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stripeButton);
            Thread.sleep(1000);

            stripeButton.click();
            System.out.println("Successfully clicked on the " + element);
        } catch (Exception e) {
            System.err.println("Error clicking on the element: " + element + ". " + e.getMessage());
            Assert.fail("Failed to click on the element: " + element);
        } finally {

            driver.switchTo().defaultContent();
        }
    }
}

