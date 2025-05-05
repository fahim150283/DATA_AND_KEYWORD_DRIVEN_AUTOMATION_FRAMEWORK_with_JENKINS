package Base;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    /*

    This class will have all the common methods and variables for the followings
     1. webdriver - done
     2. properties - done
     3. logs
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

    @BeforeSuite
    public void setUp() {
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
                    options.addArguments("--disable-gpu"); // Disable GPU for headless mode
                    driver = new ChromeDriver(options);
                }
            } else if (config.getProperty("browser").equals("firefox")) {
                FirefoxOptions options = new FirefoxOptions();
                if (headless) {
                    options.addArguments("--headless");
                    options.addArguments("--disable-gpu"); // Disable GPU for headless mode
                    driver = new FirefoxDriver(options);
                }
            } else if (config.getProperty("browser").equals("edge")) {
                EdgeOptions options = new EdgeOptions();
                if (headless) {
                    options.addArguments("--headless");
                    options.addArguments("--disable-gpu"); // Disable GPU for headless mode
                    driver = new EdgeDriver(options);
                }
            }
        }
        driver.get(config.getProperty("testsiteurl"));
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(config.getProperty("implicitwait"))));

    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
