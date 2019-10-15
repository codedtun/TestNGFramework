package Base;

import Util.TestUtil;
import Util.WebEventListener;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("C:\\Users\\Olomu\\IdeaProjects\\TestNGFramework\\src\\test\\java\\Config\\Config.Properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");

        String chromeDriverPath = prop.getProperty("Path");

        if (browserName.equals("chrome")) {

            System.setProperty("webdriver.chrome.driver", chromeDriverPath);


            ChromeOptions options = new ChromeOptions();
            options.addArguments("test-type");
            options.addArguments("--disable-infobars");
            //options.addArguments("--incognito");
            options.addArguments("--headless");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-gpu");
            //options.setAcceptInsecureCerts(true);
            options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
            driver = new ChromeDriver(options);

            /*DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability("chrome.binary", "<Path to binary>");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            driver = new ChromeDriver(capabilities);*/

        } else if (browserName.equals("FF")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Tundes World\\Automation\\Drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        e_driver = new EventFiringWebDriver(driver);
        //Now create an object of EventListenerHandler to register it with EventFiringWebDriver
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver =e_driver;

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("LoginURL"));

        }
}