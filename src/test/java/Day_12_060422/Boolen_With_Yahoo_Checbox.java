package Day_12_060422;

import Reusable_Clasess.Reusable_Action_Loggers;
import Reusable_Clasess.Reusable_Annotation_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Boolen_With_Yahoo_Checbox extends Reusable_Annotation_Class {

    @Test
    public void Yahoo_Stay_Signed_In_Checkbox_Verifiction() throws InterruptedException {
        // Navigate to yahoo
        driver.navigate().to("https://www.yahoo.com");
        // click on sign in
        Reusable_Action_Loggers.clickAction(driver, "//*[text()='Sign in']", logger, "Sign In");
        // verify the stay signed in checkbox is selected or not
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='checkbox']"))).isSelected();
        if (elementState == true) {
            logger.log(LogStatus.PASS, "Checkbox is selected as expected ");
        } else {
            logger.log(LogStatus.FAIL, "Checkbox is not selected");
        }

    }// end of test

    @Test(priority = 2)
    public void NavigateTahooHome() {
        // navigate  to usps
        logger.log(LogStatus.INFO,"navigating to hoem page");
        driver.navigate().to("https://www.yahoo.com");
    }

}// end of class