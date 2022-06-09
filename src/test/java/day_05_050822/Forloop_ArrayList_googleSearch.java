package day_05_050822;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Forloop_ArrayList_googleSearch {
    public static void main(String[] args) throws InterruptedException {
        // set up your chromeDriver using webDriverManager
        WebDriverManager.chromedriver().setup();
        // set chrome option argument
        ChromeOptions options = new ChromeOptions();
        // set the condition to incognito mode
        options.addArguments("incognito");
        // set the condition to maximize/fullscreen your driver
        // options.addArguments("start-maximized");
        // for mac use full screen
        options.addArguments("fullscreen");
        // setting your driver as headless (running on background)
       options.addArguments("headless");
        // define the web driver i am going to use
        WebDriver driver = new ChromeDriver(options);
        // fullscreen the driver
        // driver.manage().window().fullscreen();

        // capture search and print for following cities using arraylist and loop
        ArrayList<String > cities = new ArrayList<>();
        cities.add("brooklyn");
        cities.add("queens");
        cities.add("bronx");
        cities.add("nyc");
        for(int i = 0; i < cities.size(); i++){
            // go to google home page
            driver.navigate().to(" https://www.google.com");
            Thread.sleep(3000);
            // locate element for search field and type keyword cars
            driver.findElement(By.xpath("//* [@name='q' ]")).sendKeys(cities.get(i));
            // submit in google search button
            driver.findElement(By.xpath("//* [@name='btnK' ]")).submit();
            Thread.sleep(2500);
            // capture the google search and print it
            String searchResult =  driver.findElement(By.xpath("//* [@id='result-stats' ]")).getText();
           //  System.out.println("the result is " + searchResult);
            // extract out the number and print the search number only
            String [] arrayResult = searchResult.split(" ");
           System.out.println("my search for city " + cities.get(i) + " is " +  arrayResult[1]);

            // close the drive
            //driver.quit();

        }// end of loop

    }// end of main method
}// end of java
