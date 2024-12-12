package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;



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

    @FindBy(xpath = "//*[@id=\"mat-radio-3\"]/div/div")
    public WebElement stripeCircle;

    @FindBy(xpath = "(//span[@class='mdc-tab__content'])[2]")
    public WebElement feeBalanceDetail;

    @FindBy(xpath = "//ms-currency-field[@formcontrolname='customAmountField']//input[@id='ms-currency-field-0']")
    public WebElement amountField;

    @FindBy(xpath = "//button[contains(@class, 'mat-mdc-button') and .//span[text()='Pay']]")
    public WebElement payButton;

    @FindBy(xpath = "//*[@id='Field-numberInput']")
    public WebElement numberInputField;

    @FindBy(xpath = "//*[@id='Field-expiryInput']")
    public WebElement expiryInputField;

    @FindBy(xpath = "//*[@id='Field-cvcInput']")
    public WebElement cvcInputField;

    @FindBy(xpath = "//*[@id='Field-countryInput']")
    public WebElement countrySelect;

    @FindBy(css = "[value='STRIPE']")
    public WebElement stripe;

    @FindBy(xpath = "//div[contains(text(), 'Student Payment Successfully created')]")
    public WebElement paymentSuccessMessage;

    @FindBy(xpath = "//td[contains(., 'Balance')]")
    public WebElement balanceCell;

    @FindBy(xpath = "(//*[@icon='comments-alt']/button)[1]")
    public WebElement chatsIcon;

    @FindBy(css = "[icon='users']")
    public WebElement discussUsers;

    @FindBy(xpath = "//*[text()='Mark Zuckerberg']")
    public WebElement contacts;

    @FindBy(css = "[formcontrolname='commentText']")
    public WebElement discussTextField;

    @FindBy(css = "[icon='paper-plane']")
    public WebElement discussSendButton;

    @FindBy(xpath = "((//div[@style='flex-direction: column; box-sizing: border-box; display: flex;'])[41]/following::div)[2]")
    public  WebElement discussDate;

    @FindBy(xpath= "//strong[text()=' Overdue ']/following-sibling::span")
    public WebElement Verifynumber;

    @FindBy(css="[icon='info']>button")
    public List<WebElement> infoIcon;

    @FindBy(xpath = "(//span[@class='mat-focus-indicator'])[16]")
    public WebElement backButton;

    @FindBy(css="[icon='file-import']> button")
    public List<WebElement> fileImportIcon;

    @FindBy(css = "[aria-label='Close dialog']")
    public WebElement closeWindowBtn;

    @FindBy(css="[icon='star']> button")
    public List<WebElement> starIcon;

    @FindBy(css="[class='assignment ng-star-inserted']>div")
    public  List<WebElement> rndmIconPlace;

    @FindBy(css = "[class='ng-fa-icon ng-star-inserted']> svg[data-icon='star']")
    public List<WebElement> starIconMarked;

    @FindBy(css = "[class='tox-edit-area__iframe']")
    public WebElement notePad;

    @FindBy(xpath = "(//button[@class='tox-mbtn tox-mbtn--select'])[4]")
    public WebElement insertBtn;

    @FindBy(xpath = "//div[text()='Table']")
    public WebElement table;

    @FindBy(css = "[data-mce-name='Save']")
    public WebElement tableSave;

    @FindBy(css = "[icon='paperclip']")
    public WebElement attachButton;

    @FindBy(xpath = "//*[text()='From Local']")
    public WebElement fromLocal;

    @FindBy(css = "[icon='save']")
    public WebElement saveAsDraft;

    @FindBy(css ="[class='mat-accordion']")
    public WebElement successMessage;

    @FindBy(xpath = "//*[text()='Submit']")
    public WebElement submitBtn;

    @FindBy(css = "[class='mdc-button mdc-button--outlined mat-mdc-outlined-button mat-accent mat-mdc-button-base'] > :nth-child(2)")
    public WebElement yesBtn;

    @FindBy(xpath = "//*[text()='Successfully submitted to review']")
    public WebElement successSendMessagge;

    @FindBy(xpath = "(//div[@class='ng-star-inserted']//img)[1]")
    public WebElement homeMLogo;

    @FindBy(xpath = "//img[@alt='TechnoStudy']")
    public WebElement homeTSLogo;

    @FindBy(css = "[page='CALENDAR']")
    public WebElement calendarHeader;

    @FindBy(css = "[class='mdc-tab mat-mdc-tab mat-focus-indicator ng-star-inserted']")
    public WebElement calendarMenu;

    @FindBy(css = "[class='fc-icon fc-icon-chevron-left']")
    public WebElement leftArrowCalendar;

    @FindBy(css = "[class='fc-icon fc-icon-chevron-right']")
    public WebElement rightArrowCalendar;

    @FindBy(css = "[title='Today']")
    public WebElement todayBtn;

    @FindBy(xpath = "(//div[@role='tablist']//span)[3]")
    public WebElement weeklyCoursePlan;

    @FindBy(xpath = "//*[text()=' P ']")
    public WebElement letterP;

    @FindBy(xpath = "//*[text()=' S ']")
    public WebElement letterS;

    @FindBy(xpath = "//span[text()='E']")
    public WebElement letterE;

    @FindBy(xpath = "//*[text()=' C ']")
    public WebElement letterC;

    @FindBy(xpath = "//span[text()=' Published ']")
    public WebElement published;

    @FindBy(xpath = "//span[text()=' Started ']")
    public WebElement started;

    @FindBy(xpath = "//span[text()=' Ended ']")
    public WebElement ended;

    @FindBy(xpath = "//span[text()=' Cancelled ']")
    public WebElement cancelled;

    @FindBy(xpath = "(//span[@class='mat-focus-indicator'])[17]")
    public WebElement leftArrowIcon;

    @FindBy(xpath = "(//span[@class='mat-focus-indicator'])[18]")
    public WebElement todayIcon;

    @FindBy(xpath = "(//span[@class='mat-focus-indicator'])[19]")
    public WebElement rightArrowIcon;

    @FindBy(xpath = "(//span[text()='E'])[3]")
    public WebElement iconE;

    @FindBy(xpath = "(//span[text()='11A- GEOMETRY '])[1]")
    public WebElement geoMetry;

    @FindBy(css = "[placeholder='Name']")
    public WebElement lessonNames;

    @FindBy(css = "[class='mat-badge mdc-button mat-mdc-button mat-badge-accent mat-mdc-button-base mat-mdc-raised-button mdc-button--raised mat-basic mat-badge-above mat-badge-after mat-badge-small mat-badge-hidden ng-star-inserted']")
    public WebElement newSubmission;


    //US_12 locators
    @FindBy(xpath = "(//button[@aria-haspopup='menu'])[7]")
    public WebElement threeDotButton;

    @FindBy(xpath = "//button[@mat-menu-item and contains(., 'Excel Export')]")
    public WebElement excelButton;

    @FindBy(xpath = "//button[.//span[contains(text(), 'Pdf Export')] and contains(@class, 'mat-mdc-menu-item')]")
    public WebElement pdfButton;


    @FindBy(xpath = "//span[text()='Messaging']")
    public WebElement messagingButton;

    @FindBy(xpath = "//span[text()='Trash']")
    public WebElement trashButton;

    @FindBy(xpath = "//ms-delete-button")
    public WebElement deleteButton;

    @FindBy(xpath = "//button[normalize-space()='Delete']")
    public WebElement confirmDeleteButton;

    @FindBy(xpath = "//ms-standard-button[@icon='trash-restore']//button")
    public WebElement restoreButton;

    @FindBy(xpath = "//span[contains(text(),'Students Fees')]")
    public WebElement financePage;

    //US_16

    @FindBy(xpath = "//span[contains(@class, 'mat-badge') and text()='Grading']")
    public WebElement gradingButton;

    @FindBy(xpath = "//span[contains(text(),'Course Grade')]")
    public WebElement courseGradingButton;

    @FindBy(xpath = "//span[contains(text(),'Student Transcript')]")
    public WebElement studentTransButton;

    @FindBy(xpath = "//span[contains(text(),'Transcript By Subject')]")
    public WebElement transBySubjectButton;

    @FindBy(css = "div[aria-selected='true']")
    public WebElement verifyClick;

    @FindBy(xpath = "//ms-layout-menu-button//span[text()='Attendance']")
    public WebElement attendanceBtn;

    @FindBy(xpath = "//span[contains(text(),'Present')]")
    public WebElement attendanceLoad;

    @FindBy(xpath = "//span[text()=' ATTENDANCE EXCUSES ']")
    public WebElement attendanceExcBtn;

    @FindBy(xpath = "//ms-add-button[@tooltip='ATTENDANCE_EXCUSE.TITLE.ADD']")
    public WebElement attendanceExcAdd;

    @FindBy(xpath = "//textarea[contains(@id, 'ms-textarea-field')]")
    public WebElement attendanceExcReason;

    @FindBy(xpath = "//span[text()='Attach Files...']")
    public WebElement attendanceAttach;

    @FindBy(xpath = "//span[text()='From My Files']")
    public WebElement attendanceAttachFMF;

    @FindBy(xpath = "(//input[contains(@id,'mat-input')])[2]")
    public WebElement attendanceFileSearch;

    @FindBy(xpath = "(//span[text()='Search'])[2]")
    public WebElement attendanceFileSearchSend;

    @FindBy(xpath = "//(//input[@type='checkbox'])[2]")
    public WebElement attendanceSelectFile;

    @FindBy(xpath = "//ms-button[@caption='GENERAL.BUTTON.SELECT']//button")
    public WebElement attendanceFileConfirm;

    @FindBy(xpath = "//span[text()='From Local']")
    public WebElement attendanceAttachFL;

    @FindBy(xpath = "//span[text()='Send']")
    public WebElement attendanceReasonSend;

    @FindBy(xpath = "//div[text()='Attendance Excuse successfully sent']")
    public WebElement attendanceExcMsgSent;

    @FindBy(xpath = "//span[text()=' Student_2 11A']")
    public WebElement attendanceVerifyName;

    @FindBy(xpath = "//span[text()='Sent']")
    public WebElement attendanceVerifySent;

    //US_11

    @FindBy(xpath = "//mat-radio-button[@id='mat-radio-5']//span[contains(@class, 'discount-class') and contains(text(), 'Pay in full')]")
    public WebElement payInFullIndicator;

    @FindBy(xpath = "//mat-radio-button[@id='mat-radio-4']//span[text()='Pay']")
    public WebElement payIndicator;

    @FindBy(xpath = "//label[@for='Field-numberInput' and normalize-space()='Card number']")
    public WebElement cardNumberLabel;

    @FindBy(xpath = "//*[@id='payment-element']/div/iframe")
    public WebElement paymentIframe;

    @FindBy(xpath = "//select[@id='Field-countryInput']/option")
    public List<WebElement> countryOptions;

    @FindBy(xpath = "//button[contains(@class, 'stripe-pay-button') and @mat-raised-button='']")
    public WebElement stripePaymentsButton;

    @FindBy(xpath = "(//td[contains(text(), '235')])[last()]")
    public WebElement lastPayment235;

    @FindBy(css = "svg[data-icon='chevron-left']")
    public WebElement chevronLeftIcon;
