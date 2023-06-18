package com.loop.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PizzaOrderWebTableUtils {
    public static String returnAnyFieldValue(WebDriver driver, String name, String field){
      /*
      String index = (field.equalsIgnoreCase("Pizza Type")) ? "[1]"
        : (field.equalsIgnoreCase("Amount")) ? "[2]"
        : (field.equalsIgnoreCase("Date")) ? "[3]"
        : (field.equalsIgnoreCase("Street")) ? "[4]"
        : (field.equalsIgnoreCase("City")) ? "[5]"
        : (field.equalsIgnoreCase("State")) ? "[6]"
        : (field.equalsIgnoreCase("Zip")) ? "[7]"
        : (field.equalsIgnoreCase("Card")) ? "[8]"
        : (field.equalsIgnoreCase("Card Number")) ? "[9]"
        : (field.equalsIgnoreCase("Exp")) ? "[10]"
        : (System.out.println("There is no such field: " + field), "") ;

System.out.println(index);
       */
        String index = "";

        if (field.equalsIgnoreCase("Pizza Type")){
            index = "[1]";
        } else if (field.equalsIgnoreCase("Amount")) {
            index = "[2]";
        } else if (field.equalsIgnoreCase("Date")) {
            index = "[3]";
        } else if (field.equalsIgnoreCase("Street")) {
            index = "[4]";
        } else if (field.equalsIgnoreCase("City")){
            index = "[5]";
        } else if (field.equalsIgnoreCase("State")) {
            index = "[6]";
        } else if (field.equalsIgnoreCase("Zip")) {
            index = "[7]";
        } else if (field.equalsIgnoreCase("Card")) {
            index = "[8]";
        } else if (field.equalsIgnoreCase("Card Number")) {
            index = "[9]";
        } else if (field.equalsIgnoreCase("Exp")) {
            index = "[10]";
        } else {
            System.out.println("There is not such a field: " + field);
        }
        WebElement element = driver.findElement(By.xpath("//td[.='" + name + "']//following-sibling::td" + index));
        return element.getText();

        /*
        String result = (n == 0) ? "Case 0"
        : (n == 1) ? "Case 1"
        : (n == 2) ? "Case 2"
        : (n == 3) ? "Case 3"
        : (n == 4) ? "Case 4"
        : (n == 5) ? "Case 5"
        : "Default Case";

         */
    }
}
