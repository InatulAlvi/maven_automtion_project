package day_07_051522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class select_mortgageCalculate {
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

        // navigate to mortgage calculate
        driver.navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(3000);
        // select start month from dropdown
        WebElement startMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));
        // define select command
         Select dropDown = new Select(startMonth);
        //select by visible text
         dropDown.selectByVisibleText("Jun");

        // clicking on dropdown and its value if the dropdown tag is not under select tag
        //  startMonth.click();
        // click on the value of the start month
       // driver.findElement(By.xpath("//*[text()='Jun']")).click();

        // select loan type from the dropdown
        WebElement loanType = driver.findElement(By.xpath("//*[@name='param[milserve]']"));
        // define select command
        Select loanTypeDropdown = new Select(loanType);
        // select visible text
        loanTypeDropdown.selectByVisibleText("FHA");

        // close the drive
        driver.quit();



    }// end of main

}// end of java
