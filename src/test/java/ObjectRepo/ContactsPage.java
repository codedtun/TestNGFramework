package ObjectRepo;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactsPage extends TestBase {

    @FindBy(how = How.XPATH, using = "//div[@class='ui header item mb5 light-black']")
    public WebElement contactsPageImg;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'New')]")
    public WebElement newContactsLnk;

    @FindBy(how = How.NAME, using = "first_name")
    public WebElement firstName;

    @FindBy(how = How.NAME, using = "last_name")
    public WebElement lastName;

    @FindBy(how = How.CSS, using = "i.save")
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

    public void createNewContacts(String ftName, String ltName) throws InterruptedException {
        /*Select select = new Select(driver.findElement(By.name("title")));
        select.selectByVisibleText(ftName);*/

        firstName.sendKeys(ftName);
        lastName.sendKeys(ltName);
        saveBtn.sendKeys();
        saveBtn.click();

        /*Actions actions = new Actions(driver);
        actions.moveToElement(firstName);
        actions.sendKeys(ftName);
        actions.build().perform();*/

        /*Actions actions = new Actions(driver);
        actions.moveToElement(saveBtn);
        actions.click();
        actions.build().perform();*/

        /*Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.name("first_name")));
        actions.click();
        actions.sendKeys(ftName);
        actions.build().perform();*/

        /*WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("i.save"))));
        actions.moveToElement(driver.findElement(By.cssSelector("i.save")));*/

    }

    public void clickOnNewContactsLink(){
        /*Actions action = new Actions(driver);
        action.moveToElement(newContactsLnk).build().perform();*/
        newContactsLnk.click();
    }
}