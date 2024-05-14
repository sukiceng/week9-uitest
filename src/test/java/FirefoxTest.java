import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirefoxTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
    @Test
    public void testOpenSVUGMWebsiteAndMenus() {
        List<String> urls = Arrays.asList(
                "https://sv.ugm.ac.id/",
                "https://sv.ugm.ac.id/profil/",
                "https://sv.ugm.ac.id/pendidikan/",
                "https://sv.ugm.ac.id/p2mks/penelitian/",
                "https://sv.ugm.ac.id/p2mks/pengabdian/",
                "https://sv.ugm.ac.id/jurnal/",
                "https://sv.ugm.ac.id/center-of-excellence-2/",
                "https://sv.ugm.ac.id/kerja-sama/kerja-sama-dalam-negeri/",
                "https://sv.ugm.ac.id/kerja-sama/kerja-sama-luar-negeri/",
                "https://sv.ugm.ac.id/pendaftaran/",
                "https://sv.ugm.ac.id/informasi-publik/"
        );
        // Expected Result
        List<String> expectedTitles = Arrays.asList(
                "Sekolah Vokasi UGM – Sekolah Vokasi UGM",
                "Profil – Sekolah Vokasi UGM",
                "Pendidikan – Sekolah Vokasi UGM",
                "Penelitian – Sekolah Vokasi UGM",
                "Pengabdian – Sekolah Vokasi UGM",
                "Jurnal – Sekolah Vokasi UGM",
                "Center of Excellence – Sekolah Vokasi UGM",
                "Kerja Sama Dalam Negeri – Sekolah Vokasi UGM",
                "Kerja Sama Luar Negeri – Sekolah Vokasi UGM",
                "Pendaftaran – Sekolah Vokasi UGM",
                "Informasi Publik – Sekolah Vokasi UGM"
        );
        for (int i = 0; i < urls.size(); i++) {
            String url = urls.get(i);
            String expectedTitle = expectedTitles.get(i);

            driver.get(url);
            String actualTitle = driver.getTitle();

            System.out.println("Testing URL: " + url);
            System.out.println("Expected Title: " + expectedTitle);
            System.out.println("Actual Title: " + actualTitle);
            assertEquals(expectedTitle, actualTitle, "Title should be" + expectedTitle + "");
        }
    }
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
