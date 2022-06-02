package com.techelevator.receiptprinter;

import java.util.ArrayList;
import java.util.List;

public class TextReceipt extends Receipt {
    private List<String> items = new ArrayList<>();

    @Override
    public String printHeading() {
        return "Receipt";
    }

    @Override
    public String printItems() {
        String itemString = "";

        for (String item : items) {
            itemString += item + "\n";
        }

        return itemString;
    }

    @Override
    public String printTotal() {
        return null;
    }
}
