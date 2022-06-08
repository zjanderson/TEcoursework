package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Review {

    public static void main(String[] args) {
        Scanner keyboardInput = new Scanner(System.in);

        System.out.print("Please enter your name, age, and favorite animal >>> ");

        String userInput = keyboardInput.nextLine();

        System.out.println(userInput);

        String[] arguments = userInput.split(", ");

        for(String arg : arguments) {
            System.out.println(arg);
        }

//        File f = new File("new_file.txt");
//        try (PrintWriter writer = new PrintWriter(f)) {
//            writer.println("blah blah blah");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try (FileOutputStream outputStream = new FileOutputStream(f, true);
//             PrintWriter writer = new PrintWriter(outputStream)) {
//            writer.println("blah blah blah");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }




    }

}
