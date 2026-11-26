package base;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Log;

import java.time.Duration;

public class BaseTest {

    private static final Logger log = LogManager.getLogger(BaseTest.class);
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        log.info("Starting drivers...");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        Log.info("Navigating URL....");
        driver.get("https://saucedemo.com");
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            Log.warn("Closing Browser...");
           //driver.quit();
        }
    }
}