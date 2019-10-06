package TestCases;

import Base.TestBase;
import ObjectRepo.ContactsPage;
import ObjectRepo.HomePage;
import ObjectRepo.LoginPage;
import Util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;

    String sheetName = "Contacts";

    public ContactsPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        contactsPage = new ContactsPage();
        loginPage = new LoginPage();
        loginPage.login(prop.getProperty("Email"), prop.getProperty("Password"));
        homePage = loginPage.ClickLogin();

    }

    @Test(priority=1)
    public void verifyContactsPageLabel() {
        contactsPage = homePage.clickOnContactsLink();
        Boolean page = contactsPage.verifyContactsPageLabel();
        Assert.assertTrue(page, "contacts label is missing on the page");
    }

    @Test(priority=2)
    public void selectSingleContactsTest() {
        contactsPage = homePage.clickOnContactsLink();
        contactsPage.selectContactsByName("Sharon Shelton");
        contactsPage.selectContactsByName("James Phillips");
    }

    @Test(priority=3)
    public void selectMultiContactsTest() {
        contactsPage = homePage.clickOnContactsLink();
        contactsPage.selectContactsByName("Sharon Shelton");
        contactsPage.selectContactsByName("James Phillips");
    }

    @DataProvider
    public Object[][] getCRMTestData(){
        Object data [][] = TestUtil.getCRMTestData(sheetName);
        return data;
    }

    @Test(priority=4, dataProvider = "getCRMTestData")
    public void validateNewContact(String firstName, String lastName) throws InterruptedException {
        contactsPage = homePage.clickOnContactsLink();
        contactsPage.clickOnNewContactsLink();
        contactsPage.createNewContacts(firstName, lastName);
    }

    /*@Test(priority=4)
    public void validateCreateNewContactsTest() throws InterruptedException {
        contactsPage = homePage.clickOnContactsLink();
        contactsPage.clickOnNewContactsLink();
        contactsPage.createNewContacts("test", "testing", "Heaven ltd");
    }*/

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
