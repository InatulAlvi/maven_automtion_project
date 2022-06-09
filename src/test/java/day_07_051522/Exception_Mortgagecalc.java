package day_07_051522;

import day2_042422.ForLoop;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class Exception_Mortgagecalc {
    public static void main(String[] args) throws InterruptedException {
        // set up your chromeDriver using webDriverManager
        WebDriverManager.chromedriver().setup();
        // set chrome option argument
        ChromeOptions options = new ChromeOptions();
        // set the condition to incognito mode
        options.addArguments("incognito");
        // set the condition to maximize/fullscreen your driver
        // for mac use full screen
        options.addArguments("maximize");
        // setting your driver as headless (running on background)
        //options.addArguments("headless");
        // define the web driver i am going to use
        WebDriver driver = new ChromeDriver(options);

        // navigate to mortgage calculate
        driver.navigate().to("https://www.mlcalc.com");
        // wait 3 sec for the website to open
        Thread.sleep(3000);

        ArrayList<String>pPriceList = new ArrayList<>();
        pPriceList.add("450000");
        pPriceList.add("430000");
        pPriceList.add("490000");

        ArrayList<String> sMonthList = new ArrayList<>();
        sMonthList.add("Jan");
        sMonthList.add("Feb");
        sMonthList.add("May");

        for (int i = 0; i < sMonthList.size();i++){
            // handle exception for purchase price
            try {
                WebElement pPrice = driver.findElement(By.xpath("//*[@id='ma']"));
                pPrice.clear();
                pPrice.sendKeys(pPriceList.get(i));
            }catch (Exception e){
                // print out the exception
                System.out.println("unable to locate purchase price " + e);
            }// end of purchase price exception

            // handle exception for show advance option button
            try {
                driver.findElement(By.xpath("//*[text()='Show advanced options']")).click();
            }catch (Exception e) {
                // print out the exception
                System.out.println("unable to locate show advance option button " + e);
            }// end of show advanced option exception

            // handle exception for start month drop down
            try {
                WebElement startMonth = driver.findElement(By.xpath("//*[@name='sm']"));
                Select dropdown = new Select(startMonth);
                dropdown.selectByVisibleText(sMonthList.get(i));
            }catch (Exception e){
                // print out the exception
                System.out.println("unable to locate start month dropdown " + e);
            }// end of start month exception

            // handle exception for calculate button
            try {
                driver.findElement(By.xpath("//*[@value='Calculate']")).click();
            }catch (Exception e){
                // print out the exception
                System.out.println("unable to locate calculate button " + e);
            }// end of calculate exception

            Thread.sleep(3000);
            // handle exception for monthly payment
            try {
                String mntPayment = driver.findElements(By.xpath("//div[@style='font-size: 32px']")).get(0).getText();
                System.out.println("monthly payment is " + mntPayment);
            }catch (Exception e){
                // print out the exception
                System.out.println("unable to locate monthly payment text " + e);
            }// end of monthly payment exception

        }// end of for loop
        // quit the driver
        driver.quit();

    }// end of main

}// end of java
