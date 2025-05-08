package com.epam.training.chalamBabu_battula.tests.task3;


import com.epam.training.chalamBabu_battula.task3.CalculatorPage;
import com.epam.training.chalamBabu_battula.task3.EstimateSummaryPage;
import com.epam.training.chalamBabu_battula.task3.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

public class CloudCalculatorTest {
    private WebDriver driver;
    private MainPage mainPage;
    private CalculatorPage calculatorPage;
    private EstimateSummaryPage estimateSummaryPage;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
    }

    @Test
    void testCloudCalculatorEstimation() throws InterruptedException {
        mainPage.open();
        mainPage.searchForCalculator();
        mainPage.openCalculator();
        calculatorPage = new CalculatorPage(driver);
        calculatorPage.clickOnAddEstimateButton();
        calculatorPage.selectComputeEngine();
        calculatorPage.fillCalculatorForm();
        String estimatedCost = calculatorPage.getTotalCost();
        assertTrue(estimatedCost.contains("$"), "Estimated cost should be in USD");
        calculatorPage.clickOnViewDetails();

        estimateSummaryPage=new EstimateSummaryPage(driver);

        assertTrue(estimateSummaryPage.getVmClass().contains("Regular"),"Machine Family should be Regular");
        assertTrue(estimateSummaryPage.getInstanceType().contains("n1-standard-8"),"Machine t=Type should be n1-standard-8 ");
        assertTrue(estimateSummaryPage.getRegion().contains("Iowa (us-central1)"),"Region should be Iowa (us-central1)");
        assertTrue(estimateSummaryPage.getLocalSSD().contains("2x375 GB"),"Local SSD should be 2x375 GB");
        assertTrue(estimateSummaryPage.getCommitmentTerm().contains("1 year"),"Commited message should be 1 year");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
