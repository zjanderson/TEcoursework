package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Please enter a whole number:");
		String response = input.nextLine();
		int givenInteger = Integer.parseInt(response);

		if (givenInteger < 1) {
			System.out.println(); //blank line for spacing
			System.out.println("0, 1");
		} else if (givenInteger == 1){
			System.out.println(); //blank line for spacing
			System.out.println("0, 1, 1");
		} else { //use a while loop to generate fibonacci sequence up to and inc givenInteger
			int fibNumInit = 0;
			int fibNumNext = 1;
			while (fibNumInit <= givenInteger) {
				System.out.print(fibNumInit + " ");
				int nextNum = fibNumInit + fibNumNext;
				fibNumInit = fibNumNext;
				fibNumNext = nextNum;
			}
			System.out.print(givenInteger);

		}

	}

}
