package com.techelevator;

import java.util.Scanner;
public class MartianWeight {
    /*
    In case you've ever pondered how much you weigh on Mars, here's the calculation:
         Wm = We * 0.378
         where 'Wm' is the weight on Mars, and 'We' is the weight on Earth

    Write a command line program which accepts a series of Earth weights from the user
    and displays each Earth weight as itself, and its Martian equivalent.

    $ MartianWeight

    Enter a series of Earth weights (space-separated): 98 235 185

     98 lbs. on Earth is 37 lbs. on Mars.
     235 lbs. on Earth is 88 lbs. on Mars.
     185 lbs. on Earth is 69 lbs. on Mars.
     */
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter a series of Earth weights (space-separated): ");
        String inputWeights = userInput.nextLine();
        String[] earthWeights = inputWeights.split(" ");

        // Enter a series of Earth weights (space-separated): 98 235 185
        for (int i = 0; i < earthWeights.length; i++) {
            int earthWeight = Integer.parseInt(earthWeights[i]);
            int martianWeight = (int) (earthWeight * .378);

            System.out.println(earthWeight + " lbs. on Earth is " + martianWeight + " lbs. on Mars.");
        }
    }
}
