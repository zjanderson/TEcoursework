package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

			System.out.println("Please enter the temperature: ");
			String response = input.nextLine();
			int givenTemperature = Integer.parseInt(response);

			System.out.println("Is the temperature in (C)elsius, or (F)ahrenheit? ");
			response = input.nextLine();

		System.out.println();

	}

}
