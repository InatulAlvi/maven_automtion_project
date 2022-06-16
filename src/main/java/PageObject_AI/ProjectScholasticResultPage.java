package PageObject_AI;

import Reusable_Clasess.Reusable_Action_POM_Logger;
import Reusable_Clasess.Reusable_Annotation_Class;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.jdi.event.StepEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectScholasticResultPage extends Reusable_Annotation_Class{
    // Declare the ExtenTest for each page object class
    ExtentTest logger;

    // create a constructor method
    // page object class methods static
    public ProjectScholasticResultPage(WebDriver driver){
        // page factory function for page object
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotation_Class.logger;
    }// end of constructor

    // define all the webElements using @find by concept
    // capture the search result
    @FindBy(xpath = "//span[@class='cio-num-results']")
    WebElement SearchResultForAuthor;

    // print out the total result for school accessories
    @FindBy(xpath = "//*[@class='cio-num-results']")
    WebElement CaptureAccessoriesResult;

    // print the total cost
    @FindBy(xpath = "//*[@class='amount order-total']")
    WebElement CaptureTheTotalCost;

    // print the total number of item
    @FindBy(xpath = "//*[@class='cio-num-results']")
    WebElement PrintTheTotalNumberOfItem;

    // print the number of followers
    @FindBy(xpath = "//*[@class='d2edcug0 hpfvmrgz qv66sw1b c1et5uql oi732d6d ik7dh3pa ht8s03o8 jq4qci2q a3bd9o3v b1v8xokw oo9gr5id']")
    WebElement PrintTheNumberOfFollowers;


    public void CaptureSearchNumberAndPrintIt(){
        String result = Reusable_Action_POM_Logger.getTextAction(driver,SearchResultForAuthor,logger,"Author Search Result");
        String[] arrayResult = result.split(" ");
        System.out.println("My search number is " + arrayResult[0]);
        logger.log(LogStatus.INFO,"My search number is " + arrayResult[0]);
    }// end of capture search number method

    public void CaptureAccessoriesNumberAndPrintIt(){
        String result = Reusable_Action_POM_Logger.getTextAction(driver,CaptureAccessoriesResult,logger,"Accessories Number");
        String[] arrayResult = result.split(" ");
        System.out.println("the total accessories item available are " + arrayResult[0]);
        logger.log(LogStatus.INFO,"the total accessories item available are " + arrayResult[0]);
    }// end of capture accessories number method

    public void PrintTheTotalCost(){
        String result = Reusable_Action_POM_Logger.getTextAction(driver,CaptureTheTotalCost,logger,"Total Cost");
        String[] arrayResult = result.split(" ");
        System.out.println("the total cost is " + result);
        logger.log(LogStatus.INFO,"The total cost is " + result);
    }// end of print the total cost method

    public void TheTotalNumberOfItemAvailable(){
        String result = Reusable_Action_POM_Logger.getTextAction(driver,PrintTheTotalNumberOfItem,logger,"Total Number Of Item");
        String[] arrayResult = result.split(" ");
        System.out.println("the total number of item available is " + arrayResult[0]);
        logger.log(LogStatus.INFO,"the total number of item available is " + arrayResult[0]);
    }// end of the total number of item available method

    public void NumberOfFollowers(){
        String result = Reusable_Action_POM_Logger.getTextAction(driver,PrintTheNumberOfFollowers,logger,"The Total Followers");
        String[] arrayResult = result.split(" ");
        System.out.println("The total followers Scholastic have is " + arrayResult[0]);
        logger.log(LogStatus.INFO,"The total followers Scholastic have is " + arrayResult[0]);
    }// end of the number of followers method

}// end of class
