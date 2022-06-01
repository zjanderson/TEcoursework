package com.techelevator;

public class BankAccount {
    /*        Fields, Properties, Member Variables, Instance Variables     */
    private String accountHolderName; //getter, Returns the account holder name that the account belongs to.
    private String accountNumber; //getter, Returns the account number that the account belongs to
    private int balance; //getter,
    private final int startingBalance = 0; //new acct balance defaults to 0 unless one is given


    /*        Constructors     */
    public BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        balance = startingBalance;
    }

    public BankAccount(String accountHolderName, String accountNumber, int balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance; //i need to figure out where this is coming from
    }


    /*        Getters and Setters     */

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }


    /*        Methods     */
    public int deposit(int amountToDeposit) { //Adds amountToDeposit to the current balance, and returns the new balance of the bank account.
        balance = balance + amountToDeposit;
        return balance;
    }

    public int withdraw(int amountToWithdraw) { //Subtracts amountToWithdraw from the current balance, and returns the new balance of the bank account.
        balance = balance - amountToWithdraw;
        return balance;
    }


}
