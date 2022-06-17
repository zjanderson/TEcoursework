package com.techelevator.inventory;

import com.techelevator.vendingmachine.Snack;

import java.math.BigDecimal;

public interface SnackCreator {

    Snack createSnackForType(String snackType, String snackName, BigDecimal snackPrice);
}
