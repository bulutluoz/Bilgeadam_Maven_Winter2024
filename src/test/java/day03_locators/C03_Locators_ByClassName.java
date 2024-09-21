package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.ReusableMethods;

import javax.print.attribute.standard.RequestingUserName;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C03_Locators_ByClassName {

    public static void main(String[] args) throws InterruptedException {

        //1- Bir test class’i olusturun ilgili ayarlari yapin

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");

        //3- arama kutusuna phone yazip aratin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        aramaKutusu.sendKeys("phone" + Keys.ENTER );

        //4- Category bolumunde 8 element oldugunu test edin
        Thread.sleep(1000);

        List<WebElement> categoryElementleriList = driver.findElements(By.className("panel-list"));
        int expectedKategoriSayisi = 8;
        int actualCategorisayisi = categoryElementleriList.size();

        if (expectedKategoriSayisi == actualCategorisayisi){
            System.out.println("kategori sayisi testi PASSED");
        } else System.out.println("kategori sayisi testi FAILED");

        //5- Category isimlerini yazdirin

        // Liste WebElement'lerden olustugu icin direk yazdiramayiz
        // bir loop ile tum elementleri gozden gecirip
        // getText() ile yazilari alip yazdiralim

        for (WebElement eachElement : categoryElementleriList) {
            System.out.println(eachElement.getText());
        }


        // 6- kategoriler icinde "Shoes" oldugunu test edin



        List<String> kategoriYazilariList = ReusableMethods.stringListeDonustur(categoryElementleriList);

        System.out.println("Kategori isimleri listesi : " + kategoriYazilariList);


        if (kategoriYazilariList.contains("Shoes")){
            System.out.println("Kategori shoes testi PASSED");
        }else System.out.println("Kategori shoes testi FAILED");


        //6- Sayfayi kapatin
        Thread.sleep(3000);
        driver.quit();
    }
}
