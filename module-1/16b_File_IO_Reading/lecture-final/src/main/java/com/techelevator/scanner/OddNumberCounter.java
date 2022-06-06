package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OddNumberCounter {
	
	public static void main(String[] args)  {
		
		File inputFile = getInputFileFromUser();

		printApplicationBanner();

		try(Scanner fileScanner = new Scanner(inputFile)) {
			while(fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();

				int oddCount = oddCount(line);
				System.out.println(line + " has " + oddCount + " odd numbers.");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Sorry the file did exist at one point.");
		}
	}

	private static void printApplicationBanner() {
		System.out.println("************************");
		System.out.println("Odd Number Counter 9000");
		System.out.println("************************");
		System.out.println();
	}

	@SuppressWarnings("resource")
	private static File getInputFileFromUser() {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter path to input file >>> ");
		String path = userInput.nextLine();
		
		File inputFile = new File(path);
		if(!inputFile.exists()) { // checks for the existence of a file
			System.out.println(path+" does not exist");
			System.exit(1); // Ends the program
		} else if(!inputFile.isFile()) {
			System.out.println(path+" is not a file");
			System.exit(1); // Ends the program
		}
		return inputFile;
	}

	private static int oddCount(String number) {
		int oddNumberCount = 0;

		for(int i = 0; i < number.length(); i++) {
			int digit = Integer.parseInt(number.substring(i, i + 1));

			if (digit % 2 == 1) {
				oddNumberCount++;
			}
		}

		return oddNumberCount;
	}
}
