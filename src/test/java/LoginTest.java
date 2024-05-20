import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Use WebDriverManager to manage the FirefoxDriver
        WebDriverManager.firefoxdriver().setup();

        // Initialize the FirefoxDriver
        driver = new FirefoxDriver();
    }
    @Test
    public void testLogin() {
        // Open the login page
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Find the username and password input fields and the login button
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("submit"));

        // Enter the username and password and click login
        usernameField.sendKeys("student");
        passwordField.sendKeys("Password123");
        loginButton.click();

        // Verify the new page URL
        assertTrue(driver.getCurrentUrl().contains("practicetestautomation.com/logged-in-successfully/"));

        // Verify the new page contains the expected text
        WebElement successMessage = driver.findElement(By.tagName("h1"));
        assertEquals(true, successMessage.getText().contains("Congratulations"));

        // Verify the Logout button is displayed
        WebElement logoutButton = driver.findElement(By.xpath("//a[text()='Log out']"));
        assertTrue(logoutButton.isDisplayed());
    }
    @AfterEach
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
