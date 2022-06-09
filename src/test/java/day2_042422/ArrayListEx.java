package day2_042422;

import java.util.ArrayList;

public class ArrayListEx {
    public static void main(String[] args) {
        // creat an Arraylist for countries
        ArrayList<String> countries = new ArrayList<>();
        countries.add("usa"); // value number 0
        countries.add("india" ); // value number 1
        countries.add("srilanka"); // value number 2
        countries.add("bangladesh"); // value number 3
        countries.add("nepal"); // value number 4
        countries.add("england"); // value number 5

        // I want to print 4th value from the list
        System.out.println("my first country is " + countries.get(0) + " my home country is " + countries.get(3) + " my last country is " + countries.get(5));

    }// end of main method
}// end of java
