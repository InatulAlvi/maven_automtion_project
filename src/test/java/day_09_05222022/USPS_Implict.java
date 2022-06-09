package day_09_05222022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class USPS_Implict {
    public static void main(String[] args) {

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

        // set your global implicit wait
       // driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        // navigate to usps
        driver.navigate().to("https://www.usps.com");

        // call mouse action
        Actions mouseAction = new Actions(driver);

        // declare and define explicit wait
        WebDriverWait Wait = new WebDriverWait(driver,8);

        // hover to quick tools
        WebElement quickTools = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Quick Tools']")));
        mouseAction.moveToElement(quickTools).perform();

        // click on track a package
        Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Track a Package']"))).click();

        // click and then type on track a package field
        WebElement packageField = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tracking-input']")));
        packageField.click();
        packageField.sendKeys("213742394833");

        // quit the drive
        driver.quit();

    }// end of main
}// end of java
