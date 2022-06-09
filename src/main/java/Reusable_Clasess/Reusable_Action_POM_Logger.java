package Reusable_Clasess;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;

public class Reusable_Action_POM_Logger {

    // set a static timeout variable so it can cover all explicit for all method
    static int timeout = 10;

    // reusable function for webdriver as a return method
    public static WebDriver setDrive(){

        //setup your Chrome Driver with Web Driver Manager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //start browser in incognito mode
        options.addArguments("incognito");
        //maximize the browser
        options.addArguments("full screen");
        //Define your Chrome Driver
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }// end of return method


        // create a  mouse hover method
        public static void mouseHover(WebDriver driver, String xpath, String elementName ){
            WebDriverWait Wait = new WebDriverWait(driver,timeout);
            Actions actions = new Actions(driver);
            try {
                WebElement element = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
                actions.moveToElement(element).perform();

            }catch (Exception e){
                System.out.println("unable to hover element " + e);
            }// end of exception
        }// end of mouse hover method


    // create a click method
    public static void clickAction(WebDriver driver, WebElement xpath,ExtentTest logger, String elementName){
        WebDriverWait Wait = new WebDriverWait(driver, timeout);

        try {
            WebElement element = Wait.until(ExpectedConditions.visibilityOf(xpath));
            element.click();
            logger.log(LogStatus.PASS,"successfully clicked on " + elementName);
        }catch (Exception e){
            System.out.println("unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Successfully clicked on element " + elementName);
            getScreenshot(driver,elementName,logger);
        }// end of try and catch exception
    }// end of clickAction


    // create a sendkeys method
    public static void sendKeysAction(WebDriver driver,WebElement xpath,String userValue,ExtentTest logger , String elementName){
        WebDriverWait Wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = Wait.until(ExpectedConditions.visibilityOf(xpath));
            element.click();
            element.clear();
            element.sendKeys(userValue);
            logger.log(LogStatus.PASS, "successfully submit on element " + elementName);
        }catch (Exception e){
            System.out.println("unable to use sendkeys method " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "successfully submit on element " + elementName + " " + e);
            getScreenshot(driver,elementName,logger);
        }// end of try and catch exception
    }// end of sendKeys method


    // create a get text method
    public static String getTextAction(WebDriver driver, WebElement xpath,ExtentTest logger, String elementName){
        WebDriverWait Wait = new WebDriverWait(driver, timeout);
        String result = null;
        try {
            WebElement element = Wait.until(ExpectedConditions.visibilityOf(xpath));
            result = element.getText();
            logger.log(LogStatus.PASS, "successfully submit on element " + elementName);
        }catch (Exception e){
            System.out.println("unable to capture text element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "successfully submit on element " + elementName + " " + e);
            getScreenshot(driver,elementName,logger);
        }// end of try and catch exception
        return result;
    }//end of get text method


    // create a switch to tab by index method
    public static void switchToTabByIndex(WebDriver driver, int userValue){
        try {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(userValue));
        }catch (Exception e){
            System.out.println("unable to switch tab by index " + e);
        }// end of try and catch exception
    }// end of method

    // create a select by text method
    public static void selectByTextAction(WebDriver driver,WebElement xpath, String visibleText ,String elementName){
        WebDriverWait Wait = new WebDriverWait(driver,timeout);
        try {
            WebElement element = Wait.until(ExpectedConditions.visibilityOf(xpath));
            element.click();
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(visibleText);
        }catch (Exception e){
            System.out.println("unable to click on element " + elementName + " " + e);
        }// end if try and catch exception method
    }// end of select by text method


    // create verify tittle method
    public static String verifyTitleAction(WebDriver driver, String expectedTitle){
        WebDriverWait Wait = new WebDriverWait(driver,timeout);
        String verifyTitle = driver.getTitle();
        if(verifyTitle.contains(expectedTitle)){
            System.out.println("my title matches ");
        }else {
            System.out.println("title doesn't match. Actual title is " + verifyTitle);
        }
        return verifyTitle;

    }// end of verify title method

    //create a submit method
    public static void submitAction(WebDriver driver, WebElement xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOf(xpath));
            element.submit();
            logger.log(LogStatus.PASS, "successfully submit on element " + elementName);

        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "successfully submit on element " + elementName + " " + e);
            getScreenshot(driver,elementName,logger);
        }
    }//end of submit

    // method to capture a screenshot when logger fails
    public static void getScreenshot(WebDriver driver,String imageName, ExtentTest logger){
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/Html_Report/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile,new File(directory+ fileName));
            // String imgPath = directory + fileName
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL,"",image);
        }catch (Exception e){
            logger.log(LogStatus.FAIL,"Error occured while taking SCREENSHOT!!!");
        }
    }// end of get screenshot method

}// end of java
