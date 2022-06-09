package Action_Item;

import ReusableLibraries.Reusable_Action;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.zip.ZipEntry;

public class action_Item_UHC {
    public static void main(String[] args) {

        // using reusable set driver method
        WebDriver driver = Reusable_Action.setDrive();

        // navigate to UHC home page
        driver.navigate().to("https://www.UHC.com");

        // verify the home page title contain health insurance plans.
        Reusable_Action.verifyTitleAction(driver,"health insurance plans");

        ArrayList<String> firstName = new ArrayList<>();
        firstName.add("Enatul");
        firstName.add("Saikat");
        firstName.add("Sm");

        ArrayList<String> lastName = new ArrayList<>();
        lastName.add("Abedin");
        lastName.add("Babu");
        lastName.add("Bulbul");

        ArrayList<String> birthMonth = new ArrayList<>();
        birthMonth.add("August");
        birthMonth.add("December");
        birthMonth.add("November");

        ArrayList<String> birthDay = new ArrayList<>();
        birthDay.add("26");
        birthDay.add("21");
        birthDay.add("3");

        ArrayList<String> birthYear = new ArrayList<>();
        birthYear.add("2001");
        birthYear.add("1998");
        birthYear.add("1999");

        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("10307");
        zipCode.add("11209");
        zipCode.add("11218");

        ArrayList<String> memberId = new ArrayList<>();
        memberId.add("13323219444644");
        memberId.add("14438529853648");
        memberId.add("23185456375443");

        for (int i = 0; i < firstName.size(); i++) {


            // click on find doctor
            Reusable_Action.clickAction(driver, "//*[@aria-label='Find a doctor']", "Find a Doctor");

            // click on sign in
            Reusable_Action.clickAction(driver, "//*[@aria-label='Sign in menu']", "Sign In");

            // click on medicare plan
            Reusable_Action.clickAction(driver, "//*[@aria-label='Medicare plan? Sign in to Medicare member site Opens a new window']", "Medicare Plan");


            // store a new tab using reusable method
            Reusable_Action.switchToTabByIndex(driver, 1);

            // click on register now
            Reusable_Action.clickAction(driver, "//*[@class='uhc-tempo-link uhc-tempo-link--medium registerBtn ng-scope']", "Register");

            // enter the first name
            Reusable_Action.sendKeysAction(driver, "//*[@id='firstName']", firstName.get(i), "First Name");

            // enter the last name
            Reusable_Action.sendKeysAction(driver, "//*[@id='lastName']", lastName.get(i), "Last Name");

            // to select birth month
            Reusable_Action.selectByTextAction(driver, "//*[@id='dob_month_input']", birthMonth.get(i), "Birth Month");

            // enter the birthday
            Reusable_Action.sendKeysAction(driver, "//*[@id='dob_day']", birthDay.get(i), "Birthday");

            // enter the birth year
            Reusable_Action.sendKeysAction(driver, "//*[@id='dob_year']", birthYear.get(i), "Birth Year");

            // Enter zip code
            Reusable_Action.sendKeysAction(driver, "//*[@id='zipCode']", zipCode.get(i), "Zip Code");

            // Enter member id
            Reusable_Action.sendKeysAction(driver, "//*[@id='memberId']", memberId.get(i), "Member ID");

            // click on continue
            Reusable_Action.clickAction(driver, "//*[@id='submitBtn']", "Continue");

            // capture the following error
            String result = Reusable_Action.getTextAction(driver, "//*[@id='personalInfo_errors']", "Following Error");
            System.out.println("the following error is " + result);

        }// end of for loop

        // close the tab
        driver.close();

        // switch back to default tab
        Reusable_Action.switchToTabByIndex(driver, 0);

        // quit the drive
        driver.quit();

    }// end of main
}// end of java