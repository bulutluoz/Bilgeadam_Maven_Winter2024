package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class C01_IlkOtomasyon {


    public static void main(String[] args) {

        // Otomasyon yapacagimiz bir class olusturdugumuzda
        // ilk yapilmasi gereken sey
        // bir WebDriver objesi edinmektir

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.testotomasyonu.com");
        // url yazarken bunun bir String oldugunu yani yanlis yazim olursa
        // istedigimiz url'e gitmeyecegini bilmeliyiz
        // www yazmak sart degildir ama https:// yazmak ZORUNLUDUR




        // driver.close(); // test sirasinda kullandigimiz window'u kapatir
                           // test sirasinda birden fazla window acildi ise son kullandigini kapatir
        driver.quit();  // test sirasinda acilan tum window'lari kapatir

    }
}
