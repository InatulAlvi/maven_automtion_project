package Day_12_060422;

import PageObject.BaseClass;
import Reusable_Clasess.Reusable_Annotation_Class;
import org.testng.annotations.Test;

public class GoogleSearch_POM extends Reusable_Annotation_Class {

    @Test
    public void SearchForAKeywordOnGoogleHome() {

        driver.navigate().to("https://www.google.com");
        BaseClass.googleHomePage().searchUserValue("BMW");
        BaseClass.googleHomePage().submitOnGoogleSearch();

    }// end of constructor
    @Test(dependsOnMethods = "SearchForAKeywordOnGoogleHome")
    public void CaptureSearchNumberFromGoogle(){
        BaseClass.googleSearchResultPage().captureSearchNumberAndPrintIt();

    }
}