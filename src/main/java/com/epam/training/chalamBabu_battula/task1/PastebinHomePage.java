package com.epam.training.chalamBabu_battula.task1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PastebinHomePage extends BasePage {

    @FindBy(id = "postform-text")
    private WebElement codeTextArea;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement expirationDropdown;

    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement tenMinutesOption;

    @FindBy(id = "postform-name")
    private WebElement pasteNameInput;

    public PastebinHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openWebsite() {
        driver.get("https://pastebin.com");
    }

    public void enterCode(String code) {
        enterText(codeTextArea, code);
    }

    public void select10MinutesExpiration() {
        clickElement(expirationDropdown);
        clickElement(tenMinutesOption);
    }

    public void enterPasteName(String name) {
        enterText(pasteNameInput,name);
    }
}