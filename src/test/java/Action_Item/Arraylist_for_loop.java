package Action_Item;


import java.util.ArrayList;

public class Arraylist_for_loop {

    public static void main(String[] args) {
        // creat an ArrayList for country
        ArrayList<String> country = new ArrayList<>();
        country.add("usa");
        country.add("india" );
        country.add("srilanka");
        country.add("bangladesh");
        country.add("nepal");
        // creat loop through all the value using for loop
        for (int i = 0; i < country.size(); i++) {

        }//end of for loop

            // creat integer ArrayList for CountryCode
            ArrayList<Integer> CountryCode = new ArrayList<Integer>();
            CountryCode.add(1);
            CountryCode.add(997);
            CountryCode.add(110);
            CountryCode.add(880);
            CountryCode.add(60);
            // creat a loop through all the value using for loop
            for (int i = 0; i < CountryCode.size(); i++){

                System.out.println("my country name is " + country.get(i) + " and my country code is " + CountryCode.get(i));
            }// end of for loop


        }// end of main method

    }// end of java






