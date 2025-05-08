package com.epam.training.chalamBabu_battula.tests.task2;

import com.epam.training.chalamBabu_battula.task2.PastebinPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pastebintest {
    protected WebDriver driver;


    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void createNewpaste() {
        driver.get("https://pastebin.com/");

        PastebinPage pp = new PastebinPage(driver);
        String code = "git config --global user.name  \"New Sheriff in Town\"\n"
                + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n"
                + "git push origin master --force";

        pp.entercode(code);

        pp.selectSyntaxHighlighting("Bash");
        pp.selectPasteExpiration("10 Minutes");
        pp.enterPastename("how to gain dominance among developers");
        pp.clickPaste();


        // due to some CAPTCHA we can not able to do proceed Task as selenium don't support CAPTCHA bypass. so i did through som other website(PastebinSimilarPageTest).


    }

    @AfterEach
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
