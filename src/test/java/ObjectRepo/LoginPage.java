package ObjectRepo;

import Base.TestBase;
import TestCases.LoginPageTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends TestBase{
    private final Logger logger = Logger.getLogger(LoginPageTest.class.getName());

    @FindBy(how=How.NAME,using="email")
    public WebElement txtEmail;

    @FindBy(how=How.NAME,using="password")
    public WebElement txtPassword;

    @FindBy(how=How.CSS,using="div.ui.fluid.large.blue.submit.button")
    public WebElement btnLogin;

    @FindBy(how=How.LINK_TEXT,using="Sign Up")
    public WebElement btnSignUp;

    @FindBy(how=How.LINK_TEXT,using="Forgot your password?")
    public WebElement imgLogo;

    //initializing the page Objects
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    //Actions
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean validateLoginPageLogo()
    {
        return imgLogo.isDisplayed();
    }

    public HomePage login(String email, String password){
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        return null;
    }

    public HomePage ClickLogin()
    {
        btnLogin.click();
        return new HomePage();
    }

    public boolean verifyIsLoggedOut() throws InterruptedException {

        return btnSignUp.isDisplayed();

    }
}
