package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C05_Xpath {

    public static void main(String[] args) {


        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1- https://testotomasyonu.com/addremove/ adresine gidin
        driver.get("https://testotomasyonu.com/addremove/");
        ReusableMethods.bekle(1);

        //2- Add Element butonuna basin
        driver.findElement(By.id("sub-btn"))
                .click();

        //3- Remove butonu’nun gorunur oldugunu test edin

        WebElement removeButonu = driver.findElement(By.xpath("//*[@*='remove-btn']"));

        if (removeButonu.isDisplayed()){
            System.out.println("Remove buton testi PASSED");
        } else System.out.println("Remove buton testi FAILED");

        //4- Remove tusuna basin
        removeButonu.click();

        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin

        // WebElement addRemoveYaziElementi = driver.findElement(By.tagName("h2"));
        WebElement addRemoveYaziElementi = driver.findElement(By.xpath("//h2"));

        if (addRemoveYaziElementi.isDisplayed()){
            System.out.println("Add Remove Yazi Testi PASSED");
        }else System.out.println("Add Remove Yazi Testi FAILED");

        driver.quit();
    }
}
