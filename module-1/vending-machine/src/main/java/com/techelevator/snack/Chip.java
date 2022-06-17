package com.techelevator.snack;

import com.techelevator.vendingmachine.Snack;

import java.math.BigDecimal;

public class Chip extends Snack {
	public Chip(String name, BigDecimal price) {
		super(name, price);
	}

	@Override
	public String getSound() {
		return "Crunch Crunch, Yum!";
	}
}
