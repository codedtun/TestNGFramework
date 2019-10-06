package Util;

import Base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class TestUtil extends TestBase {

    public static long PAGE_LOAD_TIMEOUT = 10;
    public static long IMPLICIT_WAIT = 10;

    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("use.dir");

        FileUtils.copyFile(scrFile, new File(currentDir + "\\screenshots\\" + System.currentTimeMillis() + ".png"));
    }

    public void switchToFrame(){
        driver.switchTo().frame("mainpanel");

    }

    public void explicitWait(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement element;
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='header item']")));
    }

}
