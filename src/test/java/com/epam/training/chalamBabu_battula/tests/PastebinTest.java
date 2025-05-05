package com.epam.training.chalamBabu_battula.tests;

import com.epam.training.chalamBabu_battula.task1.PastebinHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PastebinTest {

    private WebDriver driver;
    private PastebinHomePage pastebin;

    @BeforeAll
    public void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void init() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pastebin = new PastebinHomePage(driver);
    }

    @Test
    public void testCreateNewPaste() {
        pastebin.open();
        pastebin.enterCode("Hello from WebDriver");
        pastebin.selectExpiration();
        pastebin.enterTitle("helloweb");
        pastebin.createPaste();

        assertTrue(driver.getTitle().contains("helloweb"), "Paste title not found in page title.");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
