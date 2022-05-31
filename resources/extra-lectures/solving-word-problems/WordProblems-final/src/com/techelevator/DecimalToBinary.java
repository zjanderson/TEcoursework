package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DecimalToBinary {

	//	Write a command-line program which prompts the user for a series of decimal integer values separated by spaces. Display each decimal integer along with its equivalent binary value.
	//
	//	Please enter in a series of decimal values (separated by spaces): 460 8218 1 31313 987654321
	//
	//			460 in binary is 111001100
	//			8218 in binary is 10000000011010
	//			1 in binary is 1
	//			31313 in binary is 111101001010001
	//			987654321 in binary is 111010110111100110100010110001
	//
	public static void main(String[] args) {

		ConvertDecimalToBinary();
		ConvertBinaryToDecimal();

	}




	private static void ConvertDecimalToBinary() {

		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter in a series of decimal values (separated by spaces): ");
		String input = userInput.nextLine();

		// Split the string
		String[] numbersAsStrings = input.split(" ");

		for (int ix = 0; ix < numbersAsStrings.length; ix++) {
			int decimal = Integer.parseInt(numbersAsStrings[ix]);

		   List<String> binary = new ArrayList<>() ;

			while(decimal > 0){
				Integer temp = (decimal % 2);
				binary.add(temp.toString());
				decimal = decimal/2;
			}

			String result = "";
			for(int i = binary.size() -1;i >= 0;i--){
				result += binary.get(i);
			}

			String[] resultArray = binary.toArray(new String[0]);


			System.out.println(numbersAsStrings[ix] + " in binary is " + result);
		}
	}

	private static void ConvertBinaryToDecimal() {

		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter a binary number: ");
		String input = userInput.nextLine();

		int result = BinaryToInteger(input);

		int easyResult = BinaryToIntegerEasy(input);

		System.out.println(input + " in binary is " + result + " the hard way");
		System.out.println(input + " in binary is " + easyResult + " the easy way");
	}

	public static int BinaryToInteger(String binary) {
		long decimal = 0;
		for (int i = binary.length() - 1; i >= 0; i--) {
			if (binary.charAt(i) == '1') {
				decimal += Math.pow(2, (binary.length() - i - 1));
			}
		}
		return (int)decimal;
	}

	public static int BinaryToIntegerEasy(String binary){
		return Integer.parseInt(binary, 2);
	}
}