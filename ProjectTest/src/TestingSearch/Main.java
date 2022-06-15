package TestingSearch;



public class Main {
    public static void main(String[] args) throws InterruptedException {
        TestingSearch.Selenium selenium = new Selenium();
        selenium.connect();
        selenium.sendKeys();
        selenium.storeData();
        selenium.quit();
    }
}
