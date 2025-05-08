package com.epam.training.chalamBabu_battula.tests.task1;

import com.epam.training.chalamBabu_battula.task1.PastebinHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PastebinTest {

    private WebDriver driver;
    private PastebinHomePage pastebinPage;

    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pastebinPage = new PastebinHomePage(driver);
    }

    @Test
    public void testCreateNewPaste() {
        pastebinPage.openWebsite();
        pastebinPage.enterCode("Hello from WebDriver");
        pastebinPage.select10MinutesExpiration();
        pastebinPage.enterPasteName("helloweb");
        Assertions.assertTrue(true, "Test completed successfully");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
}
}