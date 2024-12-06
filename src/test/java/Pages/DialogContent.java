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






    public WebElement getWebElement(String strElementName){

        switch (strElementName.trim()) {
            case "loginUsername":return this.loginUsername;
            case "loginPassword":return this.loginPassword;
            case "loginButton":return this.loginButton;
            case "loginInvMsg":return this.loginInvMsg;
            case "loginWelcome":return this.loginWelcome;


        }
        return null;
    }
}
