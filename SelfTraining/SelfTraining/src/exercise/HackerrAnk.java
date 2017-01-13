package exercise;

import java.util.Scanner;

public class HackerrAnk {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double mealCost = scan.nextDouble(); // original meal price
        int tipPercent = scan.nextInt(); // tip percentage
        int taxPercent = scan.nextInt(); // tax percentage
        scan.close();
        
        float tip =  (float) ((tipPercent/100)*mealCost);
        float tax =   (float) ((taxPercent/100)*mealCost);
        double mealCostFinal =  mealCost + tip + tax;
        
        System.out.println(tip+" "+tax);      
        // Write your calculation code here.
      
        // cast the result of the rounding operation to an int and save it as totalCost 
        int totalCost = (int) Math.round(mealCostFinal);
        System.out.println(totalCost);
      
        // Print your result
    }
}