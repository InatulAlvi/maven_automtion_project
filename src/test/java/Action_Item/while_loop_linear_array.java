package Action_Item;

public class while_loop_linear_array {

    public static void main(String[] args) {
        // creat string array for region
        String[] Region = new String[] {"MX", "NJ", "DC", "CT", "PA", "AL"};

        // creat an int array for AreaCode
        int[] AreaCode = new int[] {5255, 201, 202, 203, 215, 205};

        // initialize your starting point before calling while loop
        int i = 0;
        // define the end point in while loop
        while (i < AreaCode.length){
            System.out.println("my region is " + Region [i] + " and my area code is " + AreaCode[i]);
            
            // incrementing
            i = i +1;

        }// end of while loop

    }// end of main method
}// end of java
