package day3_043022;

import ReusableLibraries.ReusableMethods;

public class testing_method {

    public static void main(String[] args) {

        // call the add two number method
        //ReusableMethods.addTwoNumbers(20,30);

        // call the return method and store it in a variable to perform something else
        int finalResult = ReusableMethods.subtractTwoNumbers(20, 10);
        int newResult = finalResult+10;
        System.out.println("my new result is " + newResult);

    }// end of main method

}// end of java
