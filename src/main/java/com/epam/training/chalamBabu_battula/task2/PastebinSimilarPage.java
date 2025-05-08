package com.epam.training.chalamBabu_battula.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PastebinSimilarPage {
    private WebDriver driver;

    private By codeTextarea = By.id("code");
    private By dropdown = By.id("lang");
    private By title = By.id("description");
    private By submitButton = By.cssSelector("input.button.big.icon.add[value='Submit']");
    private By pageTitleHeader=By.xpath("//div[@class='hl-wrap']/following-sibling::div/p");
    private By codeDescription=By.xpath("//ol[@class='highlight code']");


    public PastebinSimilarPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCode(String code) {
        WebElement textArea = driver.findElement(codeTextarea);
        textArea.sendKeys(code);
    }

    public void selectLanguage() {
        driver.findElement(dropdown).click();
        WebElement option = driver.findElement(By.xpath("//option[@value='java']"));
        option.click();
    }

    public void enterTitle(String titel){
        WebElement textArea = driver.findElement(title);
        textArea.sendKeys(titel);
    }
    public void submitPaste() {
        WebElement submit = driver.findElement(submitButton);
        submit.click();
    }

    public String getPageTitle()
    {
        return driver.findElement(pageTitleHeader).getText();
    }

    public String getCodeBody()
    {
        return driver.findElement(codeDescription).getText();
    }




}