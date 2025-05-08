package com.epam.training.chalamBabu_battula.tests.task2;

import com.epam.training.chalamBabu_battula.task2.PastebinSimilarPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class PastebinSimilarPageTest {
    private WebDriver driver;
    private PastebinSimilarPage pastebinSPage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pastebinSPage = new PastebinSimilarPage(driver);
    }

    @Test
    public void createNewPostSimilar() {
        driver.get("https://paste2.org/");

        String pasteCode = "git config --global user.name  \"New Sheriff in Town\"\n"
                + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n"
                + "git push origin master --force";


        pastebinSPage.enterCode(pasteCode);
        pastebinSPage.selectLanguage();
        String title = "how to gain dominance among developers";
        pastebinSPage.enterTitle(title);
        pastebinSPage.submitPaste();
        assertEquals(pastebinSPage.getPageTitle(),title);
        assertTrue(pastebinSPage.getCodeBody().contains("New Sheriff in Town"));
        assertTrue(pastebinSPage.getCodeBody().contains("git push origin master --force"));

    }
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}