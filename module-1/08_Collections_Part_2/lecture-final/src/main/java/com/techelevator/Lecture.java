package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();


		Map<String, String> namesToZips = new HashMap<>();

		namesToZips.put("David", "44120");
		namesToZips.put("Dan", "44124");
		namesToZips.put("Elizabeth", "44012");

		for (String key : namesToZips.keySet()) {
			System.out.println("Key: " + key + ", Value: " + namesToZips.get(key));
		}

		System.out.println();

		System.out.println("Zip code for David is " + namesToZips.get("David"));
		namesToZips.put("David", "44124");
		System.out.println("Zip code for David is " + namesToZips.get("David"));

		if (namesToZips.containsKey("Dan")) {
			System.out.println("Dan exists in the map!");
		}

		String zipCodeForDan = namesToZips.remove("Dan");
		System.out.println();
		System.out.println("Zip code for Dan is: " + zipCodeForDan);
		System.out.println();

		for (String key : namesToZips.keySet()) {
			System.out.println("Key: " + key + ", Value: " + namesToZips.get(key));
		}

		System.out.println("Size of map: " + namesToZips.size());

		if (namesToZips.isEmpty()) {
			System.out.println("The map is empty");
		} else {
			System.out.println("The map is not empty");
		}

		namesToZips.clear();

		if (namesToZips.isEmpty()) {
			System.out.println("The map is empty");
		}

		System.out.println("Size of map: " + namesToZips.size());

		for (Map.Entry<String, String> kvPair : namesToZips.entrySet()) {
			System.out.println("Key: " + kvPair.getKey() + ", Value: " + kvPair.getValue());
		}

		/*
			[ 5, 15, 25, 100, -100, 0 ]


			"David"     -> "44120"
			"Dan"       -> "44124"
			"Elizabeth" -> "44012"


			"Dan" -> math -> integer value  (1050)
			"David" -> math -> integer value (1050)
			"Elizabeth" -> math -> integer value (55)

			"Dan", "David" -> 1050 -> { "Dan" -> "44124", "David", "44120" }



			entrySet() -> { { "David" -> "44120" }, { "Dan" -> "44124" }, { "Elizabeth" -> "44012" } }
			keySet() -> { "David", "Dan", "Elizabeth" }
		 */


		Map<String, String> dictionary = new HashMap<>();

		dictionary.put("Java", "A cup of coffee; a programming language.");
		dictionary.put("C#", "A musical note; a programming language.");

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
		System.out.println("        SETS ");
		System.out.println("####################");
		System.out.println();

		Set<String> names = new HashSet<>();

		names.add("Walt");
		names.add("Nick");
		names.add("Sasi");
		names.add("Anthony");

		for (String n : names) {
			System.out.println(n);
		}

		System.out.println("Size of names Set is " + names.size());

		names.remove("Nick");

		System.out.println();

		for (String n : names) {
			System.out.println(n);
		}

		if (names.contains("Anthony")) {
			System.out.println("Anthony does exist in my Set");
		}

		System.out.println("Size of names Set is " + names.size());

		names.clear();



	}

	/*

		Example:
		letterCounts("aardvark") -> { "a" -> 3, "r" -> 2, "d" -> 1 }
	 */
	public static Map<String, Integer> letterCounts(String word) {
		return null;
	}


	/*
		Examples:
		collectionHasDuplicates([ 1, 2, 3, 6, 5, 6 ]) -> true
		collectionHasDuplicates([ 1, 2, 3, 4, 5, 6 ]) -> false


		numbers -> [ 1, 2, 3, 6, 5, 6 ]
		                            ^

		numberSet  -> { 1, 2, 3, 6, 5 }

		numberList -> { 1, 2, 3, 6, 5 }
		                            ^

	 */
	public static boolean collectionHasDuplicates(int[] numbers) {
		Set<Integer> numberSet = new HashSet<>();

		for (int n : numbers) {
			if (numberSet.contains(n)) {
				return true;
			}

			numberSet.add(n);
		}

		return false;
	}


	/*

		O(1)
		O(log(n))
		O(n)
		O(n*log(n))
		O(n^2)
		O(2^n)
		O(n!)


	 */
}
