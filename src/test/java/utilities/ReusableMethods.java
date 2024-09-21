package utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ReusableMethods {

    public static List<String> stringListeDonustur(List<WebElement> elementList){

        List<String> stringList = new ArrayList<>();

        for (WebElement eachElement : elementList) {

            stringList.add(eachElement.getText());
        }

        return stringList;
    }
}
