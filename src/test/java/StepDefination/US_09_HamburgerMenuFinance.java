package StepDefination;

import Pages.DialogContent;
import Pages.Headers;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class US_09_HamburgerMenuFinance {
    Headers ln = new Headers();
    DialogContent dc = new DialogContent();
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));  // Bekleme süresi artırıldı
    JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
    Actions actions = new Actions(GWD.getDriver());

    @When("User clicks on the {string} from the header")
    public void userClicksOnTheFromTheHeader(String elementName) {
        dc.myClick(dc.getWebElement(elementName));
    }

    @And("User clicks on the {string} from the drop-down menu")
    public void userClicksOnTheFromTheDropDownMenu(String elementName) {
        dc.myClick(dc.getWebElement(elementName));
    }

    @And("User clicks on the {string} from the sub-menu")
    public void userClicksOnTheFromTheSubMenu(String elementName) {
        dc.myClick(dc.getWebElement(elementName));
    }

    @Then("User should be redirected to the Finance page")
    public void userShouldBeRedirectedToTheFinancePage() {
        // Sayfa başlığını ya da başka bir öğeyi kontrol ederek sayfanın yüklendiğinden emin oluyoruz.
        wait.until(ExpectedConditions.visibilityOf(dc.getWebElement("studentsFeesText"))); // "Students Fees" metninin görünmesini bekliyoruz

        // Sayfa URL'sinin doğru olduğuna emin oluyoruz.
        String currentUrl = GWD.getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("student-finance/active"), "User is not redirected to the Finance page.");
    }

    @When("User clicks on the {string} in the Finance table")
    public void userClicksOnTheStudentRow(String row) {
        WebElement studentRow = dc.getWebElement(row);
        dc.myClick(studentRow);
    }

    @Then("User should be redirected to the Student's Fee page")
    public void userShouldBeRedirectedToTheStudentFeePage() {
        // Sayfada belirli bir öğenin (örneğin "Students Fees") görünür olduğundan emin olun
        WebElement studentsFeesText = dc.getWebElement("studentsFeesText"); // studentsFeesText öğesini burada alıyoruz
        wait.until(ExpectedConditions.visibilityOf(studentsFeesText)); // Bu öğenin görünür olmasını bekliyoruz

        // Öğenin gerçekten görünür olduğundan emin oluyoruz
        Assert.assertTrue(studentsFeesText.isDisplayed(), "User is not redirected to the Student's Fee page.");
    }


    @Then("User clicks on the {string}")
    public void userClicksOnTheFeeBalanceDetail(String row) {
        WebElement feeBalanceDetail = dc.getWebElement("feeBalanceDetail");
        dc.myClick(feeBalanceDetail);
    }

}