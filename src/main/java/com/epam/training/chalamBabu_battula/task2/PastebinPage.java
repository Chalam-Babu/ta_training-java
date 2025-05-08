package com.epam.training.chalamBabu_battula.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PastebinPage extends BasePage {
    private By codeTextArea = By.id("postform-text");
    private By syntsxDroupdown = By.id("select2-postform-format-container");
    private By syntaxInput = By.id("select2-postform-format-result-vo1k-8");

    private By pasteexp = By.id("select2-postform-expiration-container");
    private By pastinput = By.id("select2-postform-expiration-result-zd6q-10M");

    private By pastename = By.id("postform-name");
    private By createPasteButton = By.cssSelector("button[type='submit']");


    public PastebinPage(WebDriver driver ){
        super(driver);

    }

    public void entercode(String code){
        WebElement testArea = driver.findElement(codeTextArea);
        testArea.sendKeys(code);
    }
    public void selectSyntaxHighlighting(String syntax) {
        driver.findElement(By.id("select2-postform-format-container")).click();
        driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(syntax);
        driver.findElement(By.xpath("//li[text()='" + syntax + "']")).click();

    }

    public void selectPasteExpiration(String expiration) {
        driver.findElement(By.id("select2-postform-expiration-container")).click();
        driver.findElement(By.xpath("//li[text()='" + expiration + "']")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void enterPastename(String name){
        driver.findElement(pastename).sendKeys(name);
    }

    public void clickPaste(){
        driver.findElement(createPasteButton).click();
    }




}

