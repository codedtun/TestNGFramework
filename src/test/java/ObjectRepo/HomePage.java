package ObjectRepo;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(how = How.XPATH, using = "//span[@class='user-display']")
    public WebElement userNameLabel;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Calendar')]")
    public WebElement calendarLink;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Contacts')]")
    public WebElement contactsLink;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Companies')]")
    public WebElement companiesLink;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Deals')]")
    public WebElement dealsLink;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Task')]")
    public WebElement tasksLink;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Auto Tester')]")
    public WebElement userName;

    //initializing the page Objects
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    //Actions
    public String verifyCorrectUserName(){
        return userNameLabel.getText();
    }

    public String verifyHomePageTitle() {
        return driver.getTitle();
    }

    public String verifyLoggedInUser() {
        return userName.getText();
    }

    public CalendarPage clickOnCalendarLink() {
        calendarLink.click();
        return new CalendarPage();
    }

    public ContactsPage clickOnContactsLink() {
        contactsLink.click();
        return new ContactsPage();
    }

    public CompaniesPage clickOnCompaniesLink() {
        companiesLink.click();
        return new CompaniesPage();
    }

    public DealsPage clickOnDealsLink() {
        dealsLink.click();
        return new DealsPage();
    }

    public TasksPage clickOnTasksLink() {
        tasksLink.click();
        return new TasksPage();
    }
}
