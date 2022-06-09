package day_10_05282022;

import ReusableLibraries.Reusable_Action;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class testing_Example_forLoop {

    // declare the local driver outside so that it can be reusable with other annotation methods

    WebDriver driver;

    // before suite will set the driver you are using
    @BeforeSuite
    public void SetChromeDriver(){
        driver = Reusable_Action.setDrive();
    }// end of before suite annotation
    //test case 1: navigate to google and enter a keyword on search field
    @Test
    public void SearchForKeyword(){
        ArrayList<String> cars = new ArrayList();
        cars.add("BMW");
        cars.add("Mercedes");
        cars.add("Tesla");
        for(int i = 0; i<cars.size();i++) {
            driver.navigate().to("https://www.google.com");
            //enter a keyword on search field
            Reusable_Action.sendKeysAction(driver, "//*[@name='q']", cars.get(i), "Search Field");
            //submit the go button
            Reusable_Action.submitAction(driver, "//*[@name='btnK']", "Google Search Button");
            //capture search result
            String result = Reusable_Action.getTextAction(driver, "//*[@id='result-stats']", "Search Result Text");
            //split the result by single space and print out the search number
            String[] arrayResult = result.split(" ");
            System.out.println("Search number for " + cars.get(i) + " is " + arrayResult[1]);
        }//end of loop
    }//end of test


    @AfterSuite
    public void QuitSession(){
        driver.quit();
    }// end of after suit
}
