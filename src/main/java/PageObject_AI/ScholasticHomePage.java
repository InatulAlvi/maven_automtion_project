package PageObject_AI;

import Reusable_Clasess.Reusable_Action_POM_Logger;
import Reusable_Clasess.Reusable_Annotation_Class;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ScholasticHomePage extends Reusable_Annotation_Class {
    // Declare the ExtentTest for each page object class
    ExtentTest logger;

    // create a construction method
    public ScholasticHomePage(WebDriver driver){
        // page object factory function for page object
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotation_Class.logger;
    }// end of constructor

    // define all the webelementes using @find by concept

    // click on the drop down arrow
    @FindBy(xpath = "//*[@alt='Down Arrow']")
    WebElement dropDownButton;
    // click on teacher shop
    @FindBy(xpath = "//*[text()='The Teacher Store']")
    WebElement TeacherShop;
    // enter author name

    @FindBy(xpath = "//*[@aria-label='Navigation Search']")
    List<WebElement> authorName;

    // click on search button
    @FindBy(xpath = "//*[@type='submit']")
    WebElement SearchButton;

    //click on "why wait until August"
    @FindBy(xpath = "//*[text()='Why Wait Until August?']")
    WebElement WhyUntilAugust;

    // select a book
    @FindBy(xpath = "//*[@aria-label='Shop Refugee']")
    WebElement SelectBook;

    // increase book number
    @FindBy(xpath = "//*[@aria-label='Add one']")
    WebElement IncreaseBookNumber;

    // add the book to the cart
    @FindBy(xpath = "//*[@class='pdp__cta']")
    WebElement AddBook;

    // click on cart bar
    @FindBy(xpath = "//*[@class='aso-navigation__cart__globalCart__tso']")
    WebElement CartBar;

    // click on shop from different store
    @FindBy(xpath = "//*[@class='left-navigation__store-toggle']")
    WebElement ShopFromDifferentStore;

    //click on parents option
    @FindBy(xpath = "//*[@class='left-navigation__parent-tab']")
    WebElement ParentsOption;

    // click on a grade (preK)
    @FindBy(xpath = "//*[@class='card-image']")
    WebElement GradePreK;

    // click on social media link (facebook)
    @FindBy(xpath = "//*[@alt='Facebook Icon']")
    WebElement SocialMediaLink;

    public void DropDownArrow (){
        Reusable_Action_POM_Logger.clickAction(driver,dropDownButton,logger,"Dropdown Arrow");
    }// end of drop down arrow method

    public void ClickOnTeacherShop (){
        Reusable_Action_POM_Logger.clickAction(driver,TeacherShop,logger,"Teacher Shop");
    }// end of teacher shop method

    public void SearchUserValue(String uservalue){
        Reusable_Action_POM_Logger.sendKeysAction(driver,authorName.get(0),uservalue,logger,"Author Name");
    }// end of search

    public void SubmitOnAuthorSearch(){
        Reusable_Action_POM_Logger.clickAction(driver,SearchButton,logger,"Search Button");
    }// end of submit on author search method

    public void ClickOnWhyWaitUntilAugust(){
        Reusable_Action_POM_Logger.clickAction(driver,WhyUntilAugust,logger,"Why Wait Until August");
    }// end of Click on Why wait until August method

    public void SelectABook(){
        Reusable_Action_POM_Logger.clickAction(driver,SelectBook,logger,"Select A Book");
    }// end of select a book method

    public void ClickOnIncreaseButton(){
        Reusable_Action_POM_Logger.clickAction(driver,IncreaseBookNumber,logger,"Increase The Book Number");
    }// end of click on increase button method

    public void ClickOnAddToCartButton(){
        Reusable_Action_POM_Logger.clickAction(driver,AddBook,logger,"Add Book To The Cart");
    }// end of click on add to the cart button method

    public void ClickOnCartBar(){
        Reusable_Action_POM_Logger.clickAction(driver,CartBar,logger,"Click On cart Bar");
    }// end of click on cart bar method

    public void ClickOnShopFromDifferentStore(){
        Reusable_Action_POM_Logger.clickAction(driver,ShopFromDifferentStore,logger,"Shop From Different Store");
    }// end of click on shop from different store method

    public void ClickOnParentOption(){
        Reusable_Action_POM_Logger.clickAction(driver,ParentsOption,logger,"Parents Option");
    }// end of click on parents option method

    public void ClickOnGrade(){
        Reusable_Action_POM_Logger.clickAction(driver,GradePreK,logger,"PreK Grade");
    }// end of click on grade method

    public void ClickOnSocialMediaLink(){
        Reusable_Action_POM_Logger.clickAction(driver,SocialMediaLink,logger,"Facebook");
    }// end of click on social media link method

}// end of class
