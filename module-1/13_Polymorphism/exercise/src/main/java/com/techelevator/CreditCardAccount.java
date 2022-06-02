package com.techelevator;

public class CreditCardAccount implements Accountable{

    private String accountHolder; //needs getter, The account holder name that the account belongs to.
    private String accountNumber; //needs getter, The account number that the account belongs to.
    private int debt; //needs getter, The amount the customer owes.

  //  private int balance = (debt * (-1));

    public CreditCardAccount(String accountHolder, String accountNumber) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.debt = 0;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getDebt() {
        return debt;
    }

    public int getBalance() {
        return (debt * (-1));
    }

    public int pay(int amountToPay) {
        debt = debt - amountToPay;
        return debt;
    }

    public int charge(int amountToCharge) {
        debt = debt + amountToCharge;
        return debt;
    }

}
