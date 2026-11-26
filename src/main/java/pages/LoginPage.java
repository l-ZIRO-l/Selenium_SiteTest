package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Log;

/**
 * Page Object representing the SauceDemo login page.
 */
public class LoginPage {

    private static final long TYPING_DELAY_MS = 150;

    private final WebDriver driver;

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Types text one character at a time with a short delay so input is visibly observable.
     */
    private void typeSlowly(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        if (text == null) {
            return;
        }
        for (char ch : text.toCharArray()) {
            element.sendKeys(String.valueOf(ch));
            try {
                Thread.sleep(TYPING_DELAY_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    /**
     * Enters the given username into the username input field.
     */
    public void enterUsername(String username) {
        Log.info("Entering username: " + username);
        typeSlowly(usernameField, username);
    }

    /**
     * Enters the given password into the password input field.
     */
    public void enterPassword(String password) {
        Log.info("Entering password");
        typeSlowly(passwordField, password);
    }

    /**
     * Clicks the login button to submit credentials.
     */
    public void clickLogin() {
        Log.info("Clicking login button");
        driver.findElement(loginButton).click();
    }
}
