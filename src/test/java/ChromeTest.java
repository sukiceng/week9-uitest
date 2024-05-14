import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTest {
    @Test
    public void test(){
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        System.out.println(title);

        driver.quit();
    }
}
