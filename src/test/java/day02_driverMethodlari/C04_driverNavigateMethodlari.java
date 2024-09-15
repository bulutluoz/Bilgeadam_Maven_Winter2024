package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class C04_driverNavigateMethodlari {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://www.testotomasyonu.com");
        Thread.sleep(1000);

        // ayni window'da bestbuy.com'a gidin
        driver.navigate().to("https://www.bestbuy.com");
        Thread.sleep(1000);

        // tekrar testotomasyonu sayfasina donun
        driver.navigate().back();
        Thread.sleep(1000);

        // bir daha bestbuy.com'a gidin
        driver.navigate().forward();
        Thread.sleep(1000);

        // sayfayi yenileyin
        driver.navigate().refresh();

        Thread.sleep(2000);
        driver.quit();
    }
}
