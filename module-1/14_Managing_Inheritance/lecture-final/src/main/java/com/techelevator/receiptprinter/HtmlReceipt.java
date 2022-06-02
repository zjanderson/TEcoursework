package com.techelevator.receiptprinter;

import java.util.ArrayList;
import java.util.List;

public class HtmlReceipt extends Receipt {
    private List<String> items = new ArrayList<>();

    @Override
    public String printHeading() {
        return "<h1>Receipt!</h1>";
    }

    @Override
    public String printItems() {
        String itemString = "<ul>";

        for (String item : items) {
            itemString += "<li>" + item + "</li>";
        }

        itemString += "</ul>";

        return itemString;
    }

    @Override
    public String printTotal() {
        return null;
    }
}
