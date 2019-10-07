package TestCases;

import Base.TestBase;
import ObjectRepo.ContactsPage;
import ObjectRepo.HomePage;
import ObjectRepo.LoginPage;
import Util.TestUtil;
import javafx.scene.layout.Priority;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        contactsPage = new ContactsPage();
        loginPage = new LoginPage();

    }

    @Test(priority=1)
        public void verifyHomePageTitleTest(){
        loginPage.login(prop.getProperty("Email"), prop.getProperty("Password"));
        homePage = loginPage.ClickLogin();
        String homePageTitle = homePage.verifyHomePageTitle();
        Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home page title not matched");
    }

    @Test(priority=2)
    public void verifyUserNameTest() throws InterruptedException {
        Thread.sleep(1000l);
        testUtil.switchToFrame();
        Assert.assertTrue(homePage.verifyCorrectUserName());
    }

    @Test(priority=3)
    public void verifyContactsLinkTest() throws InterruptedException {
        Thread.sleep(1000l);
        testUtil.switchToFrame();
        contactsPage = homePage.clickOnContactsLink();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
