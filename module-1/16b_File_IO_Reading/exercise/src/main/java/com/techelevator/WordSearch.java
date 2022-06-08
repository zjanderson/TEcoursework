package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) {

		/*
        Prompt the user for a filesystem path, a word for which to search, and whether the search is case-sensitive
         */
		// Create a scanner for user input
		Scanner userInput = new Scanner(System.in);
		// Prompt the user for a file path - path should look like "alices_adventures_in_wonderland.txt"
		System.out.println("Enter path to the searchable file: ");
		String filePath = userInput.nextLine();
		System.out.println("Enter the word you wish to find: ");
		String findWord = userInput.nextLine();
		System.out.println("Should the search be case sensitive? (Y or N)");
		String caseSensitive = userInput.nextLine();

		/*
        Open the file, handle errors
         */
		// Create a File object using the given path
		File fileToSearch = new File(filePath);

		int lineNumber = 0;          // number of lines that are read in the file, returned along with the line text

//		boolean isCaseNeeded;  // we need to determine whether we are searching case-sensitive or not

//		if (isCaseNeeded = caseSensitive.contentEquals("Y")) {
//
//			}


		////////
		// Open the file we want to search
		try (Scanner fileInput = new Scanner(fileToSearch)) {
            /* Loop until the end of file is reached
            Create a read loop and process the lines
            Loop until the end of file is reached */
			while (fileInput.hasNextLine()) {
				// Read the next line into 'lineOfText'
				String lineOfText = fileInput.nextLine();
				lineNumber++;  // Increment the line count.

				if (caseSensitive.equals("Y") || (caseSensitive.equals("y"))) {

					if (lineOfText.contains(findWord)) {
						System.out.println(lineNumber + ": " + lineOfText);  // Print the line containing searched word
					}
				}else if (caseSensitive.equals("N") || (caseSensitive.equals("n"))) { //have to adjust for no case sensitivity
					if (lineOfText.toLowerCase().contains(findWord.toLowerCase())) {
						System.out.println(lineNumber + ": " + lineOfText);  // Print the line containing searched word
					}

				}


			}

		} catch (FileNotFoundException e) {
			// Could not find the file at the specified path.
			System.out.println("The file was not found: " + fileToSearch.getAbsolutePath());
		}

	}

}
