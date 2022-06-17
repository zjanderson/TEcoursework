package com.techelevator.snack;

import java.math.BigDecimal;

import com.techelevator.vendingmachine.Snack;
import com.techelevator.inventory.SnackCreator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SnackTests {
	private final SnackCreator snackCreator = new SnackFactory();

	@Test
	public void toString_returns_formatted_snack() {
		// Arrange
		Snack snack = snackCreator.createSnackForType("Chip", "blah", BigDecimal.ONE);

		// Act
		String snackString = snack.toString();
		
		// Assert
		Assert.assertEquals("Crunch Crunch, Yum!" + System.lineSeparator() + "Name: blah, Cost: $1.00", snackString);
	}
	
	@Test
	public void getSound_returns_chip_sound() {
		// Arrange

		// Act
		Snack actualSnack = snackCreator.createSnackForType("Chip", "blah", BigDecimal.ONE);

		// Assert
		Assert.assertEquals("Crunch Crunch, Yum!", actualSnack.getSound());
	}

	@Test
	public void getSound_returns_candy_sound() {
		// Arrange

		// Act
		Snack actualSnack = snackCreator.createSnackForType("Candy", "blah", BigDecimal.ONE);

		// Assert
		Assert.assertEquals("Munch Munch, Yum!", actualSnack.getSound());
	}

	@Test
	public void getSound_returns_gum_sound() {
		// Arrange

		// Act
		Snack actualSnack = snackCreator.createSnackForType("Gum", "blah", BigDecimal.ONE);

		// Assert
		Assert.assertEquals("Chew Chew, Yum!", actualSnack.getSound());
	}

	@Test
	public void getSound_returns_drink_sound() {
		// Arrange

		// Act
		Snack actualSnack = snackCreator.createSnackForType("Drink", "blah", BigDecimal.ONE);

		// Assert
		Assert.assertEquals("Glug Glug, Yum!", actualSnack.getSound());
	}

	@Test(expected = IllegalArgumentException.class)
	public void createSnackForType_with_null_snack_type_throws_exception() {
		// Arrange
		String snackType = null;
		String snackName = "Test Snack";
		BigDecimal snackPrice = BigDecimal.ONE;

		// Act
		snackCreator.createSnackForType(snackType, snackName, snackPrice);
	}

	@Test(expected = IllegalArgumentException.class)
	public void createSnackForType_with_invalid_snack_type_throws_exception() {
		// Arrange
		String snackType = "Blah";
		String snackName = "Test Snack";
		BigDecimal snackPrice = BigDecimal.ONE;

		// Act
		snackCreator.createSnackForType(snackType, snackName, snackPrice);
	}

	@Test
	public void createSnackForType_creates_chip() {
		create_and_validate_snack("Chip", Chip.class);
	}

	@Test
	public void createSnackForType_creates_drink() {
		create_and_validate_snack("Drink", Drink.class);
	}

	@Test
	public void createSnackForType_creates_candy() {
		create_and_validate_snack("Candy", Candy.class);
	}

	@Test
	public void createSnackForType_creates_gum() {
		create_and_validate_snack("Gum", Gum.class);
	}

	private void create_and_validate_snack(String snackType, Class<?> classType) {
		// Arrange
		String snackName = "Test Snack";
		BigDecimal snackPrice = BigDecimal.ONE;

		// Act
		Snack actualSnack = snackCreator.createSnackForType(snackType, snackName, snackPrice);

		// Assert
		Assert.assertEquals(classType, actualSnack.getClass());
		Assert.assertEquals(snackName, actualSnack.getName());
		Assert.assertEquals(snackPrice, actualSnack.getPrice());

	}
}
