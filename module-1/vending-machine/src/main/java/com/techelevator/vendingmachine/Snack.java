package com.techelevator.vendingmachine;

import java.math.BigDecimal;

import com.techelevator.MoneyFormatter;
import com.techelevator.snack.*;

public abstract class Snack {
	private final String name;
	private final BigDecimal price;

	public Snack(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}

	/**
	 * Get the sound that the Snack makes when consumed.
	 * 
	 * @return The sound that the Snack makes when consumed.
	 */
	public abstract String getSound();

	/**
	 * Get the name of the Snack.
	 * 
	 * @return The name of the Snack.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get the price of the Snack.
	 * 
	 * @return The price of the Snack.
	 */
	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return getSound() + System.lineSeparator() + "Name: " + getName() + ", Cost: " + MoneyFormatter.formatMoney(getPrice());
	}
}
