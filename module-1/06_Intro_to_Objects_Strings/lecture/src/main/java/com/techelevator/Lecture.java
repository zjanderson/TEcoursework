package com.techelevator;

import java.util.Locale;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		/* create a new instance of String using a literal */
		System.out.println(); //prints a blank line, for spacing purposes.
		String heyThere = "Welcome, please proceed.";
		System.out.println(heyThere);

		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();


		/* Other commonly used methods:
		 *
		 * endsWith
		 * startsWith
		 * contains
		 */
		String hello = "hello";
		boolean endswith = hello.endsWith("llo"); //true
		boolean endswithLLO = hello.endsWith("LLO"); //false
		boolean startsWith = hello.startsWith("he"); //true
		if (hello.startsWith("he")) {
			//since the if-statement is true, any code in here would run
		}

		boolean hasLL = hello.contains("ll");  //true
		boolean hasEO = hello.contains("eo"); //false
		boolean hasEAndO = hello.contains("e") && hello.contains("o"); //true!

		 /*
		 * indexOf
		 * lastIndexOf
		 */

		String helloWorld = "Hello World!";
		int index = helloWorld.indexOf("o"); //will return 4
		int indexOfWorld = helloWorld.indexOf("World"); //will return 6
		int indexOfLastO = helloWorld.lastIndexOf('o'); //will return 7
		int indexOfHello = helloWorld.indexOf("hello"); //will return -1, which means there is no match in string

		if (helloWorld.indexOf("World") >= 0){ //would basically check if "World" exists

		}

		 /*
		 * charAt
		 */

		int[] array = new int[5];
		int lastInteger = array[4];

		String techElevator = "Tech Elevator";
		char t = techElevator.charAt(0); // 'T'
		char charAt5 = techElevator.charAt(5); // 'E'
		"blah".charAt(2); //'a'

		/*
		 * length
		 */

		String blah = "blah";
		int lengthBlah = blah.length();  //4
		int lengthMyString = "Hello Zac".length(); //9

		 /*
		 * substring  //a way to extract a string from another string
		 */

		String newGreeting = "Hello Everyone";

		String mySubstring = newGreeting.substring(5); //this returns " Everyone"
		String myOtherSubstring = newGreeting.substring(6, 8); //this returns "Ev"

		newGreeting.substring(6, newGreeting.length()); //this returns "Everyone"

		int i = 5;
		String twoLetters = newGreeting.substring(i, i+2); //" E"

		 /*
		 * toLowerCase
		 * toUpperCase
		 */
		String  city = "Pittsburgh";
		String cityUpper = city.toUpperCase(); //"PITTSBURGH"
		String  cityLower = city.toLowerCase(); //"pittsburgh"


		 /*
		 * trim  //removes white space if there's some at the beginning or end
		 */

		 String userInput = " Zac Anderson ";
		 String userInputTrimmed = userInput.trim(); //"Zac Anderson"

		 /*
		 * replace
		 */

		String stringToSearch = "May 23rd, 2022";
		String replaced = stringToSearch.replace("2", "0"); //"May 03rd, 0000"
		String replaceAgain = stringToSearch.replace("May", "June"); //"June 23rd, 2022"

		"1 2 3 4 5".replace(' ', ','); //"1,2,3,4,5"

		 /*
		 */


		System.out.println();
		System.out.println("**********************");
		System.out.println("****** METHOD CHAINING ******");
		System.out.println("**********************");
		System.out.println();

		String method = "Method";
		String capMethod = method.toUpperCase(); //"METHOD"
		if (capMethod.contains("TH")) {
			//this would execute code in here since it's true
		}

		if (method.toUpperCase().contains("TH")) {
			//this chained code will do the same as the above multiple step process, will run this code as well
		}

		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

        char[] helloArray = new char[] { 'H', 'e', 'l', 'l', 'o' };
        String hello1 = new String(helloArray);
        String hello2 = new String(helloArray);

		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}
	}

	/*
	 * howManyOf("test", 't') -> 2
	 * howManyOf("test", 'a') -> 0
	 *
	 * str -> "Hello World"
	 * x -> 'o'
	 */
	public static int howManyOf(String str, char x) {
		int numCharacters = 0;
		int i = 0;

		for (i = 0; i < str.length(); i++){
			if (str.charAt(i) == x) {
				numCharacters++;
			}
		}


		return numCharacters;
	}

	/*
	 * isPalindrome("tacocat") -> true
	 * isPalindrome("racecar") -> true
	 * isPalindrome("blah") -> false
	 */
	public static boolean isPalindrome(String word) {
		if (word.length() == 0) {
			return true; //since an empty string is technically the same forward and back it's true
		}

		int i = 0;
		int j = word.length() - 1; //we need two counters since we're comparing two things

		while (i < j) {  //while loop simplifies this to write and read, when they are equal we have reached middle
			if (word.charAt(i) != word.charAt(j)){
				return false; //since every time these paramaters need to be true, if it's false once we can exit loop
			}
			i++;
			j--;
		}

		return true;
	}

	/*
	 * makeWordsTitleCase("THE quick BrowN fox") -> "The Quick Brown Fox"
	 *
	 * "THE quick BrowN fox"
	 * "THE" -> take first character to uppercase + following characters to lowercase yields title case
	 * we can split the string to an array of strings -> ["THE" "quick" "BrowN" "Fox"]
	 *
	 *
	 */
	public static String makeWordsTitleCase(String sentence) {
		String[] words = sentence.split(" "); //creates array of words from the sentence
		String returnValue = ""; //empty string, this is what we'll return at the end

		for (int i = 0; i < words.length; i++) {
			String word = words[i];			//looks through the array words[],
			String newWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase(); //
			returnValue += newWord + " ";

		}

		return returnValue.trim();
	}
}