///////////
    @FindBy(xpath = "(//*[@data-icon='bars'])[1]")
    public WebElement calendarDDMenu;

    @FindBy(xpath = "//span[text()='Video Conference']")
    public WebElement calenderVC;

    @FindBy(xpath = "//span[text()='Video Meetings']")
    public WebElement calenderVM;

    @FindBy(xpath = "//*[@icon='presentation']")
    public WebElement calenderPresentation;

    @FindBy(xpath = "//div[@aria-label='Progress Bar']")
    public WebElement calenderProgressBar;

    @FindBy(xpath = "//iframe[@frameborder='0']")
    public WebElement calenderFrame;

    @FindBy(xpath = "//video[@playsinline='playsinline']")
    public WebElement calenderVideoTitle;

    @FindBy(xpath = "//span[@class='icon-fullscreen']")
    public WebElement calenderFullScreen;

    @FindBy(xpath = "//span[@class='vjs-duration-display']")
    public WebElement calenderTotalDuration;

    @FindBy(xpath = "//span[@class='vjs-remaining-time-display']")
    public WebElement calenderRemDuration;

    /////

    @FindBy(xpath = "(//span[text()='11A-MATHEMATICS '])[4]")
    public WebElement mathLesson;

    @FindBy(xpath = "//div[text()=' December 11, 2024 ']")
    public WebElement dateCourseMath;

    @FindBy(xpath = "//div[text()=' 12:00 ']")
    public WebElement startTime;

    @FindBy(xpath = "//div[text()=' 12:50 ']")
    public WebElement endTime;

    @FindBy(xpath = "//div[text()=' Online ']")
    public WebElement type;

    @FindBy(xpath = "//div[text()='Course Meeting has not been started yet']")
    public WebElement courseNotStartedMessage;

    @FindBy(xpath = "//span[text()='Topic']")
    public WebElement topicButton;

    @FindBy(xpath = "//span[text()='Attachments']")
    public WebElement atttachmensBtn;

    @FindBy(xpath = "//span[text()='Recent Events']")
    public WebElement recentEvents;


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
            case "countrySelect":return this.countrySelect;
            case "stripe":return this.stripe;
            case "balanceCell":return this.balanceCell;
            case "paymentSuccessMessage":return this.paymentSuccessMessage;
            case "homeMLogo":return this.homeMLogo;
            case "calendarHeader":return this.calendarHeader;
            case "messagingButton":return this.messagingButton;
            case "trashButton":return this.trashButton;
            case "deleteButton":return this.deleteButton;
            case "restoreButton":return this.restoreButton;
            case "confirmDeleteButton":return this.confirmDeleteButton;
            case "financePage":return this.financePage;
            //US_16_Case'ler
            case "gradingButton":return this.gradingButton;
            case "courseGradingButton":return this.courseGradingButton;
            case "studentTransButton":return this.studentTransButton;
            case "transBySubjectButton":return this.transBySubjectButton;
            case "verifyClick":return this.verifyClick;
            case "attendanceBtn":return this.attendanceBtn;
            case "attendanceExcBtn":return this.attendanceExcBtn;
            case "attendanceExcAdd":return this.attendanceExcAdd;
            case "attendanceExcReason":return this.attendanceExcReason;
            case "attendanceAttach":return this.attendanceAttach;
            case "attendanceAttachFMF":return this.attendanceAttachFMF;
            case "attendanceFileSearch":return this.attendanceFileSearch;
            case "attendanceFileSearchSend":return this.attendanceFileSearchSend;
            case "attendanceSelectFile":return this.attendanceSelectFile;
            case "attendanceFileConfirm":return this.attendanceFileConfirm;
            case "attendanceAttachFL":return this.attendanceAttachFL;
            case "attendanceReasonSend":return this.attendanceReasonSend;
            case "attendanceExcMsgSent":return this.attendanceExcMsgSent;
            case "attendanceVerifyName":return this.attendanceVerifyName;
            case "attendanceVerifySent":return this.attendanceVerifySent;
            //US_12 case ler
            case "threeDotButton":return this.threeDotButton;
            case "excelButton":return this.excelButton;
            case "pdfButton":return this.pdfButton;
            //US_11 caseler
            case "payInFullIndicator":return this.payInFullIndicator;
            case "payIndicator":return this.payIndicator;
            case "cardNumberLabel":return this.cardNumberLabel;
            case "paymentIframe":return this.paymentIframe;
            case "stripePaymentsButton":return this.stripePaymentsButton;
            case "lastPayment235":return this.lastPayment235;
            case "chevronLeftIcon":return this.chevronLeftIcon;
            case "calendarDDMenu":return this.calendarDDMenu;
            case "calenderVC":return this.calenderVC;
            case "calenderVM":return this.calenderVM;
            case "calenderPresentation":return this.calenderPresentation;
            case "calenderProgressBar":return this.calenderProgressBar;
        }
        return null;
    }


}
