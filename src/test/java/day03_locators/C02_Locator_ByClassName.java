package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class C02_Locator_ByClassName {

    public static void main(String[] args) throws InterruptedException {

        //1- Bir test class’i olusturun ilgili ayarlari yapin

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- https://www.testotomasyonu.com adresine gidin
        driver.get("https://www.testotomasyonu.com");

        //3- urun arama kutusunu locate edin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));


        //4- arama kutusuna “dress” yazdirin

        aramaKutusu.sendKeys("dress");
        Thread.sleep(1000);

        //5- arama islemini yapabilmek icin ENTER tusuna basin

        aramaKutusu.submit();
        Thread.sleep(1000);
        // 6- arama sonucunda urun bulunabildigini test edin

        List<WebElement> bulunanUrunElementleriList =
                driver.findElements(By.className("prod-img"));

        int actualUrunSayisi = bulunanUrunElementleriList.size();

        if (actualUrunSayisi>0){
            System.out.println("Urun bulma testi PASSED");
        }else System.out.println("Urun bulma testi FAILED");




        Thread.sleep(1000);
        driver.quit();

    }
}
