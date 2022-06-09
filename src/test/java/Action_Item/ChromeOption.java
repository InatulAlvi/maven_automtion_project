package Action_Item;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class ChromeOption {
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
        options.addArguments("headless");
        // define the web driver i am going to use
        WebDriver driver = new ChromeDriver(options);
        // capture search and print for following sports using arraylist and loop
        ArrayList<String > sports = new ArrayList<>();
        sports.add("cricket");
        sports.add("football");
        sports.add("badminton");
        sports.add("chess");
        for(int i = 0; i < sports.size(); i++){

            // go to microsoft being home page
            driver.navigate().to("https://www.bing.com");
            Thread.sleep(3000);
            // locate element for search field and type keyword
            driver.findElement(By.xpath("//* [@name='q' ]")).sendKeys(sports.get(i));
            // submit in microsoft being  search button
            driver.findElement(By.xpath("//* [@viewBox=\"0 0 25 25\" ]")).submit();
            Thread.sleep(2500);
            // capture the microsoft being search and print it
            String searchResult =  driver.findElement(By.xpath("//* [@data-bm='4' ]")).getText();
           // System.out.println("the result is " + searchResult);
            // extract out the number and print the search number only
          String [] arrayResult = searchResult.split(" ");

          System.out.println("my search for sport " + sports.get(i) + " is " +  arrayResult[0]);

        }// end of for loop

    }// end of main method

}// end of java
