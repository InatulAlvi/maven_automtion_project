package day_09_05222022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class MouseAction {
    public static void main(String[] args) throws InterruptedException {
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

        // navigate to USPS home page
        driver.navigate().to("https://www.usps.com");
        // wait for 3 sec
        Thread.sleep(3000);

        // declare and define mouse action
        Actions mouseActions = new Actions(driver);

        // hover to send tab
        WebElement sendTab = driver.findElement(By.xpath("//*[@id='mail-ship-width']"));
        mouseActions.moveToElement(sendTab).perform();

        // click on tracking using mouse actions
        WebElement tracking = driver.findElement(By.xpath("//*[text()='Tracking']"));
        mouseActions.moveToElement(tracking).click().perform();
        // wait 3 sec to load
        Thread.sleep(3000);

        // type a invalid tracking number using sendkeys with mouse actions
        WebElement trackingField = driver.findElement(By.xpath("//*[@id='tracking-input']"));
        mouseActions.moveToElement(trackingField).click().perform();
        mouseActions.moveToElement(trackingField).sendKeys("111223454723").perform();


    }// end of main
}// end of java
