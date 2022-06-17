package com.techelevator.snack;

import com.techelevator.vendingmachine.Snack;

import java.math.BigDecimal;

public class Drink extends Snack {
	public Drink(String name, BigDecimal price) {
		super(name, price);
	}

	@Override
	public String getSound() {
		return "Glug Glug, Yum!";
	}
}
