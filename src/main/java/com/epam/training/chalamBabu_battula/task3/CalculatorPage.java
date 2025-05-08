package com.epam.training.chalamBabu_battula.task3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage extends BasePage {

    @FindBy(xpath = "//span[text()='Add to estimate']")
    private WebElement addToEstimateButton;

    @FindBy(xpath = "//h2[text()='Compute Engine']")
    private WebElement computeEngineButton;

    @FindBy(xpath = "//input[@value='1']")
    private WebElement instancesInput;


    @FindBy(xpath = "//div[@placeholder-id='ucc-24']")
    private WebElement osDropdown;
    private final String osOption="//div[@placeholder-id='ucc-24']/descendant::span[text()='%s']";

    @FindBy(xpath = "//div[@aria-controls='c35']")
    private WebElement machineFamilyDropdown;
    private final String machineFamilyOption="//ul[@class='W7g1Rb-rymPhb O68mGe-hqgu2c']//span[text()='%s']";

    @FindBy(xpath = "//div[@aria-controls='c36']")
    private WebElement seriesDropdown;
    private final String seriesOption= "//ul[@class='W7g1Rb-rymPhb O68mGe-hqgu2c']//span[text()='%s']";


    @FindBy(xpath = "//span[text()='Machine type']//following::span[@class='rHGeGc-uusGie-fmcmS']")
    private WebElement machineTypeDropdown;
    private final String machineTypeOption="//ul[@class='W7g1Rb-rymPhb O68mGe-hqgu2c']//span[text()='%s']";

    @FindBy(xpath = "//button[@aria-label='Add GPUs']")
    private WebElement addGPUButton;
    @FindBy(xpath = "//span[text()='GPU Model']//following::span[@class='rHGeGc-uusGie-fmcmS']")
    private WebElement gpuTypeDropdown;
    private final String gpuTypeOption="//ul[@class='W7g1Rb-rymPhb O68mGe-hqgu2c']//span[text()='%s']";


    @FindBy(xpath = "//span[text()='Number of GPUs']//following::span[@class='rHGeGc-uusGie-fmcmS']")
    private WebElement numberOfGpusDropdown;
    private final String numberOfGpusOption= "//ul[@class='W7g1Rb-rymPhb O68mGe-hqgu2c']//span[text()='%s']";


    @FindBy(xpath = "//span[text()='Local SSD']//following::span[@class='rHGeGc-uusGie-fmcmS']")
    private WebElement localSsdDropdown;
    private final String localSsdOption= "//ul[@class='W7g1Rb-rymPhb O68mGe-hqgu2c']//span[text()='%s']";


    @FindBy(xpath = "//span[text()='Region']//following::span[@class='rHGeGc-uusGie-fmcmS']")
    private WebElement datacenterDropdown;
    private final String datacenterOption="//ul[@class='W7g1Rb-rymPhb O68mGe-hqgu2c']//span[text()='%s']";

    private final String year= "//label[text()='%s']";

    @FindBy(xpath = "//div[text()='Compute']//following-sibling::label")
    private WebElement totalCost;

    @FindBy(id = "share-link")
    private WebElement shareButton;

    @FindBy(xpath = "//i[text()='more_vert']")
    private WebElement ellipseButton;

    @FindBy(xpath = "//span[text()='View details']")
    private WebElement viewDetailsButton;

    public CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectComputeEngine() {
        click(computeEngineButton);
    }

    public void fillCalculatorForm() throws InterruptedException {

        type(instancesInput, "4");

        jsClick(osDropdown);
        Thread.sleep(2000);
        jsClickWithDynamicXPath(osOption,"Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)");

        jsClick(machineFamilyDropdown);
        Thread.sleep(2000);
        jsClickWithDynamicXPath(machineFamilyOption,"General Purpose");


        jsClick(seriesDropdown);
        Thread.sleep(2000);
        jsClickWithDynamicXPath(seriesOption,"N1");


        jsClick(machineTypeDropdown);
        Thread.sleep(2000);
        jsClickWithDynamicXPath(machineTypeOption,"n1-standard-8");

        jsClick(addGPUButton);
        Thread.sleep(2000);
        jsClick(gpuTypeDropdown);
        Thread.sleep(2000);
        jsClickWithDynamicXPath(gpuTypeOption,"NVIDIA V100");

        jsClick(numberOfGpusDropdown);
        Thread.sleep(2000);
        jsClickWithDynamicXPath(numberOfGpusOption,"1");


        jsClick(localSsdDropdown);
        Thread.sleep(2000);
        jsClickWithDynamicXPath(localSsdOption,"2x375 GB");


        jsClick(datacenterDropdown);
        Thread.sleep(2000);
        jsClickWithDynamicXPath(datacenterOption,"Iowa (us-central1)");


        jsClickWithDynamicXPath(year,"1 year");
        Thread.sleep(2000);

    }

    public void clickOnAddEstimateButton()
    {
        click(addToEstimateButton);
    }

    public void clickOnViewDetails() throws InterruptedException {
        Thread.sleep(2000);
        jsClick(ellipseButton);
        jsClick(viewDetailsButton);
    }

    public String getTotalCost() {
        return getText(totalCost);
    }

    private void jsClickWithDynamicXPath(String xpathTemplate, String dynamicValue) {
        String dynamicXPath = String.format(xpathTemplate, dynamicValue);
        WebElement element = driver.findElement(By.xpath(dynamicXPath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
}

}
