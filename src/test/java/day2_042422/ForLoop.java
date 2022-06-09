package day2_042422;

import java.util.ArrayList;

public class ForLoop {
    public static void main(String[] args) {
        // creat and arraylist for cities and loop/interating through all the values using for loop
        ArrayList<String> cities = new ArrayList<>();
        cities.add("brooklyn");
        cities.add("manhattan");
        cities.add("bronx");
        cities.add("queens");
        cities.add("long island");
        cities.add("staten island");

        for (int i = 0; i < cities.size(); i++){
            System.out.println("i is now " + i);
            System.out.println("my city is " + cities.get(i));
        } // end of for loop

    } // end of main method

} // End of java
