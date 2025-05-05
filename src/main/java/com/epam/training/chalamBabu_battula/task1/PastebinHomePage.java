package com.epam.training.chalamBabu_battula.task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PastebinHomePage {
    private WebDriver driver;

    private By codeArea = By.id("postform-text");
    private By pasteExpiration = By.id("select2-postform-expiration-container");
    private By expirationOption = By.xpath("//li[text()='10 Minutes']");
    private By titleField = By.id("postform-name");
    private By submitButton = By.xpath("//button[text()='Create New Paste']");

    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://pastebin.com/");
    }

    public void enterCode(String code) {
        driver.findElement(codeArea).sendKeys(code);
    }

    public void selectExpiration() {
        driver.findElement(pasteExpiration).click();
        driver.findElement(expirationOption).click();
    }

    public void enterTitle(String title) {
        driver.findElement(titleField).sendKeys(title);
    }

    public void createPaste() {
        driver.findElement(submitButton).click();
    }
}
