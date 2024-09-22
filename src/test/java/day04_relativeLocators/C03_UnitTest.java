package day04_relativeLocators;

import java.util.Random;

public class C03_UnitTest {

    public static void main(String[] args) {

        // verilen iki sayiyi toplayip, sonucu donduren bir method olusturun

        // verilen sayi cift ise true,
        // tek ise false donduren bir method olusturun

        System.out.println(ciftMi(20)); // true
        System.out.println(ciftMi(43)); // false

        // random olarak 10 tane sayi uretip
        // her sayi icin ciftMi method'un calistiran
        // ve sonuclarin dogru oldugunu kontrol eden bir Test method'u olusturun

        ciftMiTestMethodu();

    }

    public static boolean ciftMi(int sayi){

        if (sayi%2 == 0) {
            return true;
        }else return false;
    }

    public static void ciftMiTestMethodu(){

        boolean testSonucu = true;

        Random random = new Random();

        for (int i = 1; i <=10 ; i++) {

            int randomSayi = random.nextInt(100);

            boolean sayiCiftMi = randomSayi%2==0 ? true : false ;

            if (sayiCiftMi != ciftMi(randomSayi)){
                testSonucu = false;
            }
        }

        if (testSonucu==true){
            System.out.println("CiftMi method testi PASSED");
        } else System.out.println("CiftMi method testi FAILED");


    }



}
