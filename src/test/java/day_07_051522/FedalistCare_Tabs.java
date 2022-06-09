package day_07_051522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class FedalistCare_Tabs {
    public static void main(String[] args) throws InterruptedException {

        // set up your chromeDriver using webDriverManager
        WebDriverManager.chromedriver().setup();
        // set chrome option argument
        ChromeOptions options = new ChromeOptions();
        // set the condition to incognito mode
        options.addArguments("incognito");
        // set the condition to maximize/fullscreen your driver
        // for mac use full screen
        options.addArguments("fullscreen");
        // setting your driver as headless (running on background)
        //options.addArguments("headless");
        // define the web driver i am going to use
        WebDriver driver = new ChromeDriver(options);
        // navigate to fidelis care website
        driver.navigate().to("http://www.fideliscare.org");
        // wait 3 sec for the site to open
        Thread.sleep(3000);

        // click on shop for a plan
        // we are clicking on index 0 because there are two elements for this xpath
        driver.findElements(By.xpath("//*[text()='Shop For a Plan']")).get(0).click();
        // wait 2 sec for the page to load
        Thread.sleep(2000);

        // click on Medicaid Managed Care
        driver.findElements(By.xpath("//*[text()='Medicaid Managed Care']")).get(0).click();
        // wait 1 sec for the page to load
        Thread.sleep(1000);

        // click on search under find a doctor card
        driver.findElement(By.xpath("//*[@href='/findadoctor']")).click();
        //wait 1 sec for the page to load
        Thread.sleep(1000);

        //store new tabs in an array list, we use getWindowHandles method to get list of tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        // switch to new tab, it should be at index 1
        driver.switchTo().window(tabs.get(1));
        // click on new search button
        driver.findElement(By.xpath("//*[@class='fal fa-search-plus']")).click();
        // wait 1 sec for the page to load
        Thread.sleep(1000);

        // close the new tab
        driver.close();

        // switch back to the default tab
        driver.switchTo().window(tabs.get(0));
        // then click on providers card
        driver.findElement(By.xpath("//*[@class='fal fa-stethoscope fa-fw']")).click();
        // wait 3 sec for the providers card to click on
        Thread.sleep(3000);

        // close the window
        driver.quit();

    }// end of main

}// end of java
