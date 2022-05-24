package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {

		// lengthMeters = lengthFeet * 0.3048;
		// lengthFeet = lengthMeters * 3.2808399;

		Scanner input = new Scanner(System.in);

		System.out.println("Please enter the length: ");
		String userInput = input.nextLine(); //user input given
		 double givenLength = Double.parseDouble(userInput);

		System.out.println("Is the length in (M)eters, or (F)eet? ");
		userInput = input.nextLine();
		//char mOrF = Char.parseChar(userInput);

		boolean isMeters = (userInput == "M");
		if (isMeters) {
			double lengthMeters = givenLength;
			double lengthFeet = (lengthMeters * 3.2808399);
			System.out.println(givenLength + " meters is " + lengthFeet + "feet.");
		} else {
			double lengthFeet = givenLength;
			double lengthMeters = (lengthFeet * 0.3048);
			System.out.println(givenLength + " feet is " + lengthMeters + "meters.");
		} 

		//Double.parseDouble(userInput);  //takes the string from the scanner input and makes it into a double


	}

}
