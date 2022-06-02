package com.techelevator.farm;

import java.util.Scanner;

public class Farm {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("What type of animal would you like to add to your farm? (Cow, Pig, Chicken) ");

        String typeOfAnimal = scanner.nextLine();

        FarmAnimal animal = FarmAnimal.create(typeOfAnimal);

        if(animal == null) {
            System.out.println("Invalid choice.");
            System.exit(0);
        }

        System.out.println(animal);
    }

}
