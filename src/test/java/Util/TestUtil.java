package Util;

import Base.TestBase;
import com.sun.media.sound.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtil extends TestBase {

    public static long PAGE_LOAD_TIMEOUT = 15;
    public static long IMPLICIT_WAIT = 10;

    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("use.dir");

        FileUtils.copyFile(scrFile, new File(currentDir + "\\ScreenShots\\" + System.currentTimeMillis() + ".png"));
    }

    public void switchToFrame(){
        driver.switchTo().frame("mainpanel");
    }

    public void explicitWait(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement element;
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ui.fluid.large.blue.submit.button")));
    }

    public void explicitlyWaitForElement(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement element;
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.user-display")));
    }


    public static String TESTDATA_SHEET_PATH = "C:\\Users\\Olomu\\IdeaProjects\\TestNGFramework\\src\\test\\java\\TestData\\FreeCrmTestData.xlsx";

    static Workbook book;
    static Sheet sheet;

    public static Object[][] getCRMTestData(String sheetName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(TESTDATA_SHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
            e.printStackTrace();
        }
        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        // System.out.println(sheet.getLastRowNum() + "--------" +
        // sheet.getRow(0).getLastCellNum());
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
                // System.out.println(data[i][k]);
            }
        }
        return data;
    }
}
