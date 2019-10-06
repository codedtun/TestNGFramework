package TestCases;

import Base.TestBase;
import ObjectRepo.ContactsPage;
import ObjectRepo.HomePage;
import ObjectRepo.LoginPage;
import Util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;

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
    public void selectContactsTest() {
        contactsPage.selectContactsByName("Give Thanks");
        contactsPage.selectContactsByName("Sharon Shelton");
        contactsPage.selectContactsByName("James Phillips");
    }

    @Test(priority=3)
    public void verifyContactsLinkTest() throws InterruptedException {

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
