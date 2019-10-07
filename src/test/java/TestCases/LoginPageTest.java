package TestCases;

import ObjectRepo.HomePage;
import ObjectRepo.LoginPage;
import Base.TestBase;
import Util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static sun.management.snmp.AdaptorBootstrap.initialize;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;

    public LoginPageTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException{
        //testBase = new TestBase
        initialization();
        testUtil = new TestUtil();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void verifyLoginPageTitleTest() {
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "Cogmento CRM");

        boolean flag = loginPage.validateLoginPageLogo();
        Assert.assertTrue(flag);
    }

    @Test(priority = 2)
    public void loginTest() {
        //do login
        loginPage.login(prop.getProperty("Email"), prop.getProperty("Password"));
        homePage = loginPage.ClickLogin();

        testUtil.explicitWait();

        String name = homePage.verifyLoggedInUser();
        Assert.assertEquals(name, "Auto Tester", "text not matched");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
