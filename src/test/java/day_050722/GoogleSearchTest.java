package day_050722;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class GoogleSearchTest {
    public static void main(String[] args) {
        // set up your chromeDriver using webDriverManager
        WebDriverManager.chromedriver().setup();
        // define the web driver i am going to use
        WebDriver driver = new ChromeDriver();

        // go to google home page
        driver.navigate().to(" https://www.google.com");
        // fullscreen the driver
        driver.manage().window().fullscreen();
        // locate element for search field and type keyword cars
        driver.findElement(By.xpath("//* [@name='q' ]")).sendKeys("cars");
        // submit in google search button
        driver.findElement(By.xpath("//* [@name='btnK' ]")).submit();
        // capture the google search and print it
        String searchResult =  driver.findElement(By.xpath("//* [@id='result-stats' ]")).getText();
       // System.out.println("the result is " + searchResult);
        // extract out the number and print the search number only
        String [] arrayResult = searchResult.split(" ");
        // to replace ( and ) from the seconds that's coming from arrayList[3] use .replace command to replace it with " "(no space)
        String replaceParanth = arrayResult[3].replace("(","").replace(")","");
        System.out.println("my search result is " + arrayResult[1]);


        // close the driver
      driver.quit();



    }// end of main method

}// end of java
