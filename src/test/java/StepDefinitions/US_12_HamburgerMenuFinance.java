package StepDefinitions;
import Pages.DialogContent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.GWD;
import org.testng.Assert;
import java.io.File;
import java.time.Duration;


public class US_12_HamburgerMenuFinance {
    WebDriverWait wait= new WebDriverWait(GWD.getDriver(),Duration.ofSeconds(10));
    DialogContent dc = new DialogContent();
    String downloads = System.getProperty("user.home") + "/Downloads";


    @And("User clicks on the threeDotButton on the Finance page")
    public void userClicksOnTheThreeDotButtonOnTheFinancePage() {
        wait.until(ExpectedConditions.visibilityOf(dc.threeDotButton));
        dc.myClick(dc.threeDotButton);
    }

    @Then("User selects the excelButton option from the dropdown")
    public void userSelectsTheExcelButtonOptionFromTheDropdown() {
        wait.until(ExpectedConditions.visibilityOf(dc.excelButton));
        dc.myClick(dc.excelButton);
    }

    @Then("The Excel file should be downloaded successfully")
    public void theExcelFileShouldBeDownloadedSuccessfully() {

        File downloadFolder = new File(downloads);
        File[] files = downloadFolder.listFiles((downloads, name) -> name.contains(".xlsx"));
        Assert.assertNotNull(files);
        System.out.println("files.length = " + files.length);
        Assert.assertTrue(files.length > 0);

    }
}



