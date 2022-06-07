package com.techelevator;

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) {

//		Scanner userInput = new Scanner(System.in);
//
//		/*
//		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
//		 * modify file system objects.
//		 *
//		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
//		 *
//		 * A new instance of File can be created from a String that contains a file system path
//		 */
//
//		System.out.print("Enter file or dir path: ");
//		String path = userInput.nextLine();  // blocking call, waits for use to enter and hit return
//
//		File f = new File(path);   // file is inside java.io --> import (here auto-imported above)
//
//
//		/* ***************************
//		 * INSPECTING THE FILESYSTEM
//		 * ***************************/
//		if (f.exists()) {
//			System.out.println("The file or directory exists!");
//			System.out.println("name: " + f.getName());
//			System.out.println("absolute path: " + f.getAbsolutePath());
//
//			if(f.isDirectory()) {
//				System.out.println("This is a directory.");
//			} else if (f.isFile()){
//				System.out.println("The size of the file is " + f.length());
//			}
//
//		} else {
//			System.out.println("The file or directory does not exist.");
//		}
//
//		/* ************************
//		 * CREATING A DIRECTORY
//		 * ************************/
//		System.out.println();
//		System.out.println("Let's create a new dir");
//		System.out.print("Enter the path for a new directory >>>");
//		path = userInput.nextLine();
//
//		File newDirectory = new File(path);
//
//		if (newDirectory.mkdir()) {
//			System.out.println("The directory was created");
//		} else {
//			System.out.println("The directory was not created");
//		}
//
//
//		/* ************************
//		 * CREATING A FILE
//		 * ************************/
//
//		System.out.println();
//		System.out.println("Let's create a new file!");
//		System.out.print("Enter the path for a new file >>>");
//		path = userInput.nextLine();
//
//		File newFile = new File(path);
//
//		try {
//			if (newFile.createNewFile()) {
//				System.out.println("The file was created");
//			} else {
//				System.out.println("The file was not created");
//			}
//		} catch (IOException e) {
//			System.out.println("The file was not created");
//			e.printStackTrace();  //may not want to do this depending on scenario... sensitive info
//			//may be printed to user
//		}
//
//
//		/* ************************
//		 * WRITING TO A FILE
//		 * ************************/
//		System.out.println();
//		System.out.println("Let's write some stuff to a file.");
//		System.out.print("Enter a message to put into the new file. >>>" );
//
//		String message = userInput.nextLine();
//
//		try (PrintWriter writer = new PrintWriter(newFile)) {
//			writer.println(message);
//
//			writer.flush(); // manually flushes buffer
//
//			writer.println(message);
//
//		} catch (FileNotFoundException e) {
//			System.out.println("The file does not exist.");;
//		}
//
//		/* ************************
//		 * FLUSHING THE BUFFER
//		 * ************************/
//
//
//		/* ************************
//		 * APPENDING TO A FILE
//		 * ************************/
//		System.out.println("Let's append to a file.");
//		System.out.println("Enter a message to append >>> ");
//
//		message = userInput.nextLine();
//		try (PrintWriter writer = new PrintWriter(new FileOutputStream(newFile, true))) {
//
//			writer.println(message);
//			writer.println(message);
//			writer.println(message);
//
//		} catch (IOException e) {
//			System.out.println("The file was not found.");
//		}
//
//		/* ************************
//		 * READING FROM A FILE, WHILE WRITING TO ANOTHER
//		 * ************************/
//
//		try (PrintWriter writer = new PrintWriter(new FileOutputStream("test2.txt"));
//			Scanner fileScanner = new Scanner(new File("test.txt"))) {
//				while (fileScanner.hasNextLine()) {
//					String line = fileScanner.nextLine();
//					writer.println(line);
//				}
//		} catch (IOException e) {
//			System.out.println("Sorry, an IO exception occurred.");
//		}

		/*
			READING ALL LINES, WRITING ALL LINES
		 */

		File testFile = new File("test.txt");
		try {
			List<String> lines = Files.readAllLines(testFile.toPath()); // read each line in a file into a list of strings where each line is a new string element
			System.out.println("Lines are: " + lines);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			List<String> lines = List.of("line 1", "line 2", "line 3"); // create list of strings

			Files.write(testFile.toPath(), lines); // write each string in list as a line in a file
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
