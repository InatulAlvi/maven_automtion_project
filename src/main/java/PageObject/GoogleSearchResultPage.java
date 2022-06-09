package PageObject;


import Reusable_Clasess.Reusable_Action_Loggers;
import Reusable_Clasess.Reusable_Action_POM_Logger;
import Reusable_Clasess.Reusable_Annotation_Class;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

    public class GoogleSearchResultPage extends Reusable_Annotation_Class {
        // Declare the extentTest for each page object class
        ExtentTest logger;

        // create a constructor method that will reference the same name as your class, you can make your
        // page object class methods static when you call it in your test class
        public GoogleSearchResultPage(WebDriver driver){
            // page factory function fpr page object
            PageFactory.initElements(driver, this);
            this.logger = Reusable_Annotation_Class.logger;
        }// end of constructor

        // define all the webElements using @find by concept
        @FindBy(xpath = "//*[@id='result-stats']")
        WebElement searchResult;

        public void captureSearchNumberAndPrintIt(){
            String result = Reusable_Action_POM_Logger.getTextAction(driver,searchResult,logger,"search Field");
            String[] arrayResult = result.split(" ");
            System.out.println("my search number is " + arrayResult[1]);
            logger.log(LogStatus.INFO,"my search number is " + arrayResult[1]);
        }//

    }// end of class

