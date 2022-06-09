package Day_06_051422;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
    public class scroll_mortgagecalc {

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
            // nevigate to mortgage calculator website
            driver.navigate().to("https://www.mortgagecalculator.org");
            // wait for web page to load
            Thread.sleep(3000);

            // declare javascriptexcutor variable
            JavascriptExecutor jse = (JavascriptExecutor) driver;

            // scroll to pixel 0-800 on mortgagecalc website
            jse.executeScript("scroll(0,800)");
            //wait a bit for the website to perform the scrolling , 2 sec
            Thread.sleep(2000);

            // declare a webelement variable that we want to scroll
            WebElement shareButton = driver.findElement(By.xpath("//*[@id='share_button']"));
            // scroll into share this calculation button
            jse.executeScript("arguments[0].scrollIntoView(true);",shareButton );
            Thread.sleep(1500);
            // click on the share this calculation button
            shareButton.click();
            Thread.sleep(2000);
            // scroll backup
            jse.executeScript("scroll(0,-500)");
            Thread.sleep(2000);

            // quit the chrome driver
            //driver.quit();
        }// end of main
     }// end of java

