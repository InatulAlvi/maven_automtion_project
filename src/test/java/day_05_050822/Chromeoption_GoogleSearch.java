package day_05_050822;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chromeoption_GoogleSearch {
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
        //options.addArguments("headless");
        // define the web driver i am going to use
        WebDriver driver = new ChromeDriver(options);
        // fullscreen the driver
        // driver.manage().window().fullscreen();
        // go to google home page
        driver.navigate().to(" https://www.youtube.com");
        Thread.sleep(3000);
        // locate element for search field and type keyword cars
        driver.findElement(By.xpath("//*[@name='search_query']")).sendKeys("ki chile amar");
        // submit in google search button
       driver.findElement(By.xpath("//*[@class='style-scope ytd-searchbox']")).submit();
        // play the first video
        driver.findElement(By.xpath("//*[@class='style-scope yt-img-shadow']")).submit();
        // System.out.println("the result is " + searchResult);
        // extract out the number and print the search number only
     //   String [] arrayResult = searchResult.split(" ");
        // to replace ( and ) from the seconds that's coming from arrayList[3] use .replace command to replace it with " "(no space)
        //String replaceParanth = arrayResult[3].replace("(","").replace(")","");
       // System.out.println("my search result is " + arrayResult[1]);

        // close the driver
       // driver.quit();



    }// end of main method

}// end of java
