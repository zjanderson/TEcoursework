package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		Map<String, String> namesToZip = new HashMap<>(); //this creates new Map
		namesToZip.put("David", "44120");
		namesToZip.put("Dan", "44124");
		namesToZip.put("Elizabeth", "44012");
		System.out.println();

		for(String key : namesToZip.keySet()) {
			System.out.println("Key: " + key + ", Value: " + namesToZip.get(key));
		}
		System.out.println();

		System.out.println("Zip code for David is " + namesToZip.get("David"));
		namesToZip.put("David", "44124");
		System.out.println("Zip code for David is " + namesToZip.get("David"));
		System.out.println();

		if (namesToZip.containsKey("Dan")) {  //remember, keys are case-sensetive!
			System.out.println("Dan exists in the map!");
		}
		System.out.println();

		String zipCodeForDan = namesToZip.remove("Dan");
		System.out.println("Zip code for Dan: " + zipCodeForDan);
		System.out.println();

		for(String key : namesToZip.keySet()) {
			System.out.println("Key: " + key + ", Value: " + namesToZip.get(key));
		}
		System.out.println();

		if (namesToZip.isEmpty()) {
			System.out.println("The map is empty!");
		} else {
			System.out.println("The map is not empty");
		}
		System.out.println();

		//namesToZip.clear(); //this would clear the entire thing

		if (namesToZip.isEmpty()) {
			System.out.println("The map is empty");
		} else {
			System.out.println("The map is not empty");
		}
		System.out.println();

		System.out.println("Size of map: " + namesToZip.size());
		System.out.println();

		for (Map.Entry<String, String> kvPair : namesToZip.entrySet()) {  //this is another way
			System.out.println("Key: " + kvPair.getKey() + ", Value: " + kvPair.getValue() );
		}
		System.out.println();




		// using List.of() will create an unmodifiable list, same with Map.of(), FYI



		Map<String, String> dictionary = new HashMap<>();
		dictionary.put("Java", "A cup of coffee; a programming language.");
		dictionary.put("C#", "A musical note; a programming language");

		Map<String, List<String>> dictionaryEnhanced = new HashMap<>();

		List<String> javaDefinitions = new ArrayList<>();
		javaDefinitions.add("A cup of coffee");
		javaDefinitions.add("A programming language");

		dictionaryEnhanced.put("Java", javaDefinitions);

		List<String> cSharpDefinitions = new ArrayList<>();
		cSharpDefinitions.add("A musical note");
		cSharpDefinitions.add("A programming language");

		dictionaryEnhanced.put("C#", cSharpDefinitions);
		System.out.println();



		System.out.println("####################");
		System.out.println("        SETS");
		System.out.println("####################");
		System.out.println();



		Set<String> names = new HashSet<>();  //use linkedHashSet if you want order preserved

		names.add("Walt");
		names.add("Nick");
		names.add("Sasi");
		names.add("Anthony");

		for (String n : names) {
			System.out.println(n);
		}
		System.out.println();

		names.remove("Nick");
		for (String n : names) {
			System.out.println(n);
		}
		System.out.println();


		if (names.contains("Anthony")) {
			System.out.println("Anthony does exist in my Set.");
		}
		System.out.println();

		System.out.println("Size of names Set is "  + names.size());
		System.out.println();


		names.clear(); //deletes everything in names








	}
	//example: letterCounts ("aardvark") -> {"a" -> 3, "r" -> 2, "d" -> 1 }
	public static Map<String, Integer> letterCounts(String word) {

		return null;

	}
	/*
	examples:
	collectionHasDuplicates([1, 2, 3, 6, 4, 6]) -> true
	collectionHasDuplicates([1, 2, 3, 4, 5, 6]) -> false

	*/
	public static boolean collectionHasDuplicates(int[] numbers) {
		Set<Integer> numberSet = new HashSet<>(); //creates empty set

		for (int n : numbers) { //enhanced for loop, we're seaching the set 'numbers' for an integer 'n'
			if (numberSet.contains(n)) {
				return true;
			}
			numberSet.add(n);
		}
		return false;
	}

}
