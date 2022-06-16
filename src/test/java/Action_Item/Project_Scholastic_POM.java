package Action_Item;

import PageObject.BaseClass;
import PageObject_AI.BaseClass_Scholastic;
import ReusableLibraries.Reusable_Action;
import Reusable_Clasess.Reusable_Annotation_Class;
import org.testng.annotations.Test;

import java.security.PublicKey;
import java.util.ArrayList;

public class Project_Scholastic_POM extends Reusable_Annotation_Class{

    @Test(priority = 1)
    public void SearchForTheAuthorNameOnAuthorSearchButton(){
        ArrayList<String> Author = new ArrayList<>();
        Author.add("Eric Carla");
        Author.add("Beverly Cleary");
        Author.add("Arnold Lobel");

        for(int i = 0;i<Author.size();i++) {
            driver.navigate().to("https://www.scholastic.com");
            BaseClass_Scholastic.scholasticHomePage().DropDownArrow();
            BaseClass_Scholastic.scholasticHomePage().ClickOnTeacherShop();
            BaseClass_Scholastic.scholasticHomePage().SearchUserValue(Author.get(i));
            BaseClass_Scholastic.scholasticHomePage().SubmitOnAuthorSearch();
            BaseClass_Scholastic.projectScholasticResultPage().CaptureSearchNumberAndPrintIt();
        }// end of for loop
        //end the logger per test
        reports.endTest(logger);
    }// end of test 1

    @Test(priority = 2)
    public void SearchForSchoolAccessories(){
        driver.navigate().to("https://www.scholastic.com");
        BaseClass_Scholastic.scholasticHomePage().DropDownArrow();
        BaseClass_Scholastic.scholasticHomePage().ClickOnTeacherShop();
        BaseClass_Scholastic.scholasticHomePage().ClickOnWhyWaitUntilAugust();
        BaseClass_Scholastic.projectScholasticResultPage().CaptureAccessoriesNumberAndPrintIt();
        //end the logger per test
        reports.endTest(logger);
    }// end of test 2

    @Test(priority = 3)
    public void CheckOut(){
        driver.navigate().to("https://www.scholastic.com");
        BaseClass_Scholastic.scholasticHomePage().DropDownArrow();
        BaseClass_Scholastic.scholasticHomePage().ClickOnTeacherShop();
        BaseClass_Scholastic.scholasticHomePage().SelectABook();
        BaseClass_Scholastic.scholasticHomePage().ClickOnIncreaseButton();
        BaseClass_Scholastic.scholasticHomePage().ClickOnAddToCartButton();
        BaseClass_Scholastic.scholasticHomePage().ClickOnCartBar();
        BaseClass_Scholastic.projectScholasticResultPage().PrintTheTotalCost();
        //end the logger per test
        reports.endTest(logger);
    }// end of test 3

    @Test(priority = 4)
    public void ShopByGrade(){
        driver.navigate().to("https://www.scholastic.com");
        BaseClass_Scholastic.scholasticHomePage().DropDownArrow();
        BaseClass_Scholastic.scholasticHomePage().ClickOnTeacherShop();
        BaseClass_Scholastic.scholasticHomePage().ClickOnShopFromDifferentStore();
        BaseClass_Scholastic.scholasticHomePage().ClickOnParentOption();
        BaseClass_Scholastic.scholasticHomePage().ClickOnGrade();
        BaseClass_Scholastic.projectScholasticResultPage().TheTotalNumberOfItemAvailable();
        //end the logger per test
        reports.endTest(logger);
    }// end of test 4

    @Test(priority = 5)
    public void SocialMediaLink(){
        driver.navigate().to("https://www.scholastic.com");
       BaseClass_Scholastic.scholasticHomePage().ClickOnSocialMediaLink();
        // store a new tab
        Reusable_Action.switchToTabByIndex(driver,1);
        BaseClass_Scholastic.projectScholasticResultPage().NumberOfFollowers();
        // close the tab
        driver.close();
        // switch back to default tab
        Reusable_Action.switchToTabByIndex(driver,0);
        // end the logger test
        reports.endTest(logger);
    }// end of test 5


}// end of class
