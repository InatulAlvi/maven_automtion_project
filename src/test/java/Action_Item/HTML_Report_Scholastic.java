package Action_Item;

import ReusableLibraries.Reusable_Action;
import Reusable_Clasess.Reusable_Action_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class HTML_Report_Scholastic {
    //declare the local driver outside so that it can be reusable with other annotation methods
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;

    //before suite will set the driver you are using
    @BeforeSuite
    public void SetChromeDriver(){
        driver = Reusable_Action.setDrive();
        //define the path to the report
        reports = new ExtentReports("src/main/java/HTML_Report_Scholastic/Automation.html",true);
    }//end of before suite annotation

    // verify the tittle
    @Test(priority = 1)
    public void VerifyTittle(){
        // navigate to scholastic website
        driver.navigate().to("https://www.scholastic.com");
        // verify tittle using reusable method
        Reusable_Action.verifyTitleAction(driver,"Scholastic | Books for Kids | Parent & Teacher Resources");
    }// end of test 1

    // verify that the search option is available
    @Test(priority = 2)
    public void CaptureSearchNumber(){
            ArrayList<String>Author = new ArrayList<>();
            Author.add("Eric Carla");
            Author.add("Beverly Cleary");
            Author.add("Arnold Lobel");

            for(int i = 0;i<Author.size();i++) {
            //navigate to scholastic website
                driver.navigate().to("https://www.scholastic.com");

                // hover mouse on Shop
                Reusable_Action.mouseHover(driver, "//*[@class='page basicpage']", "Shop");
                // click on the dropdown
                Reusable_Action.clickAction(driver, "//*[@alt='Down Arrow']", "Teacher Shop");
                // click on the teacher shop
                Reusable_Action.clickAction(driver, "//*[text()='The Teacher Store']", "Teacher Shop");

                // enter the keyword
                logger = reports.startTest("enter the keyword");
                // enter keyword Eric Carle (author name)
                Reusable_Action_Loggers.sendKeysAction(driver, "//*[@aria-label='Navigation Search']", Author.get(i), logger, "Search Field");
                // click on search button
                Reusable_Action_Loggers.submitAction(driver, "//*[@type='submit']", logger, "Search Button");
                //end the logger per test
                reports.endTest(logger);

                // capture the search result
                logger = reports.startTest("Capture the search number");
                //capture search result
                String result = Reusable_Action_Loggers.getTextAction(driver, "//span[@class='cio-num-results']", logger, "Search Result Text");
                //split the result by single space and print out the search number
                String[] arrayResult = result.split(" ");
                System.out.println("Search number for " + Author.get(i) + " is " + arrayResult[0]);
                logger.log(LogStatus.INFO, "Search number for " + Author.get(i) + " is " + arrayResult[0]);

            }// end of for loop

    }//end of test 2

    // verify that the school accessories are available for shop
    @Test(priority = 3)
        public void SchoolAccessories(){
            driver.navigate().to("https://www.scholastic.com");
            // click on shop dropdown
            Reusable_Action.clickAction(driver, "//*[@alt='Down Arrow']", "Teacher Shop");
            // click on the teacher shop
            Reusable_Action.clickAction(driver, "//*[text()='The Teacher Store']", "Teacher Shop");
            //click on "why wait until August"
            Reusable_Action.clickAction(driver,"//*[text()='Why Wait Until August?']","School Accessories");

            // print out the total result for school accessories
        logger = reports.startTest("the total accessories item available is ");
        // capture the result
        String result = Reusable_Action_Loggers.getTextAction(driver,"//*[@class='cio-num-results']",logger,"The Total Item ");
        // split the result by single space and print out the item number
        String[] arrayResult = result.split(" ");
        System.out.println("the total accessories item available are " + arrayResult[0]);
        logger.log(LogStatus.INFO,"the total accessories item available are " + arrayResult[0]);


        }// end of test 3

    //  add product to the cart
    @Test(priority = 4)
    public void CheckOut(){
     driver.navigate().to("https://www.scholastic.com");
        // click on shop dropdown
        Reusable_Action.clickAction(driver, "//*[@alt='Down Arrow']", "Teacher Shop");
        // click on the teacher shop
        Reusable_Action.clickAction(driver, "//*[text()='The Teacher Store']", "Teacher Shop");
        // select a book
        Reusable_Action.clickAction(driver,"//*[@aria-label='Shop Refugee']","Refugee");
        // increase book number
        Reusable_Action.clickAction(driver,"//*[@aria-label='Add one']","Add Book");
        // add the book to the cart
        Reusable_Action.clickAction(driver,"//*[@class='pdp__cta']", "Add To Chart");
        // click on cart bar
        Reusable_Action.clickAction(driver,"//*[@class='aso-navigation__cart__globalCart__tso']","Cart Bar");

        // print the total cost
        logger = reports.startTest("The total cost is ");
        String result = Reusable_Action_Loggers.getTextAction(driver,"//*[@class='amount order-total']",logger,"Total Cost");
        System.out.println("the total cost is " + result);
        logger.log(LogStatus.INFO,"The total cost is " + result);

    }// end of test 4

    // verify that the shop by grade is available in parents store
    @Test(priority = 5)
    public void ShopByGrade() {
        // navigate to scholastic website
        driver.navigate().to("https://www.scholastic.com");
        // click on shop dropdown
        Reusable_Action.clickAction(driver, "//*[@alt='Down Arrow']", "Teacher Shop");
        // click on the teacher shop
        Reusable_Action.clickAction(driver, "//*[text()='The Teacher Store']", "Teacher Shop");
        // click on shop from different store
        Reusable_Action.clickAction(driver, "//*[@class='left-navigation__store-toggle']", "Different Store");
        //click on parents option
        Reusable_Action.clickAction(driver,"//*[@class='left-navigation__parent-tab']","Parents");
        // click on a grade (preK)
        Reusable_Action.clickAction(driver,"//*[@class='card-image']","5th Grade");
        // print the total number of item
        logger = reports.startTest("the total numbers of item available is");
        String result = Reusable_Action_Loggers.getTextAction(driver,"//*[@class='cio-num-results']",logger,"the total number");
        // split the result by single space and print out the item number
        String[] arrayResult = result.split(" ");
        System.out.println("the total number of item available is " + arrayResult[0]);
        logger.log(LogStatus.INFO,"the total number of item available is " + arrayResult[0]);

    }// end of test 5

    //declare javascriptexcutor variable
    @Test(priority = 6)
    public void SocialMediaLink(){
        // navigate to scholastic website
        driver.navigate().to("https://www.scholastic.com");
        // click on social media link (facebook)
        Reusable_Action.clickAction(driver,"//*[@alt='Facebook Icon']","Facebook");

        // store a new tab
        Reusable_Action.switchToTabByIndex(driver,1);

        // print the number of followers
        logger = reports.startTest("The total follower Scholastic have is ");
        String result = Reusable_Action_Loggers.getTextAction(driver,"//*[@class='d2edcug0 hpfvmrgz qv66sw1b c1et5uql oi732d6d ik7dh3pa ht8s03o8 jq4qci2q a3bd9o3v b1v8xokw oo9gr5id']",logger,"The Total Follower");
        // split the result by single space and print out the item number
        String[] arrayResult = result.split(" ");
        System.out.println("The total followers Scholastic have is " + arrayResult[0]);
        logger.log(LogStatus.INFO,"The total followers Scholastic have is " + arrayResult[0]);

        // close the tab
        driver.close();
        // switch back to default tab
        Reusable_Action.switchToTabByIndex(driver,0);
        // end the logger test
        reports.endTest(logger);

    }// end of test 6

    @AfterSuite
    public void quitSession() {
      driver.quit();
       reports.flush();
    }//
}// end of java
