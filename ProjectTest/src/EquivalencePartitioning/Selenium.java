package EquivalencePartitioning;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.remote.ErrorCodes.TIMEOUT;

public class Selenium {
    private WebDriver driver;
    private final String EXE_PATH = "C:\\Users\\ABRA\\IdeaProjects\\chromedriver.exe";
    private final String WEBSITE = "https://www.trendyol.com/sr?wc=1208";
    private Actions actionProvider;
    private String testCases[]={
            "0","1","0","299","0","300"
            ,"300","301","300","599","300","800"
            ,"800","801","800","1499","800","1500"
            ,"1500","1501","1500","8999","1500","9000"
            ,"9000","9001","9000","99999","9000","100000"
            ,"100000","110000"
    };
    public Selenium() {
        System.setProperty("webdriver.chrome.driver", EXE_PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--whitelisted-ips=''");
        driver = new ChromeDriver(options);
    }
    public boolean checkFirst()
    {  boolean a;
        try {
        driver.findElement(By.className("fltr-srch-prc-rng"));
        a = false;
    } catch (NoSuchElementException e){
           a = true;
        }
        return a;
    }
    public void sendKeys() throws InterruptedException {
        actionProvider = new Actions(driver);
        int i=0;

        while (testCases!=null){
            if (checkFirst()==true)
            {
                WebElement price2 = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                        .until(driver -> driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[2]/div/div/div/div[1]/div[1]/div/div/div[4]/div[1]")));
                actionProvider.click(price2).build().perform();
                Thread.sleep(1000);
            }

            WebElement minPriceArea = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                    .until(driver -> driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[2]/div/div/div/div[1]/div[1]/div/div/div[4]/div[2]/div/input[1]")));
            actionProvider.sendKeys(minPriceArea, testCases[i]).build().perform();
            Thread.sleep(1000);
            WebElement maxPriceArea = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                    .until(driver -> driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[2]/div/div/div/div[1]/div[1]/div/div/div[4]/div[2]/div/input[2]")));
            actionProvider.sendKeys(maxPriceArea, testCases[i + 1]).build().perform();
            Thread.sleep(1000);
            WebElement intervalSearch = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                    .until(driver -> driver.findElement(By.className("fltr-srch-prc-rng-srch")));
            actionProvider.click(intervalSearch).build().perform();
            Thread.sleep(1000);
            driver.navigate().back();
            Thread.sleep(1000);
            i=i+2;
        }
    }

    public void connect() {
        driver.get(WEBSITE);
    }

    public void quit() {
        driver.quit();
    }

}