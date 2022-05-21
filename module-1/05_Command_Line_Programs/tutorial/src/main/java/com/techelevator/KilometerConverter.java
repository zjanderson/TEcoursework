package com.techelevator;

import java.util.Scanner;

public class KilometerConverter {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

            System.out.println("Enter a kilometer value at which to start: ");
            String value = input.nextLine();
            int kilometerStartPoint = Integer.parseInt(value);

            System.out.println("Enter a kilometer value at which to end: ");
            value = input.nextLine();
            int kilometerEndPoint = Integer.parseInt(value);

            System.out.println("How many km by which to increment: ");
            value = input.nextLine();
            int incrementBy = Integer.parseInt(value);


        System.out.println("Going from " + kilometerStartPoint + "km to " + kilometerEndPoint + "km in increments of " + incrementBy + "km.");

        for (int km = kilometerStartPoint; km <= kilometerEndPoint; km += incrementBy ) {

            double miles =  kilometersToMiles(km);
            System.out.println(km + "km is " + miles + "mi.");
        }



    }
    public static double kilometersToMiles(int kilometers) {
        final double MILES_PER_KILOMETER = 0.621371;
        return kilometers * MILES_PER_KILOMETER;
    }

    
}
