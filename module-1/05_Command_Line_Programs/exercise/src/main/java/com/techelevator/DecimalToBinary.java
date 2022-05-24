package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {

		/*
		53 -> ???

		53 % 2 = 1, store the one, cut in half  1
		26 / 2 = 26

		26 % 2 = 0                              0
		26/2 = 13

		13 % 2 =                               1
		13/2 = 6 (integers only)

		6 % 2 =                                1
		6/2 = 3

		3 % 2 =                                1
		3 / 2 = 1 (int only)

		1 % 2 =                                1
		1 / 2 = 0

		read from bottom to top
		 */



		Scanner input = new Scanner(System.in);
		System.out.println("Please enter in a series of decimal values (separated by spaces): ");
		String givenValues = input.nextLine();
		String[] allValues = givenValues.split(" "); //this is as far as i got on my own

		//walt suggests foreach loop

		for (String allvalue : allValues) {
			int valueToConvert = Integer.parseInt(allvalue);
			String binary = "";

			int original = valueToConvert;
			while(valueToConvert > 0) {
				int binaryValue = valueToConvert % 2;
				valueToConvert = valueToConvert/2;
				binary = binaryValue + binary;

			}
			System.out.println("Decimal: " + allvalue + " in binary is " + binary);
		}


	}

}
