package com.techelevator.snack;

import com.techelevator.vendingmachine.Snack;
import com.techelevator.inventory.SnackCreator;

import java.math.BigDecimal;

public class SnackFactory implements SnackCreator {

    /**
     * Factory method for creating a Snack object.
     *
     * @param snackType  The type of Snack to create.
     * @param snackName  The name of the Snack.
     * @param snackPrice The price of the Snack.
     * @return A Snack.
     */
    @Override
    public Snack createSnackForType(String snackType, String snackName, BigDecimal snackPrice) {
        if (snackType != null) {
            switch (snackType) {
                case "Candy":
                    return new Candy(snackName, snackPrice);
                case "Chip":
                    return new Chip(snackName, snackPrice);
                case "Drink":
                    return new Drink(snackName, snackPrice);
                case "Gum":
                    return new Gum(snackName, snackPrice);
            }
        }

        throw new IllegalArgumentException("No snack exists for snack type: " + snackType);
    }
}
