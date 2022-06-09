package day8_05212022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class getTitle_example {

    public static void main(String[] args) {
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

        // navigate to google
        driver.navigate().to("https://www.google.com");
        // capture the title of the page and compare it with your expected title 'GOOGLE'
        String actualTitle = driver.getTitle();
        if (actualTitle.equals("Google")){
            System.out.println("my title matches");
        } else {
            System.out.println("title doesn't match. Actual Title is " + actualTitle);
        }

    }// end of main
}// end of java
