package Action_Item;

import java.util.ArrayList;
import java.util.concurrent.LinkedTransferQueue;

public class loop_with_condition {
    public static void main(String[] args) {
        // create an array with cities and print only when the city is brooklyn or manhattan
        ArrayList<String>cities = new ArrayList<>();
        cities.add("brooklyn");
        cities.add("queens");
        cities.add("bronx");
        cities.add("staten island");
        cities.add("manhattan");
        cities.add("long island");

        for (int i = 0; i < cities.size(); i ++){
            // with if condition
/*
            if (cities.get(i) == "brooklyn"){
                System.out.println("my city is " + cities.get(i));
            }else if (cities.get(i) == " manhattan "){
                System.out.println("my city is " + cities.get(i));

            }// end of if condition
            */
            // with or operator
            if (cities.get(i) == "brooklyn" || cities.get(i) == "manhattan"){
                System.out.println("my city is " + cities.get(i));

            }// end of with or operator


        }// end of for loop

    }// end of main method

}// end of java

