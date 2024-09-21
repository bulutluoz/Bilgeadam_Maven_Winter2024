package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class C01_Locators_ById {

    public static void main(String[] args) throws InterruptedException {

        //1- Bir test class’i olusturun ilgili ayarlari yapin

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- https://www.testotomasyonu.com adresine gidin
        driver.get("https://www.testotomasyonu.com");

        //3- urun arama kutusunu locate edin

        // WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        WebElement aramaKutusu = driver.findElement(By.name("search"));

        //4- arama kutusuna “shoe” yazdirin

        aramaKutusu.sendKeys("shoe");
        Thread.sleep(1000);

        //5- arama islemini yapabilmek icin ENTER tusuna basin

        aramaKutusu.submit();
        Thread.sleep(1000);
        // 6- arama sonucunda urun bulunabildigini test edin

        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

        System.out.println(aramaSonucElementi.getText()); // 4 Products Found

        String aramaSonucuYazisi = aramaSonucElementi.getText(); // 4 Products Found

        aramaSonucuYazisi = aramaSonucuYazisi.replaceAll("\\D","");  // "4"

        int bulunanUrunAdedi = Integer.parseInt(aramaSonucuYazisi);// sayisal 4

        if (bulunanUrunAdedi>0){
            System.out.println("Urun adedi testi PASSED");
        } else System.out.println("Urun adedi testi FAILED");

        Thread.sleep(2000);
        driver.quit();
    }
}
