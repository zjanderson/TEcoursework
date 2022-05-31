package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		//		The Fibonacci numbers are the integers in the following sequence:
		//
		//		0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
		//
		//		By definition, the first two numbers in the Fibonacci sequence are 0 and 1, and each subsequent number
		//		is the sum of the previous two:
		//
		//		0 + 1 = 1
		//		1 + 1 = 2
		//		1 + 2 = 3
		//		2 + 3 = 5
		//		3 + 5 = 8
		//
		//		Write a command-line program which prompts the user for an integer value and display
		//		the Fibonacci sequence leading up to that number:
		//

		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter a maximum number: ");
		String limitInput = userInput.nextLine();

		long limit = Long.parseLong(limitInput);
		long previousNumber = 0;
		long currentNumber = 1;

		System.out.print("0");

		while (  (previousNumber + currentNumber) <= limit){
			System.out.print(", " + currentNumber);

			long nextNumber = (previousNumber + currentNumber);
			previousNumber = currentNumber;
			currentNumber = nextNumber;
		}
	}

}
