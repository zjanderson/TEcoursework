package com.techelevator;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Exercises {

	/*
	 * Given the name of an animal, return the name of a group of that animal
	 * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
	 *
	 * The animal name should be case insensitive so "elephant", "Elephant", and
	 * "ELEPHANT" should all return "Herd".
	 *
	 * If the name of the animal is not found, null, or empty, return "unknown".  <-- this is edge case
	 *
	 * Rhino -> Crash
	 * Giraffe -> Tower
	 * Elephant -> Herd
	 * Lion -> Pride
	 * Crow -> Murder
	 * Pigeon -> Kit
	 * Flamingo -> Pat
	 * Deer -> Herd
	 * Dog -> Pack
	 * Crocodile -> Float
	 *
	 * animalGroupName("giraffe") → "Tower"
	 * animalGroupName("") -> "unknown"
	 * animalGroupName("walrus") -> "unknown"
	 * animalGroupName("Rhino") -> "Crash"
	 * animalGroupName("rhino") -> "Crash"
	 * animalGroupName("elephants") -> "unknown"
	 *
	 */
	public String animalGroupName(String animalName) {
//		Exercises e = new Exercises();
//		e.animalGroupName(null);  //I'm writing my own test for the following function
		if (animalName == null || animalName.equals("")) { //== for checking null, it's on the stack, and .equals for String on heap
			return "unknown";
		}

		Map<String, String> animalGroupings=new HashMap<>();
		animalGroupings.put("rhino", "Crash"); //put all the items from list in here, repeat for all animals lower case
		animalGroupings.put("giraffe", "Tower");
		animalGroupings.put("elephant", "Herd");
		animalGroupings.put("lion", "Pride");
		animalGroupings.put("crow", "Murder");
		animalGroupings.put("pigeon", "Kit");
		animalGroupings.put("flamingo", "Pat");
		animalGroupings.put("deer", "Herd");
		animalGroupings.put("dog", "Pack");
		animalGroupings.put("crocodile", "Float");




		animalName = animalName.toLowerCase(); //makes sure everything is lower case to streamline searching and eliminate errors

		if (animalGroupings.containsKey(animalName)) { //they give us the animal name
			return animalGroupings.get(animalName);
		}

		return "unknown";
	}

	/*
	 * Given a String item number (a.k.a. SKU), return the discount percentage if the item is on sale.
	 * If the item is not on sale, return 0.00.
	 *
	 * If the item number is empty or null, return 0.00.
	 *
	 * "KITCHEN4001" -> 0.20
	 * "GARAGE1070" -> 0.15
	 * "LIVINGROOM"	-> 0.10
	 * "KITCHEN6073" -> 0.40
	 * "BEDROOM3434" -> 0.60
	 * "BATH0073" -> 0.15
	 *
	 * The item number should be case insensitive so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
	 * should all return 0.20.
	 *
	 * isItOnSale("kitchen4001") → 0.20
	 * isItOnSale("") → 0.00
	 * isItOnSale("GARAGE1070") → 0.15
	 * isItOnSale("dungeon9999") → 0.00
	 *
	 */
	public double isItOnSale(String itemNumber) {  //we need to again convert all to lowercase for both
		Map<String, Double> gimmeDiscounts = new HashMap<>();

		gimmeDiscounts.put("kitchen4001", 0.20); //repeat this process for all items above
		gimmeDiscounts.put("garage1070", 0.15);
		gimmeDiscounts.put("livingroom", 0.10);
		gimmeDiscounts.put("kitchen6073", 0.40);
		gimmeDiscounts.put("bedroom3434", 0.60);
		gimmeDiscounts.put("bathoo73", 0.15);

		if (itemNumber == null || itemNumber.equals("")) {
			return 0.00;
		}

		itemNumber = itemNumber.toLowerCase();

		if (gimmeDiscounts.containsKey(itemNumber)) {
			return gimmeDiscounts.get(itemNumber);
		}


		return 0.00;
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
	 * but only if Paul has less than $10s.
	 *
	 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
	 *
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
	 *
	 */
	public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) { //we can make a new map or change orig one, can use .put or .replace
		int peterHas = peterPaul.get("Peter");
		int paulHas = peterPaul.get("Paul");  //they're giving us map peterPaul, we're just extracting the value here

		if ((peterHas <= 0) || paulHas >= 1000 ) {  //edge cases, return what's given to us
			return peterPaul;
		}

		paulHas = paulHas + (peterHas / 2);  //Paul gets half of Peter's money
		peterPaul.put("Paul", paulHas);    //we put that back into our map

		peterHas = peterHas - (peterHas / 2);
		peterPaul.put("Peter", peterHas);

		return peterPaul;
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has $50 or more, AND "Paul" has $100 or more,
	 * then create a new "PeterPaulPartnership" worth a combined contribution of a quarter of each partner's
	 * current worth.
	 *
	 * peterPaulPartnership({"Peter": 50000, "Paul": 100000}) → {"Peter": 37500, "Paul": 75000, "PeterPaulPartnership": 37500}
	 * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
	 *
	 */
	public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) {
		//new Map<String, Integer> peterPaulPartnership = new HashMap<>();
		int combinedCont;
		int peterHas = peterPaul.get("Peter");
		int paulHas = peterPaul.get("Paul");
		int paulCont = 0;
		int peterCont = 0;

		if ((peterHas < 5000) || (paulHas < 10000)) {
			return peterPaul;
		}
		peterCont = peterHas / 4;
		peterHas = peterCont * 3;
		peterPaul.put("Peter", peterHas);

		paulCont = paulHas / 4;
		paulHas = paulCont * 3;
		peterPaul.put("Paul", paulHas);

		combinedCont = peterCont + paulCont;
		peterPaul.put("PeterPaulPartnership", combinedCont);

		return peterPaul;
	}

	/*
	 * Given an array of non-empty Strings, return a Map<String, String> where for every different String in the array,
	 * there is a key of its first character with the value of its last character.
	 *
	 * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
	 * beginningAndEnding(["man", "moon", "main"]) → {"m": "n"}
	 * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d", "m": "t", "n": "t"}
	 */
	public Map<String, String> beginningAndEnding(String[] words) {

		Map<String, String> firstLastChar = new HashMap<>();

		for (int i = 0; i < words.length; i++) {
			String currentWord = words[i];
			char firstLetter = currentWord.charAt(0);
			char lastLetter = currentWord.charAt(currentWord.length()-1);
			String firstLetterString = Character.toString(firstLetter);
			String lastLetterString = Character.toString(lastLetter);

			firstLastChar.put(firstLetterString, lastLetterString);

			
		}
		
		return firstLastChar;
	}

	/*
	 * Given an array of Strings, return a Map<String, Integer> with a key for each different String, with the value the
	 * number of times that String appears in the array.
	 *
	 * ** A CLASSIC **
	 *
	 * wordCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
	 * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
	 * wordCount([]) → {}
	 * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
	 *
	 */
	public Map<String, Integer> wordCount(String[] words) {

		Map<String, Integer> numOfStrings = new HashMap<>();
		// a 1, b 1, a 2, c 2, b 3
		int counter = 1;

		for (int i = 0; i < words.length; i++) {

			if (numOfStrings.containsKey(words[i])) {
				counter++;
				//numOfStrings.put(words[i], counter);
			}else  {
				counter = 1;
			}

			numOfStrings.put(words[i], counter);

		}

		return numOfStrings;
	}

	/*
	 * Given an array of int values, return a Map<Integer, Integer> with a key for each int, with the value the
	 * number of times that int appears in the array.
	 *
	 * ** The lesser known cousin of the the classic wordCount **
	 *
	 * intCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 2, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
	 * intCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33: 4, 106: 1, 107: 3}
	 * intCount([]) → {}
	 *
	 */
	public Map<Integer, Integer> integerCount(int[] ints) {
		return null;
	}

	/*
	 * Given an array of Strings, return a Map<String, Boolean> where each different String is a key and value
	 * is true only if that String appears 2 or more times in the array.
	 *
	 * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a": true}
	 * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
	 * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
	 *
	 */
	public Map<String, Boolean> wordMultiple(String[] words) {
		return null;
	}

	/*
	 * Given two Maps, Map<String, Integer>, merge the two into a new Map, Map<String, Integer> where keys in Map2,
	 * and their int values, are added to the int values of matching keys in Map1. Return the new Map.
	 *
	 * Unmatched keys and their int values in Map2 are simply added to Map1.
	 *
	 * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11, "SKU4": 5})
	 * 	 → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
	 *
	 */
	public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse,
			Map<String, Integer> remoteWarehouse) {
		return null;
	}

	/*
	 * Just when you thought it was safe to get back in the water --- last2Revisited!!!!
	 *
	 * Given an array of Strings, for each String, the count of the number of times that a subString length 2 appears
	 * in the String and also as the last 2 chars of the String, so "hixxxhi" yields 1.
	 *
	 * We don't count the end subString, but the subString may overlap a prior position by one.  For instance, "xxxx"
	 * has a count of 2, one pair at position 0, and the second at position 1. The third pair at position 2 is the
	 * end subString, which we don't count.
	 *
	 * Return Map<String, Integer>, where the key is String from the array, and its last2 count.
	 *
	 * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
	 *
	 */
	public Map<String, Integer> last2Revisited(String[] words) {

		//public int last2(String str) {
		//	int count = 0;
		//	for (int i = 0; i < str.length() - 2; i++) {
		//		if (str.substring(i, i + 2).equals(str.substring(str.length() - 2))) {
		//			count++;
		//		}
		//	}
		//	return count;
		//}

		return null;
	}

}
