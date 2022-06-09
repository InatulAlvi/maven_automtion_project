package day_09_05222022;

import ReusableLibraries.Reusable_Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class USPS_Reusable_Concepts {
    public static void main(String[] args) {

        // setting the local driver to reusable set driver method
        WebDriver driver = Reusable_Action.setDrive();

        // navigate to usps
        driver.navigate().to("https://www.usps.com");

        // hovering to the quick tools
        Reusable_Action.mouseHover(driver,"//*[text()='Quick Tools']", "Quick Tools");

        // hover to send tab
        Reusable_Action.mouseHover(driver,"//*[@id='mail-ship-width']","Send Tab");

        // click on calculated price
        Reusable_Action.clickAction(driver,"//li[@class='tool-calc']", "Calculate a Price");


        // enter the mailing from zipcode
        Reusable_Action.sendKeysAction(driver,"//*[@id='Origin']", "11218", "Zip Code");

        // enter the mailing to zipcode
        Reusable_Action.sendKeysAction(driver,"//*[@id='Destination']", "10307", "Zip Code");

        // print the header info
        String result = Reusable_Action.getTextAction(driver,"//*[@class='header-usps row","Header Info");
        System.out.println("my header info is " + result);

        // enter the shipping date
       // Reusable_Action.clickByIndexAction(driver,"//*[@id='ShippingDate'",6/24/2022,"Shipping Date");

        // enter the shipping time
       // Reusable_Action.clickAction(driver,"//*[@id='ShippingTime']","Shipping Time");
        // select time
     //  Reusable_Action.clickAction(driver,"//*[text()='between 6:00 p.m.- 6:30 p.m.']", "Time");

        // choose and click what are u mailing
       // Reusable_Action.clickAction(driver,"//*[@id='DayOldPoultry']", "Day Old Poultry");



        // quit the drive
       // driver.quit();
    }// end of main
}// end of java
