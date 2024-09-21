package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C04_Locators_ByLinkText {

    public static void main(String[] args) {

        //1- Bir test class’i olusturun ilgili ayarlari yapin


        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- https://www.automationexercise.com/ adresine gidin

        driver.get("https://www.automationexercise.com/");

        ReusableMethods.bekle(1);
        // cookies kabul edin
        driver.findElement(By.xpath("//p[text() = 'Consent']"))
                .click();

        //3- Sayfada 147 adet link bulundugunu test edin.

        //  link'lerin ortak ozelligi tag isimlerinin a olmasidir

        List<WebElement> linkElementleriList = driver.findElements(By.tagName("a"));

        int expectedLinkSayisi = 147;
        int actualLinkSayisi = linkElementleriList.size();

        if (expectedLinkSayisi == actualLinkSayisi){
            System.out.println("Link sayisi testi PASSED");
        }else System.out.println("Link sayisi testi FAILED");

        //4- Products linkine tiklayin

        //driver.findElement(By.linkText(" Products")).click();

        driver.findElement(By.partialLinkText("oducts"))
                .click();


        //5- special offer yazisinin gorundugunu test edin
        WebElement specialOfferElementi = driver.findElement(By.id("sale_image"));

        if (specialOfferElementi.isDisplayed()){
            System.out.println("Special offer yazi Testi PASSED");
        }else System.out.println("Special offer yazi Testi FAILED");


        //6- Sayfayi kapatin

        ReusableMethods.bekle(3);
        driver.quit();
    }
}
