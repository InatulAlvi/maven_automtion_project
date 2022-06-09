package ReusableLibraries;

public class ReusableMethods {

    // creat a void method to add two numbers
    public static void addTwoNumbers(int num1, int num2){
        int result = num1+num2;
        System.out.println("the result of two number is " + result);
    }// end of add two numbers method

    // create a return method to subtract two numbers
    public static int subtractTwoNumbers(int a, int b){
        int result = a-b;
        System.out.println("the result of two numbers for subtraction is " + result);
        return result;
    }

}// end of java
