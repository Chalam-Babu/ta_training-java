package com.epam.training.chalamBabu_battula.task3;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(xpath = "//div[@class='YSM5S']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@jsname='YPqjbf']")
    private WebElement searchInput;

    @FindBy(xpath = "//a[contains(text(),'Google Cloud Pricing Calculator')]")
    private WebElement calculatorResult;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://cloud.google.com/");
    }

    public void searchForCalculator() {
        click(searchButton);
        type(searchInput, "Google Cloud Platform Pricing Calculator");
        searchInput.submit();
    }

    public void openCalculator() {
        click(calculatorResult);
}
}
