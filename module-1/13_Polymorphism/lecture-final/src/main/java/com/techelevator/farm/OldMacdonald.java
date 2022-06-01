package com.techelevator.farm;

import java.util.*;

public class OldMacdonald {

	public static void printListContents(List<String> list) {

	}

	public static void main(String[] args) {
		List<String> names2 = new LinkedList<>();

		Map<String, String> namesToZips = new HashMap<>();
		Set<String> cards = new HashSet<>();


		FarmAnimal chicken = new Chicken();

		FarmAnimal[] farmAnimals = new FarmAnimal[] { new Cow(), new Chicken(), chicken };

		for (FarmAnimal animal : farmAnimals) {
			String name = animal.getName();
			String sound = animal.getSound();

			if (animal.getClass().equals(Chicken.class)) {
				Chicken myChicken = (Chicken) animal;
				myChicken.layEgg();
			}

			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}



		Farm myFarm = new Farm();

		myFarm.addFarmAnimal(new Cow());
		myFarm.addFarmAnimal(new Chicken());
		myFarm.addFarmAnimal(new Pig());
		myFarm.addFarmAnimal(new Goat("Horace"));



		Chicken myFarmAnimal = new Chicken();

		myFarmAnimal.getName();
		myFarmAnimal.getSound();
		myFarmAnimal.layEgg();



		Singable[] singables = new Singable[] { new Goat("Billy"), new Tractor() };
		for (Singable mySingable : singables) {
			System.out.println(mySingable.getSound());
		}


	}
}