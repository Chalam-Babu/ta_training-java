package com.epam.training.chalamBabu_battula.task3;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EstimateSummaryPage extends BasePage {

    @FindBy(xpath = "//h3[contains(text(),'Instances')]")
    private WebElement summaryTitle;

    @FindBy(xpath = "//div[text()='Provisioning Model']/following-sibling::div[@class='EWphe HY0Uh']")
    private WebElement vmClass;

    @FindBy(xpath = "//div[text()='Machine type']/following-sibling::div[@class='EWphe HY0Uh']")
    private WebElement instanceType;

    @FindBy(xpath = "//div[text()='Region']/following-sibling::div[@class='EWphe HY0Uh']")
    private WebElement region;

    @FindBy(xpath = "//div[text()='Local SSD']/following-sibling::div[@class='EWphe HY0Uh']")
    private WebElement localSSD;

    @FindBy(xpath = "//div[text()='Committed use discount options']/following-sibling::div[@class='EWphe HY0Uh']")
    private WebElement commitmentTerm;

    @FindBy(xpath = "//b[contains(text(),'Total Estimated Cost')]")
    private WebElement totalCost;

    public EstimateSummaryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isInstancesDisplayed() {
        return summaryTitle.isDisplayed();
    }

    public String getVmClass() {
        return getText(vmClass);
    }

    public String getInstanceType() {
        return getText(instanceType);
    }

    public String getRegion() {
        return getText(region);
    }

    public String getLocalSSD() {
        return getText(localSSD);
    }

    public String getCommitmentTerm() {
        return getText(commitmentTerm);
}

}
