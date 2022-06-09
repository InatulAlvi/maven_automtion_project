package day_050722;

public class splitMessage {

    public static void main(String[] args) {
        // declare string variable
        String splitMessage = "My Name Is John ";
        // declare an array of string to store the string split
        String[] splitMessageArray = splitMessage.split(" ");
        // print out john to console
        System.out.println("my first name is " + splitMessageArray[3]);

    }// end of main method

}// end of java
