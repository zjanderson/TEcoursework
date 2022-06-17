package com.techelevator.snack;

import com.techelevator.vendingmachine.Snack;

import java.math.BigDecimal;

public class Candy extends Snack {
	public Candy(String name, BigDecimal price) {
		super(name, price);
	}

	@Override
	public String getSound() {
		return "Munch Munch, Yum!";
	}

}
