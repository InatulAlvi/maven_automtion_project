package Action_Item;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class Weight_watchers {
    public static void main(String[] args) throws InterruptedException {
        // set up your chromeDriver using webDriverManager
        WebDriverManager.chromedriver().setup();
        // set chrome option argument
        ChromeOptions options = new ChromeOptions();
        // set the condition to maximize/fullscreen your driver
        // for mac use full screen
        options.addArguments("fullscreen");
        // set the condition to incognito mode
        options.addArguments("incognito");
        // setting your driver as headless (running on background)
        options.addArguments("headless");
        // define the web driver I am going to use
        WebDriver driver = new ChromeDriver(options);
// declare javascriptexcutor variable
JavascriptExecutor jse = (JavascriptExecutor) driver;

// navigate to weight watcher website
driver.navigate().to("https://www.weightwatchers.com");
// wait for 3 sec
Thread.sleep(3000);

        // click on attend dropdown
        driver.findElement(By.xpath("//*[@da-label='Find a Workshop']")).click();
        // click on Unlimited Workshop from the dropdown
       // driver.findElement(By.xpath("//*[@data-e2e-name='unlimited_workshops']")).click();
        // wait 2 sec
        Thread.sleep(2000);
        // click on studio link
        driver.findElement(By.xpath("//*[@class='buttonWrapper-QK2gi']")).click();
        // wait 2 sec
        Thread.sleep(2000);

        ArrayList<String>zipCode = new ArrayList<>();
        zipCode.add("11218");
        zipCode.add("10307");
        zipCode.add("11208");

        for(int i = 0; i < zipCode.size(); i++) {

            //enter zipcode
            driver.findElement(By.xpath("//*[@id='location-search']")).sendKeys(zipCode.get(i));
            //wait 1 sec
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@aria-label='Submit']")).click();
            //wait 2 sec
            Thread.sleep(2000);

            //get list of studios, and click on studio link
            try {
                ArrayList<WebElement> searchResults = new ArrayList<>(driver.findElements(By.xpath("//*[@class = 'linkContainer-1NkqM']")));
                System.out.println("Number of Studios found for zipcode: " + zipCode.get(i) + " are " + searchResults.size());
                Thread.sleep(1000);
                if (i == 0) {

                    searchResults.get(1).click();
                    String workshopSchedule = driver.findElement(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).getText();
                    System.out.println("and the workshop schedule for " + zipCode.get(1) + " is " + workshopSchedule);
                    jse.executeScript("scroll(0,500)");

                    driver.findElement(By.xpath("//*[@da-label='Find a Workshop']")).click();
                    driver.findElement(By.xpath("//*[@class='buttonWrapper-QK2gi']")).click();
                } else if (i == 1) {

                    searchResults.get(2).click();
                    String workshopSchedule = driver.findElement(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).getText();
                    System.out.println("and the workshop schedule for " + zipCode.get(i) + " is " + workshopSchedule);
                    jse.executeScript("scroll(0,500)");

                    driver.findElement(By.xpath("//*[@da-label='Find a Workshop']")).click();
                    driver.findElement(By.xpath("//*[@class='buttonWrapper-QK2gi']")).click();
                } else if (i == 2) {

                    searchResults.get(0).click();
                    String workshopSchedule = driver.findElement(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).getText();
                    System.out.println(" and the workshop schedule for " + zipCode.get(i) + " is " + workshopSchedule);
                    jse.executeScript("scroll(0,500)");
                }// end of if condition

            } catch (Exception e) {
                //print out the exception
                System.out.println("Unable to get list of studios " + e);
            }//end of get list of studios exception

        }// end of for loop

        // quit the drive
        driver.quit();



    }// end of main

}// end of java
