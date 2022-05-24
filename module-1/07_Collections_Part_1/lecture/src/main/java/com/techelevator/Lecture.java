package com.techelevator;

import java.util.*;

//if you're using a BUNCH of java.util tools, we can import java.util.* to get all of them

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		List<String > names = new ArrayList<>();  //this will generate a new ArrayList in memory
		names.add("Zac");
		names.add("Bryson");
		names.add("Heath");
		names.add("Bennett");
		names.add("Grant");
		names.add("Sawyer");


		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists allow duplicates");  //so do arrays!
		System.out.println("####################");

		names.add("Zac");
		//copy and paste prev for-loop to prove this duplicate is added:
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		names.add(1, "Jeff");

		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		names.remove(1);

		//names.remove("Jeff"); this will remove the FIRST occurance of this string

		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}


		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).equalsIgnoreCase("Bennett")); {
				//return true;
			}
		}

		//there's a built-in method for this!

		if (names.contains("Bennett")); {
			//true
		}



		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).equalsIgnoreCase("Bennett")); {
				//return i;
			}
		}

//		another way to do this as follows:
		int indexOfBennett = names.indexOf("Bennett"); //returns first index of "Bennett"



		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");
		//First, must create array same size and type as list
		String[] namesArray = new String[names.size()];

		//Second, go thru List with a loop
		for (int i = 0; i < names.size(); i++) {
			//Third, copy each element from List and add it to Array
			namesArray[i] = names.get(i);
		}

		//there's a convenience method for this, as well

		String[] empty = new String[0]; //we generate a new array to prep for next step
		String[] namesArrayV2 = names.toArray(empty); //this looks at the provided array to verify TYPE, and since size is 0 in this case, it sizes the new array correctly


		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		Collections.sort(names);

		for (int i = 0; i < names.size(); i++) {
				System.out.println(names.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(names);

		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		System.out.println();  //blank line for spacing, below is another way to do it

		for (int i = names.size() -1; i >= 0; i--) {
			System.out.println(names.get(i));
		}


		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		for (String name : names) { //read as 'for string 'name' IN list Names
			System.out.println(name);

		}

		System.out.println("####################");
		System.out.println("       PRIMITIVE WRAPPERS");
		System.out.println("####################");
		System.out.println();

		List<Integer> numbers = new ArrayList<>();

		numbers.add(1);
		numbers.add(5);
		numbers.add(10);
		numbers.add(20);

		//numbers.add(1.5); doesn't work, not an integer!

		Integer numberAtIndex2 = numbers.get(2); //this is because we have used Wrapper Class Integer
		//however, unboxing can happen automatically as follows with no errors
		numberAtIndex2 = numbers.get(2);

		//can loop, as well
		// [1, 5, 10, 20]

		for (int anyNumber : numbers) {  //this is for/each loop
			System.out.println(anyNumber);
		}

		for (int i = 0; i < numbers.size(); i++) { //this is traditional loop
			int anyNumber = numbers.get(i);
			System.out.println(anyNumber);
		}

		System.out.println("####################");
		System.out.println("       STACKS AND QUEUES");
		System.out.println("####################");
		System.out.println();

		Queue<String> nextForCoffee = new LinkedList<>();

		nextForCoffee.offer("Patrick");
		nextForCoffee.offer("Aly");
		nextForCoffee.offer("Allison");

		String whoIsNext = nextForCoffee.peek();
		System.out.println(whoIsNext + " is next!");

		while (nextForCoffee.size() > 0) {  //can write as while (!nextForCoffee.isEmpty())
			String nextUp = nextForCoffee.poll();
			System.out.println("Here is your coffee, " + nextUp);
		}

		Stack<String> urlsVisited = new Stack<>();

		urlsVisited.push("www.google.com");
		urlsVisited.push("www.techelevator.com");
		urlsVisited.push("www.facebook.com");

		while (!urlsVisited.isEmpty()) {
			String url = urlsVisited.pop();
			System.out.println(url);
		}

		//if you want to remove everything from a stack or queue, you can use .clear(), it will go back to size of zero


	}
}
