package ObjectRepo;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactsPage extends TestBase {

    @FindBy(how = How.XPATH, using = "//div[@class='ui header item mb5 light-black']")
    public WebElement contactsPageImg;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'New')]")
    public WebElement newContactsLnk;

    @FindBy(how = How.NAME, using = "first_name")
    public WebElement firstName;

    @FindBy(how = How.NAME, using = "last_name")
    public WebElement lastName;

    @FindBy(how = How.XPATH, using = "//div[@name='company']//input[@class='search']")
    public WebElement company;

    @FindBy(how = How.XPATH, using = "//div[@class='ui right corner labeled input']//input[@name='value']")
    public WebElement mail;

    @FindBy(how = How.XPATH, using = "//button[@class='ui linkedin button']")
    public WebElement saveBtn;

    @FindBy(how = How.XPATH, using = "//td[contains(text(),'Sharon Shelton')]")
    public WebElement newContacts;

    //initializing the page Objects
    public ContactsPage() {
        PageFactory.initElements(driver, this);
    }

    //Actions
    public Boolean verifyContactsPageLabel(){
        return contactsPageImg.isDisplayed();
    }

    public void selectContactsByName(String name){
        driver.findElement(By.xpath("//td[contains(text(),'"+name+"')] ")).click();
    }

    public void createNewContacts(String ftName, String ltName, String comp, String email) {
        /*Select select = new Select(driver.findElement(By.name("title")));
        select.selectByVisibleText(ftName);*/

        firstName.sendKeys(ftName);
        lastName.sendKeys(ltName);
        company.sendKeys(comp);
        mail.sendKeys(email);

        saveBtn.click();

    }

    public void clickOnNewContactsLink(){
        /*Actions action = new Actions(driver);
        action.moveToElement(newContactsLnk).build().perform();*/
        newContactsLnk.click();
    }

}
