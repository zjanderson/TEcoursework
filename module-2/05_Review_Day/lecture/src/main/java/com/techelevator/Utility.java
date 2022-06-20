package com.techelevator;

import java.text.NumberFormat;

public class Utility {

    public static String formatMoney(double amount) {
        return NumberFormat.getCurrencyInstance().format(amount);
    }
}
