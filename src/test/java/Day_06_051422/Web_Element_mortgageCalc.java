package Day_06_051422;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Web_Element_mortgageCalc {

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
        // navigate to mortgagecalculator site
        driver.navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(3000);

        // click clear and enter new value on home value field
        WebElement homeValue = driver.findElement(By.xpath("//*[@id='homeval']"));
        homeValue.click();
        homeValue.clear();
        //Thread.sleep(1500);
        homeValue.sendKeys("35000");
        //click on % ratio button
        driver.findElement(By.xpath("//*[@value='percent']")).click();

        // click, clear and enter a new data on downPayment field
        WebElement downPayment = driver.findElement(By.xpath("//*[@id='downpayment']"));
        downPayment.click();
        downPayment.clear();
        downPayment.sendKeys("5");



    }// end of main
}// end of java
