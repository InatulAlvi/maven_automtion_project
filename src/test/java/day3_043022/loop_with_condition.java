package day3_043022;

import net.bytebuddy.implementation.bytecode.ByteCodeAppender;

import java.util.ArrayList;

public class loop_with_condition {
    public static void main(String[] args) {
        // create  an array with fruits and print only when fruit is apple or orange
        ArrayList<String>fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("orange");
        fruits.add("grape");
        fruits.add("strawberry");

        for (int i = 0; i < fruits.size(); i++){
            // with if conditions

            if (fruits.get(i) == "apple"){
                System.out.println("my fruit is " + fruits.get(i));
            }else if (fruits.get(i) == "grape"){
                System.out.println(" my fruit is " + fruits.get(i));
            }

            // with or operator
/*
            if (fruits.get(i) == "apple" || fruits.get(i) == "grape"){
                System.out.println(" my fruit is " + fruits.get(i));
            }
*/
        }// end of for loop

    }// end of main

}// end of java
