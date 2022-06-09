package PageObject;

import Reusable_Clasess.Reusable_Action_Loggers;
import Reusable_Clasess.Reusable_Action_POM_Logger;
import Reusable_Clasess.Reusable_Annotation_Class;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleHomePage extends Reusable_Annotation_Class {
    // Declare the extentTest for each page object class
    ExtentTest logger;

    // create a constructor method that will reference the same name as your class, you can make your
    // page object class methods static when you call it in your test class
    public GoogleHomePage(WebDriver driver){
        // page factory function fpr page object
        PageFactory.initElements(driver, this);
        this.logger = Reusable_Annotation_Class.logger;
    }// end of constructor

    // define a;; the webelements using @find by concept
    @FindBy(xpath = "//*[@name='q']")
   WebElement searchField;
    @FindBy(xpath = "//*[@name='btnK']")
    WebElement googelSearchButton;
    @FindBy(xpath = "//*[@name='btnK']")
    List<WebElement> listLinks;

    public void searchUserValue(String uservalue){
        Reusable_Action_POM_Logger.sendKeysAction(driver,searchField,uservalue,logger,"search Field");
    }//

    public void submitOnGoogleSearch(){
        Reusable_Action_POM_Logger.submitAction(driver,googelSearchButton,logger,"google search buttton");
    }//
}// end of class
