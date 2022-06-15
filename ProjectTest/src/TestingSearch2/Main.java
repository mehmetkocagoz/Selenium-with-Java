package TestingSearch2;



public class Main {
    public static void main(String[] args) throws InterruptedException {
        Selenium selenium = new Selenium();
        selenium.connect();
        selenium.sendKeys();
        selenium.storeData();
        selenium.quit();
    }
}
