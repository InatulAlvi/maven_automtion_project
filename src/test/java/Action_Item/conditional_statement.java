package Action_Item;

public class conditional_statement {
    public static void main(String[] args) {

        // if the range is more than 90 and less than 100 then the grade is A
        int grade = 89;
        if (grade > 90 && grade < 100){
            System.out.println("my grade is A");

            // if the range is more than 80 and less than 90 then the grade is B
        } else if (grade > 80 && grade < 90){
            System.out.println("my grade is B");

            // if the range is more than 70 and less than 80 then the grade is C
        }else if (grade > 70 && grade < 80){
            System.out.println("my grade is C");

            // if the range is more than 60 and less than 70 then the grade is D
        }else if (grade > 60 && grade < 70){
            System.out.println("my grade is D ");

            // if the range is less than 60 then the grade is F
        }else if (grade < 60){
            System.out.println("my grade is F");

        }// end if condition

    }// end of main method

}// end of java
