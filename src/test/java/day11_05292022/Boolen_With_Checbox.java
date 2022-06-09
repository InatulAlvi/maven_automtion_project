package day11_05292022;

import ReusableLibraries.Reusable_Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Boolen_With_Checbox {
    // declare the local driver outside so that it can be reusable with other annotation methods
    WebDriver driver;

    // before suite will set the driver you are using
    @BeforeSuite
    public void SetChromeDriver(){
        driver = Reusable_Action.setDrive();
    }// end of before suite annotation

    @Test
    public void Yahoo_Stay_Signed_In_Checkbox_Verifiction() throws InterruptedException{
        // Navigate to yahoo
        driver.navigate().to("https://www.yahoo.com");
        // click on sign in
        Reusable_Action.clickAction(driver,"//*[@class='_yb_w9vif']","Sign In");
        // verify the stay signed in checkbox is selected or not
        WebDriverWait wait = new WebDriverWait(driver,10);
        Boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='checkbox']"))).isSelected();
        System.out.println("IS element checked? " + elementState);

    }// end of test

    @AfterSuite
    public void quitSession(){
        driver.quit();
    }// end of after suit
}
