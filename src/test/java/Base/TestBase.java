package Base;

import Utilities.ExcelReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    /*
    This class will have all the common methods and variables for the followings
     1. webdriver - done
     2. properties - done
     3. logs -
     4. extent report
     5. DB
     6. Email
     7. Excel
     8. ReportNG
     */


    public static WebDriver driver;
    public static Properties config = new Properties();
    public static Properties OR = new Properties();
    public static FileInputStream fis;
    public static Logger logger = LogManager.getLogger("org.example");

    public static ExcelReader excel;
    static {
        try {
            excel = new ExcelReader(System.getProperty("user.dir") + "/src/test/resources/Excel/CustomerData.xlsx");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeSuite
    public void setUp() {
        // Clear previous logs
        try {
            Files.deleteIfExists(Paths.get(System.getProperty("user.dir") + "/src/test/resources/Logs/Application.log"));
            Files.deleteIfExists(Paths.get(System.getProperty("user.dir") + "/src/test/resources/Logs/Selenium.log"));
        } catch (IOException e) {
            logger.error("Could not delete old log files", e);
        }


        if (driver == null) {
            try {
                fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Properties/config.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                config.load(fis);
                fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Properties/OR.properties");
                OR.load(fis);
            } catch (Exception e) {
                System.out.println("could not load properties file");
            }

            boolean headless = Boolean.parseBoolean(config.getProperty("headless"));

            if (config.getProperty("browser").equals("chrome")) {
                ChromeOptions options = new ChromeOptions();
                if (headless) {
                    options.addArguments("--headless");
                    options.addArguments("--disable-cookies"); // Disable cookies
                    options.addArguments("--disable-gpu"); // Disable GPU for headless mode
                    driver = new ChromeDriver(options);
                } else {
                    driver = new ChromeDriver();
                }
                logger.info("Chrome driver created");
            } else if (config.getProperty("browser").equals("firefox")) {
                FirefoxOptions options = new FirefoxOptions();
                if (headless) {
                    options.addArguments("--headless");
                    options.addArguments("--disable-cookies"); // Disable cookies
                    options.addArguments("--disable-gpu"); // Disable GPU for headless mode
                    driver = new FirefoxDriver(options);
                } else {
                    driver = new FirefoxDriver();
                }
                logger.info("Firefox driver created");
            } else if (config.getProperty("browser").equals("edge")) {
                EdgeOptions options = new EdgeOptions();
                if (headless) {
                    options.addArguments("--headless");
                    options.addArguments("--disable-cookies"); // Disable cookies
                    options.addArguments("--disable-gpu"); // Disable GPU for headless mode
                    driver = new EdgeDriver(options);
                } else {
                    driver = new EdgeDriver();
                }
                logger.info("Edge driver created");
            }
        }

        //getting url and maximizing
        driver.get(config.getProperty("testsiteurl"));
        logger.info("Navigated to " + config.getProperty("testsiteurl"));
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        logger.info("Window maximized");


        //waits
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(config.getProperty("implicitwait"))));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(config.getProperty("explicitwait"))));
        FluentWait<WebDriver> fluentWait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(Long.parseLong(config.getProperty("fluentwait"))))
                        .pollingEvery(Duration.ofSeconds(Long.parseLong(config.getProperty("fluentwait"))))
                        .ignoring(Exception.class);
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
//        Thread.sleep(15000);
        if (driver != null) {
            driver.quit();
        }
        logger.info("Driver closed");
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}