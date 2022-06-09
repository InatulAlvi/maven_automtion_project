package day2_042422;

public class WhileLoop {
    public static void main(String[] args) {
        // iterate through zipcode and its street number using linear array and while loop
        String[] zipCodes = new String[]{"11218", "11219", "10307", "10001"};
        int[] houseNumber = new int[]{111, 222, 103, 558};

        // initialize your starting point before calling while loop
        int i  = 0;
        // define the end point in while loop
        while (i < zipCodes.length){
            System.out.println("my zip code is " + zipCodes[i] + " my house number is " + houseNumber[i]);

            // incrementing
            i = i =i;
        }// end of while loop
    }// end of main method
}// end of java
