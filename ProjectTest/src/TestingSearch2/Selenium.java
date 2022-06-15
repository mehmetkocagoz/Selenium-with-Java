package TestingSearch2;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    private WebDriverWait wait;
    private final String EXE_PATH = "C:\\Users\\ABRA\\IdeaProjects\\chromedriver.exe";
    private final String WEBSITE = "https://www.trendyol.com/sr?q=laptop";
    private Actions actionProvider;
    private List<Double> prices;


    public Selenium() {
        prices = new ArrayList<>();
        System.setProperty("webdriver.chrome.driver", EXE_PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--whitelisted-ips=''");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void sendKeys() throws InterruptedException {
        Thread.sleep(2500);
        actionProvider = new Actions(driver);
        driver.findElement(By.className("overlay")).click();
        Thread.sleep(2500);
        WebElement brand1 = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(driver -> driver.findElement(By.partialLinkText("Monster")));
        actionProvider.click(brand1).build().perform();
        Thread.sleep(2500);
        WebElement brand2 = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(driver -> driver.findElement(By.partialLinkText("MSI")));
        actionProvider.click(brand2).build().perform();
        Thread.sleep(2500);
        WebElement GPUoption = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(driver -> driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[2]/div/div/div/div[1]/div[1]/div/div/div[7]")));
        actionProvider.click(GPUoption).build().perform();
        Thread.sleep(2500);
        WebElement GPU = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(driver -> driver.findElement(By.partialLinkText("Nvidia GeForce RTX3060")));
        actionProvider.click(GPU).build().perform();
        Thread.sleep(2500);
        Select option = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[1]/div[2]/select")));
        option.selectByIndex(1);
        Thread.sleep(2500);


    }

    public void connect() {
        driver.get(WEBSITE);
    }

    public void quit() {
        driver.quit();
    }
    public void storeData(){

        String price;
        List<WebElement> priceList = driver.findElements(By.className("prc-box-dscntd"));
        for(WebElement p : priceList ){
            price = formatText(p.getText());
            prices.add(Double.parseDouble(price));
            System.out.println(price);
        }
        boolean isSorted=true;
        for (int i=0;i < prices.size()-1;i++){
            if(prices.get(i)>prices.get(i+1)){
                isSorted=false;
            }
        }
        if (isSorted==true){
            System.out.println("Succed!");
        }else {
            System.out.println("Failed!");
        }
    }
    private String formatText(String text) {

        return text.replace(".", "")
                .replace(",", ".")
                .replace(" TL", "");
    }
}
