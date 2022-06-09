package day_10_05282022;

import ReusableLibraries.Reusable_Action;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class testing_Example {

    // declare the local driver outside so that it can be reusable with other annotation methods

    WebDriver driver;

    // before suite will set the driver you are using
    @BeforeSuite
    public void SetChromeDriver(){
        driver = Reusable_Action.setDrive();
    }// end of before suite annotation

    // test case 1: navigation to google and enter a keyword on search field
    @Test(priority = 1)
    public void SearchForKeyword(){
        driver.navigate().to("https://www.google.com");
        Reusable_Action.sendKeysAction(driver,"//*[@name='q']","BMW","capture Field");
        Reusable_Action.submitAction(driver,"//*[@name='btnK']","Google Search Button");
    }// end of test 1

    @Test(priority = 2)
    public void CaptureSearchNumber(){
        // capture search result
        String result = Reusable_Action.getTextAction(driver,"//*[@id='result-stats']","Text");

        // split the result by single space and print out the search result
        String[]arrayResult = result.split(" ");
        System.out.println("search number is " + arrayResult);
    }// end of test 2

    @AfterSuite
    public void QuitSession(){
        driver.quit();
    }// end of after suit
}
