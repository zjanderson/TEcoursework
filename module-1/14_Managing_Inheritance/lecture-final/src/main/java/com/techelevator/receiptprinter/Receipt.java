package com.techelevator.receiptprinter;

public abstract class Receipt {

    public final String print() {
        String receipt = "";

        receipt += printHeading();

        receipt += printItems();

        receipt += printTotal();

        return receipt;
    }

    public abstract String printHeading();
    public abstract String printItems();
    public abstract String printTotal();
}
