package day02_driverMethodlari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class C07_ExternalWebDriverKullanimi {

    public static void main(String[] args) {

        /*
            Selenium kendi WebDriver'ina sahiptir
            ANCAK bazi firmalar guvenlik sebebiyle
            Selenium WebDriver yerine kendi belirledikleri WebDriver'i kullanmanizi isteyebilir

            Bu durumda kullanilacak WebDriver'i kodlarimiza dahil etmeliyiz

            Biz de ornek olarak
            Free olarak olarak kullanabilecegimiz Boni Garcia WebDriver'i projemize ekleyelim

         */

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



    }
}
