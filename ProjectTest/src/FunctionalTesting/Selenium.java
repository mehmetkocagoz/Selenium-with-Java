package FunctionalTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Selenium {
    private WebDriver driver;
    private WebDriverWait wait;
    private final String EXE_PATH = "C:\\Users\\ABRA\\IdeaProjects\\chromedriver.exe";
    private final String WEBSITE = "https://www.trendyol.com/uyelik";
    private final String email ="testmehmetkcgz@outlook.com";
    private String testCases[]={"asdasd","Asdas1","asdasda","asdasdasdasdasd","Asdasdasdasdasd1","Asdasda1"};
    private Actions actionProvider;

    public Selenium() {

        System.setProperty("webdriver.chrome.driver", EXE_PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--whitelisted-ips=''");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

        public void sendKeys() throws InterruptedException {

        int i=0;
        WebElement emailInput = driver.findElement(By.id("register-email"));
        WebElement password = driver.findElement(By.id("register-password-input"));
        emailInput.sendKeys(email);

        while(testCases != null){
            password.sendKeys(testCases[i]);
            password.submit();
            Thread.sleep(5000);
            password.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
            i++;
        }
        }

        public void connect() {
            driver.get(WEBSITE);
        }

        public void quit() {
            driver.quit();
        }
    }