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
			
			boolean isCelsiius = (response ==  "C");

			boolean isCelsiius1 = isCelsiius;
			if (isCelsiius) {
				int temperatureCelsius = givenTemperature;
				double temperatureFarenheit = (temperatureCelsius * 1.8) + 32;
				
				
				System.out.println(givenTemperature + "C is " + temperatureFarenheit + "F");
			} else {
				int temperatureFarenheit = givenTemperature;
				double temperatureCelsius = (temperatureFarenheit - 32) / 1.8;


			System.out.println(givenTemperature + "F is " + temperatureCelsius + "C");
			}
			System.out.println();

	}

}
