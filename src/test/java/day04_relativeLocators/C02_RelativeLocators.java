package day04_relativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_RelativeLocators {

    public static void main(String[] args) {

        //1 ) https://testotomasyonu.com/relativeLocators adresine gidin
        //2 ) DSLR Camera’yi  etrafindaki elementleri kullanarak 3 farkli relative locator ile locate edip tiklayin
        //3 ) Acilan urunun DSLR Camera oldugunu test edin.


        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testotomasyonu.com/relativeLocators");

        ReusableMethods.bekle(1);
        // DSLR camerayi tiklayin

        driver.findElement(By.id("pic7_thumb"))
                .click();
        ReusableMethods.bekle(1);
        // acilan sayfada isminin DSLR Camera oldugunu test edin

        WebElement urunIsimElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String expectedUrunIsmi = "DSLR Camera";
        String actualUrunIsmi = urunIsimElementi.getText();

        if (expectedUrunIsmi.equals(actualUrunIsmi)){
            System.out.println("DSLR direkt kullanim testi PASSED");
        } else System.out.println("DSLR direkt kullanim testi FAILED");


        ReusableMethods.bekle(1);
        // Ornek olarak....
        // DSLR camera elementini direkt kullanamadigimizi dusunelim
        // ve Relative Locator ile locate edelim

        driver.get("https://testotomasyonu.com/relativeLocators");
        ReusableMethods.bekle(1);
        // relative locator kullanabilmek icin, 2 seye ihtiyacimiz var
        // 1- DSLR cameranin locate edebilecegimiz bir ozelligi
        //    bu ornekte id = pic7_thumb

        // 2- DSLR camera etrafinda kullanabilecegimiz baska bir WebElement

        WebElement appleKulaklik = driver.findElement(By.id("pic6_thumb"));
        WebElement motorTelefon = driver.findElement(By.id("pic8_thumb"));


        WebElement dslrRelative = driver.findElement(RelativeLocator.with(By.id("pic7_thumb"))
                                                                    .toRightOf(appleKulaklik)
                                                                    .toLeftOf(motorTelefon));
        dslrRelative.click();
        ReusableMethods.bekle(1);

        // bu DSLR Camera sayfasina 2.gelisimiz
        // 1.gelisimizde isim elementini locate etmistik
        // 2.gelisimizde isim elementi HTML kod olarak ayni olsa da
        //  locate isleminden sonra sayfa degisiklikleri yapildigindan
        //  Selenium o locate'in eski sayfalara ait oldugunu
        //  "StaleElementReferenceException" ile soyler.
        //  sayfa degisikligi yapilan bir elementi
        //  tekrar kullanmamiz gerekirse yeniden WebElement olusturmaya gerek olmaz
        //  ANCAKKK bir daha locate etmemize gereklidir

        urunIsimElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));
        actualUrunIsmi = urunIsimElementi.getText();
        // StaleElementReferenceException

        if (expectedUrunIsmi.equals(actualUrunIsmi)){
            System.out.println("DSLR relative kullanim testi PASSED");
        } else System.out.println("DSLR relative kullanim testi FAILED");




        ReusableMethods.bekle(3);
        driver.quit();

    }
}
