package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args) {

        // Create a scanner for user input
        Scanner userInput = new Scanner(System.in);

        System.out.println("What is the search word? ");
        String searchWord = userInput.nextLine();
        System.out.println("What is the replacement word? ");
        String replacementWord = userInput.nextLine();
        // The following must be existing file. If user enters invalid source file, program indicates this to user & exits.
        System.out.println("What is the source file? ");
        String sourceFile = userInput.nextLine();

        File file = new File(sourceFile);
        if (!file.exists()) {
            System.out.println("This file does not exist, please enter a valid file path");
            return;
        }

        // Following creates copy of source file w/requested replacements at this path. If the file exists, overwrite it.
        // If the user enters an invalid destination file, the program indicates this to the user and exits.
        System.out.println("What is the destination file? ");
        String destinationFile = userInput.nextLine();

        try (Scanner dataInput = new Scanner(file); //this opens the file we're reading from
             PrintWriter dataOutput = new PrintWriter(destinationFile)) { //this opens the file for writing/overwriting
            while (dataInput.hasNextLine()) {
                String lineOfInput = dataInput.nextLine();
                dataOutput.println(lineOfInput.replace(searchWord, replacementWord));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Cannot create the destination file.");
            e.printStackTrace();
        }


    }

}
