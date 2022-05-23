package com.techelevator;

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

		String greeting = "Hello, Walt!";
		System.out.println(greeting);

		String greetingAgain = new String("Hello, Walt!");
		System.out.println(greetingAgain);
		
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
		boolean endsWithLLO = hello.endsWith("llo"); // true
		boolean endsWithLL = hello.endsWith("ll"); // false
		boolean startsWithHE = hello.startsWith("he"); // true
		boolean startWithHE2 = "hello".startsWith("he"); // true

		if (hello.startsWith("he")) {
			// any code in here would run
		}

		hello.contains("ll"); // true
		hello.contains("eo"); // false
		boolean containsEAndO = hello.contains("e") && hello.contains("o"); // true

		 /*
		 * indexOf
		 * lastIndexOf*/

		String helloWorld = "Hello World!";

		int indexOfO = helloWorld.indexOf("o"); // 4
		int indexOfWorld = helloWorld.indexOf("World"); // 6
		int indexOfLastO = helloWorld.lastIndexOf('o'); // 7
		int indexOfHello = helloWorld.indexOf("hello"); // -1

		if (helloWorld.indexOf("World") == 6) {

		}


		 /* charAt
		 */

		int[] array = new int[5];
		int lastInteger = array[4];

		String techElevator = "Tech Elevator";
		char t = techElevator.charAt(0); // 'T'
		char charAt5 = techElevator.charAt(5); // 'E'
		"blah".charAt(2); // 'a'

		/*
		 * length
		 */

		String blah = "blah";
		int lengthOfBlah = blah.length(); // 4
		int lengthOfOtherString = "Hello Walt".length(); // 10


		/*
		 * substring
		 */

		helloWorld = "Hello World!";

		String mySubstring = helloWorld.substring(5); // " World!"
		String myOtherSubstring = helloWorld.substring(6, 8); // "Wo"

		int i = 5;
		helloWorld.substring(i, i + 2);


		/*
				Stack									Heap

				int x = 1;
				int y = 1;

				String hello 0x3333 	------------>  "hello Walt"
													   "hello"
													    "Hello"
				String x,y, ----->


		 */

		hello = "Hello";
		hello = "hello";

		hello = hello + " Walt";



		/*
		 * toLowerCase
		 * toUpperCase
		 *
		 */

		String city = "Pittsburgh";
		String cityUpper = city.toUpperCase(); // "PITTSBURGH"
		String cityLower = "Pittsburgh".toLowerCase(); // "pittsburgh"

		/*
		 * trim
		 */

		String userInput = " Walt Impellicceiri     ";
		String userInputTrimmed = userInput.trim(); // "Walt Impellicceiri"

		/*
		 * replace
		 */

		String stringToSearch = "May 23rd, 2022";
		String replacedString = stringToSearch.replace("2", "0"); // May 03rd, 0000
		String replaceAgain = stringToSearch.replace("May", "June"); // "June 23rd, 2022"

		"1 2 3 4 5".replace(' ', ','); // 1,2,3,4,5


		System.out.println();
		System.out.println("**********************");
		System.out.println("****** METHOD CHAINING ******");
		System.out.println("**********************");
		System.out.println();

		String method = "MeThod";

		String methodInUppercase = method.toUpperCase(); // "METHOD"
		if (methodInUppercase.contains("TH")) {

		}

		if (method.toUpperCase().contains("TH")) {

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

		/*
			Stack		         Heap

			hello1 0x1111 ----> "Hello"
			hello3 0x1111

			hello2 0x2222 ----> "Hello"
		 */


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



		String hello4 = "Hello";
		String hello5 = "Hello";

		/*

			hello4, hello5 ------> "Hello"

		 */

		if(hello4 == hello5) {
			System.out.println("hello4 is equal to hello5");
		}

	}

	/*
	 * howManyOf("test", 't') -> 2
	 * howManyOf("test", 'a') -> 0
	 *
	 *
	 * str -> "Hello World"
	 * x -> 'o'
	 *
	 * charCount -> 2
	 * i -> 11
	 *
	 */
	public static int howManyOf(String str, char x) {
		int charCount = 0;

		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == x) {
				charCount++;
			}
		}

		return charCount;
	}

	/*
	 * isPalindrome("tacocat") -> true
	 * isPalindrome("racecar") -> true
	 * isPalindrome("blah") -> false
	 *
	 *
	 * 	r a c e c a r
	 *    ^       ^
	 *
	 */
	public static boolean isPalindrome(String word) {
		int i = 0;
		int j = word.length() - 1;

		while (i < j) {
			if (word.charAt(i) != word.charAt(j)) {
				return false;
			}

			i++;
			j--;
		}


		return true;
	}

	/*
	 * makeWordsTitleCase("THE quick BrowN fox") -> "The Quick Brown Fox"
	 *
	 *
	 *
	 * "THE" -> first character to uppercase + every character after to lowercase
	 *
	 *
	 *  sentence -> "THE quick BrowN fox"
	 *  returnValue -> "The Quick Brown Fox"
	 *  words -> ["THE", "quick", "BrowN", "fox"]
	 *  i -> 1
	 *  word -> "quick"
	 *  newWord -> "Q" + "uick" -> "Quick"
	 */
	public static String makeWordsTitleCase(String sentence) {
		String returnValue = "";

		String[] words = sentence.split(" ");

		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			String newWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
			returnValue += newWord + " ";
		}

		return returnValue.trim();
	}
}
