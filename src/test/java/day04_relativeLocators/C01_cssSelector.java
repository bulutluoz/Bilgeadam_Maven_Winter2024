package day04_relativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_cssSelector {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //2-  https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");
        //3-  Browseri tam sayfa yapin
        driver.manage().window().maximize();
        //4-  Sayfayi “refresh” yapin
        driver.navigate().refresh();
        //5-  Sayfa basliginin “Test Otomasyonu” ifadesi icerdigini test edin
        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Title testi PASSED");
        }else System.out.println("Title testi FAILED");

        //6-  Furniture linkine tiklayin
        ReusableMethods.bekle(1);
        driver.findElement(By.xpath("(//a[text()='Furniture'])[3]"))
                .click();


        // Actions actions = new Actions(driver);
        // actions.sendKeys(Keys.PAGE_DOWN).perform();

        //7-  price range filtresinde min degere 40, max degere 200 yazip filtreleyin

        WebElement minKutusu = driver.findElement(By.cssSelector("input[name='min']"));
        WebElement maxKutusu = driver.findElement(By.cssSelector("input[name='max']"));
        WebElement filtreleButonu = driver.findElement(By.cssSelector("button[name='button']"));

        minKutusu.clear();
        minKutusu.sendKeys("40");

        maxKutusu.clear();
        maxKutusu.sendKeys("200");
        ReusableMethods.bekle(3);

        filtreleButonu.click();
        //8-  filtreleme sonucunda urun bulunabildigini test edin

        WebElement sonucYaziElementi = driver.findElement(By.className("product-count-text"));

        String unExpectedResult = "0 Products Found";
        String actualResult = sonucYaziElementi.getText();

        if ( !unExpectedResult.equals(actualResult)){
            System.out.println("Urun filtreleme testi PASSED");
        } else System.out.println("Urun filtreleme testi FAILED");
        ReusableMethods.bekle(1);
        //10-Ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@class='product-box mb-2 pb-1'])[1]"))
                .click();

        //11- Urun fiyatinin 40 ile 200 arasinda oldugunu test edin

        WebElement fiyatElementi = driver.findElement(By.id("priceproduct"));

        String fiyatStr = fiyatElementi.getText();// "$50.00"

        fiyatStr = fiyatStr.replace("$",""); // "50.00"

        Double fiyatDbl = Double.parseDouble(fiyatStr); // 50.00

        if (fiyatDbl>=40 && fiyatDbl <=200){
            System.out.println("urun fiyat testi PASSED");
        }else System.out.println("urun fiyat testi FAILED");


        //12-Sayfayi kapatin
        ReusableMethods.bekle(3);
        driver.quit();
    }
}
