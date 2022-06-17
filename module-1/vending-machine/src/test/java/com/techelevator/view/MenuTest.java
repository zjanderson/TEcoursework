package com.techelevator.view;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MenuTest {

	private ByteArrayOutputStream output;

	@Before
	public void setup() {
		output = new ByteArrayOutputStream();
	}

	@Test
	public void displays_a_list_of_menu_options_and_prompts_user_to_make_a_choice() {
		Object[] options = new Object[] {3, "Blind", "Mice" };
		Menu menu = getMenuForTesting();

		menu.getChoiceFromOptions(options);

		String expected = System.lineSeparator()
				+ "1) " + options[0].toString() + System.lineSeparator()
				+ "2) " + options[1].toString() + System.lineSeparator()
				+ "3) "+ options[2].toString() + System.lineSeparator()
				+ System.lineSeparator()
				+ "Please choose an option >>> ";

		Assert.assertEquals(expected, output.toString());
	}

	@Test
	public void returns_object_corresponding_to_user_choice() {
		Integer expected = 456;
		Integer[] options = new Integer[] {123, expected, 789};
		Menu menu = getMenuForTestingWithUserInput("2" + System.lineSeparator());

		Integer result = (Integer) menu.getChoiceFromOptions(options);

		Assert.assertEquals(expected, result);
	}

	@Test
	public void redisplays_menu_if_user_does_not_choose_valid_option() {
		Menu menu = getMenuForTestingWithUserInput("4" + System.lineSeparator() + "1" + System.lineSeparator());

		menu.getChoiceFromOptions(getOptions());

		String expected = getMenuDisplay() + System.lineSeparator()
				+ "*** 4 is not a valid option ***" + System.lineSeparator()
				+ System.lineSeparator()
				+ getMenuDisplay();

		Assert.assertEquals(expected, output.toString());
	}

	@Test
	public void redisplays_menu_if_user_chooses_option_less_than_1() {
		Menu menu = getMenuForTestingWithUserInput("0" + System.lineSeparator() +"1" + System.lineSeparator());

		menu.getChoiceFromOptions(getOptions());

		String expected = getMenuDisplay() + System.lineSeparator()
				+ "*** 0 is not a valid option ***" + System.lineSeparator()
				+ System.lineSeparator()
				+ getMenuDisplay();

		Assert.assertEquals(expected, output.toString());
	}

	@Test
	public void redisplays_menu_if_user_enters_garbage() {
		Menu menu = getMenuForTestingWithUserInput("Mickey Mouse" + System.lineSeparator() + "1" + System.lineSeparator());

		menu.getChoiceFromOptions(getOptions());

		String expected = getMenuDisplay() + System.lineSeparator()
				+ "*** Mickey Mouse is not a valid option ***" + System.lineSeparator()
				+ System.lineSeparator()
				+ getMenuDisplay();

		Assert.assertEquals(expected, output.toString());
	}

	private Menu getMenuForTestingWithUserInput(String userInput) {
		ByteArrayInputStream input = new ByteArrayInputStream(userInput.getBytes());
		return new Menu(input, output);
	}

	private Menu getMenuForTesting() {
		return getMenuForTestingWithUserInput("1" + System.lineSeparator());
	}

	private Object[] getOptions() {
		return new Object[] { "Larry", "Curly", "Moe" };
	}

	private String getMenuDisplay() {
		Object[] options = getOptions();

		return System.lineSeparator()
				+ "1) " + options[0].toString() + System.lineSeparator()
				+ "2) " + options[1].toString() + System.lineSeparator()
				+ "3) "+ options[2].toString() + System.lineSeparator()
				+ System.lineSeparator()
				+ "Please choose an option >>> ";
	}
}
