package day3_043022;

public class multiple_condition_statement {

    public static void main(String[] args) {

        int a = 2;
        int b = 3;
        int c = 4;
        int d = 10;

        // if a+b is less than c then print the result
        // if a+b is greater than c then print the result
        // finally print a+b is equal to c
        if(a+b < c){
            System.out.println("a & b is less than c ");
        } else if (a+b > c){
            System.out.println("a & b is greater than c");
        } else if (a+b+c < d){
            System.out.println("a, b & c is less than d");
        } else {
            System.out.println("a & b is equal to c");

        }// end of condition
// declear additional variables
        int e = 4;
        int f = 5;
        int g = 6;
        // or operator with if statement
        // || is used for operator -- one of the condition need to be true only
        // && is used for and operator -- both condition need to be true
        if (e < f || g < e){
            System.out.println("d is less than e ");
        } else {
            System.out.println("condition is not true ");
        }


    }// end of main method

}// end of java
