package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class C02_driverGetMethodlari {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.testotomasyonu.com");

        System.out.println(driver.getTitle()); // Test Otomasyonu - Test Otomasyonu

        System.out.println(driver.getCurrentUrl()); //  https://www.testotomasyonu.com/

        System.out.println(driver.getWindowHandle()); // 472b2bee-9e2f-41ca-88fc-5e5eccff3877
        // acilan window'un unique window handle degerini getirir
        /*
            Window Handle degeri Selenium tarafindan olusturulan
            her Window'a verilen unique bir degerdir

            her calistiginda yeni ve farkli bir deger uretir

            EGER test calisirken birden fazla window acilirsa
            bu window'lar arasinda gecis yapmak icin
            window handle degeri kullanilir
         */

        System.out.println(driver.getWindowHandles());
        // birden fazla window acilirsa
        // acilan tum window'larin window handle degerlerini bir Set olarak getirir
        // [472b2bee-9e2f-41ca-88fc-5e5eccff3877]


        System.out.println(driver.getPageSource());



        Thread.sleep(2000);
        driver.quit();
    }
}
