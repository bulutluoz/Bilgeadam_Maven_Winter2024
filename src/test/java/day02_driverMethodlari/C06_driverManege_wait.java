package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class C06_driverManege_wait {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Selenium kod calisirken olusmasi muhtemel zaman kayiplarini telafi etmek icin
        // DINAMIK bekleme kodlari olusturmustur.
        // dinamik bekleme, sure odakli degil gorev odakli bekleme demektir
        // amac bir gorevin gerceklesmesini beklemek,
        // gorev gerceklesir gerceklesmez (mumkun olan en kisa surede)hemen yolumuza devam etmektir

        // implicitly wait ile yazdigimiz 10 saniye
        // mutlak bekleme suresi degil
        // gorevin gerceklesmesi icin bekleyecegimiz max suredir
        // bu gorev sayfanin yuklenmesi veya bir webelementin kullanilabilir hale gelmesidir

        driver.get("https://www.testotomasyonu.com");
        Thread.sleep(3000);


        System.out.println(driver.getTitle());



        Thread.sleep(3000);
        driver.quit();

    }
}
