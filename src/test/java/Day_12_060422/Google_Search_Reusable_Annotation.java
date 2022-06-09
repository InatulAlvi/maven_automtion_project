package Day_12_060422;

import ReusableLibraries.Reusable_Action;
import Reusable_Clasess.Reusable_Action_Loggers;
import Reusable_Clasess.Reusable_Annotation_Class;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Google_Search_Reusable_Annotation extends Reusable_Annotation_Class {

    //test case 1: navigate to google and enter a keyword on search field
    @Test(priority = 1)
    public void GoogleSearchForKeyword() {
        logger = reports.startTest("Search for a keyword");
        driver.navigate().to("https://www.google.com");
        //enter a keyword on search field
        Reusable_Action_Loggers.sendKeysAction(driver, "//*[@name='q']", "BMW", logger, "Search Field");
        //submit the go button
        Reusable_Action_Loggers.submitAction(driver, "//*[@name='btnK']", logger, "Google Search Button");
    }// end test 1

    /*
    dependsOnMethods is used when  following @Test is dependent on previous @Test method. If the first test fails,
    the dependent test will get skipped
     */
    @Test(dependsOnMethods = "GoogleSearchForKeyword")
    public void GoogleCaptureSearchNumber(){
        logger = reports.startTest("Capture the search number");
        //capture search result
        String result = Reusable_Action_Loggers.getTextAction(driver,"//*[@id='result-stats']",logger,"Search Result Text");
        //split the result by single space and print out the search number
        String[] arrayResult = result.split(" ");
        System.out.println("Search number is " + arrayResult[1]);
        logger.log(LogStatus.INFO,"Search number is " + arrayResult[1]);

    }//end of test 2


}// end of class
