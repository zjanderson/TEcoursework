package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		List<String> names = new ArrayList<>();

		names.add("Walt");
		names.add("Anthony");
		names.add("Greg");
		names.add("Christopher");
		names.add("Sasi");
		names.add("Rich");


		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		names.add("Rich");

		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		names.add(1, "Nick");

		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}

//		names.add(100, "Josh"); can't add beyond the current size of the List

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		names.remove(1);

//		names.remove("Rich"); You can remove the element itself, it will remove the first occurrence

		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).equals("Rich")) {
				// return true;
			}
		}

		if (names.contains("Rich")) {
			// true
		}


		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).equals("Rich")) {
				// return i;
			}
		}

		int indexOfRich = names.indexOf("Rich"); // 5


		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		// 1. create an array that is the same size and type as the list
		String[] namesArray = new String[names.size()];

		// 2. iterate over the list
		for (int i = 0; i < names.size(); i++) {
			// 3.  copy from corresponding element in the list to corresponding element in the array
			namesArray[i] = names.get(i);
		}

		String[] empty = new String[0];
		String[] namesArrayV2 = names.toArray(empty);


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


		for (int i = names.size() - 1; i >= 0; i--) {
			System.out.println(names.get(i));
		}


		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		for (String name : names) {
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

//		List<Integer> numbersV2 = new ArrayList<>();
//
//		numbersV2.addAll(numbers);

		Integer numberAtIndex2 = numbers.get(2);

		// [ 1, 5, 10, 20 ]
		//              ^
		//   0  1   2   3
		//  numbers.get(i)

		for(int number : numbers) {
			System.out.println(number);
		}

		for(int i = 0; i < numbers.size(); i++) {
			int number = numbers.get(i);
		}


		System.out.println("####################");
		System.out.println("STACKS AND QUEUES");
		System.out.println("####################");
		System.out.println();


		Queue<String> nextForCoffee = new LinkedList<>();
		Queue<String> waitingForOrder = new LinkedList<>();

		nextForCoffee.offer("Patrick");
		nextForCoffee.offer("Aly");
		nextForCoffee.offer("Allison");

		String whoIsNext = nextForCoffee.peek();
		System.out.println(whoIsNext + " is next.");

		while (!nextForCoffee.isEmpty()) {
			String nextUp = nextForCoffee.poll();

			waitingForOrder.offer(nextUp);

			System.out.println("Here is your coffee, " + nextUp);
		}


		Stack<String> urls = new Stack<>();

		urls.push("https://www.techelevator.com");
		urls.push("https://www.google.com");
		urls.push("https://www.espn.com");

		/*
		   https://www.espn.com
		   https://www.google.com
		   https://www.techelevator.com
		 */

		String whoIsOnTop = urls.peek();

		while(!urls.isEmpty()) {
			String url = urls.pop();
			System.out.println(url);
		}


		names.clear(); // remove all 
	}
}
