package day02_driverMethodlari;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class C05_driverManage_WindowAyarlari {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.testotomasyonu.com");

        System.out.println( "ilk acilista konum : " + driver.manage().window().getPosition()  );
        //ilk acilista konum : (4, 38)
        System.out.println("ilk acilista boyut : " + driver.manage().window().getSize());
        //ilk acilista boyut : (1280, 942)
        Thread.sleep(2000);

        driver.manage().window().maximize();
        System.out.println( "maximize konum : " + driver.manage().window().getPosition()  );
        // maximize konum : (0, 38)
        System.out.println("maximize boyut : " + driver.manage().window().getSize());
        //maximize boyut : (1728, 1047)
        Thread.sleep(2000);

        driver.manage().window().fullscreen();
        System.out.println( "fullscreen konum : " + driver.manage().window().getPosition()  );
        //fullscreen konum : (0, 37)
        System.out.println("fullscreen boyut : " + driver.manage().window().getSize());
        //fullscreen boyut : (1728, 1080)


        // window'u 100,200 noktasinda baslayip
        // boyutu 500,400 olacak sekilde kucultun

        driver.manage().window().setPosition(new Point(100,200));
        driver.manage().window().setSize(new Dimension(500,400));

        System.out.println( "ozel boyut konum : " + driver.manage().window().getPosition()  );
        //ozel boyut konum : (100, 200)
        System.out.println("ozel boyut : " + driver.manage().window().getSize());
        //ozel boyut : (500, 400)

        Thread.sleep(5000);
        driver.quit();

    }
}
