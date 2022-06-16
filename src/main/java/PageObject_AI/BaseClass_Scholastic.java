package PageObject_AI;

import Reusable_Clasess.Reusable_Annotation_Class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseClass_Scholastic extends Reusable_Annotation_Class {
    public BaseClass_Scholastic(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    // end of constructor class

    // create a static reference for scholastic home page
    public static ScholasticHomePage scholasticHomePage(){
        ScholasticHomePage scholasticHomePage = new ScholasticHomePage(driver);
        return scholasticHomePage;
    }

    // create a static reference for scholastic home page
    public static ProjectScholasticResultPage projectScholasticResultPage() {
        ProjectScholasticResultPage projectScholasticResultPage = new ProjectScholasticResultPage(driver);
        return projectScholasticResultPage;
    }// end of project Scholastic search result page


}// end of class
