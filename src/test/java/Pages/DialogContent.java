package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DialogContent extends ParentPage{
    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }
    @FindBy(css = "[formcontrolname='username']")
    public WebElement loginUsername;

    @FindBy(css = "[formcontrolname='password']")
    public WebElement loginPassword;

    @FindBy(xpath = "//span[@class='mdc-button__label']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[text()='Invalid username or password']")
    public WebElement loginInvMsg;

    @FindBy(xpath = "//span[text()=' Welcome, Student_2 11A ! ']")
    public WebElement loginWelcome;

    @FindBy(css = "[page='ASSIGNMENT']")
    public WebElement assignment;

    @FindBy(xpath = "(//mat-select[@role='combobox'])[1]")
    public WebElement course;

    @FindBy(xpath = "(//mat-select[@role='combobox'])[2]")
    public WebElement status;

    @FindBy(css = "[class='mat-pseudo-checkbox mat-mdc-option-pseudo-checkbox mat-pseudo-checkbox-full ng-star-inserted']")
    public WebElement checkBox;

    @FindBy(xpath = "(//mat-select[@role='combobox'])[3]")
    public WebElement semester;

    @FindBy(css = "[value='all']")
    public WebElement all;

    @FindBy(xpath = "//span[text()='Default View']")
    public WebElement defaultView;

    @FindBy(xpath = "//span[text()='Show by Course']")
    public WebElement showbyCourse;

    @FindBy(xpath = "//span[text()=' 11A-Mathematics ']")
    public WebElement math;

    @FindBy(xpath = "//span[text()='Show by Type']")
    public WebElement showbyType;

    @FindBy(xpath = "//span[text()=' Homework ']")
    public WebElement homework;

    @FindBy(xpath = "(//span[text()='Show by Date'])[1]")
    public WebElement showbyDate;

    @FindBy(xpath = "(//div[@class='mat-badge dueDate mat-badge-accent mat-badge-overlap mat-badge-above mat-badge-after mat-badge-small'])[1]")
    public WebElement date;

    @FindBy(xpath = "(//span[text()='Show by Chart'])[1]")
    public WebElement showbyChart;

    @FindBy(xpath= "//button[@aria-haspopup='menu' and contains(@class, 'mat-mdc-button-wrapper')]")
    public WebElement hamburgerMenuButton;

    @FindBy(xpath = "//span[text()='Finance']")
    public WebElement financeButton;

    @FindBy(xpath = "//button[.//span[text()='My Finance']]")
    public WebElement myFinanceButton;

    @FindBy(css = "span[style*='font-size: 16px']")
    public WebElement studentsFeesText;

    @FindBy(xpath = "//tr[contains(@class, 'mat-mdc-row')][1]")
    public WebElement studentRow;

    @FindBy(xpath = "//*[@id='mat-radio-3-input']")
    public WebElement stripeCircle;

    @FindBy(xpath = "(//span[@class='mdc-tab__content'])[2]")
    public WebElement feeBalanceDetail;

    @FindBy(xpath = "//ms-currency-field[@formcontrolname='customAmountField']//input[@id='ms-currency-field-0']")
    public WebElement amountField;

    @FindBy(xpath = "//button[.//span[text()='Pay']]")
    public WebElement payButton;

    @FindBy(xpath = "//*[@id='Field-numberInput']")
    public WebElement numberInputField;

    @FindBy(xpath = "//*[@id='Field-expiryInput']")
    public WebElement expiryInputField;

    @FindBy(xpath = "//*[@id='Field-cvcInput']")
    public WebElement cvcInputField;

    @FindBy(xpath = "//*[@id='Field-countryInput']")
    public WebElement countryInputField;

    @FindBy(css = "[value='STRIPE']")
    public WebElement stripe;

    @FindBy(xpath = "//div[contains(text(), 'Payment successful')]")
    public WebElement paymentSuccessMessage;

    @FindBy(xpath = "//td[contains(., 'Balance')]")
    public WebElement balanceCell;




    public WebElement getWebElement(String strElementName){

        switch (strElementName.trim()) {
            case "loginUsername":return this.loginUsername;
            case "loginPassword":return this.loginPassword;
            case "loginButton":return this.loginButton;
            case "loginInvMsg":return this.loginInvMsg;
            case "loginWelcome":return this.loginWelcome;
            case "hamburgerMenuButton":return this.hamburgerMenuButton;
            case "financeButton":return this.financeButton;
            case "myFinanceButton":return this.myFinanceButton;
            case "studentsFeesText":return this.studentsFeesText;
            case "studentRow":return this.studentRow;
            case "stripeCircle":return this.stripeCircle;
            case "feeBalanceDetail":return this.feeBalanceDetail;
            case "amountField":return this.amountField;
            case "payButton":return this.payButton;
            case "numberInputField":return this.numberInputField;
            case "expiryInputField":return this.expiryInputField;
            case "cvcInputField":return this.cvcInputField;
            case "countryInputField":return this.countryInputField;
            case "stripe":return this.stripe;
            case "balanceCell":return this.balanceCell;
            case "paymentSuccessMessage":return this.paymentSuccessMessage;

        }
        return null;
    }


}
