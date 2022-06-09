package Day_06_051422;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class findElemantsExample {

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
        // go to microsoft being home page
        driver.navigate().to("https://www.bing.com");
        Thread.sleep(3000);
        driver.findElements(By.xpath("//li[contains(@class,'scope')]")).get(0).click();


    }// end of main

}// end of java
