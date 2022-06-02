package com.techelevator;

public class BankAccount implements Accountable {

    private String accountHolderName;
    private String accountNumber;
    private int balance;

    public BankAccount(String accountHolder, String accountNumber) {
        this.accountHolderName = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public BankAccount(String accountHolder, String accountNumber, int balance) {
        this.accountHolderName = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public int deposit(int amountToDeposit) {
        balance = balance + amountToDeposit;
        return balance;
    }

    public int withdraw(int amountToWithdraw) {
        balance = balance - amountToWithdraw;
        return balance;
    }

    public int transferTo(BankAccount destinationAccount, int transferAmount) {
        //Withdraws transferAmount from this account, deposits it into destinationAccount,
        // and returns the new balance of this account.
        //this.balance = balance - transferAmount;  this only passes 2/3 tests
        //destinationAccount.balance = destinationAccount.balance + transferAmount;
        //return balance;
        withdraw(transferAmount);
        destinationAccount.deposit(transferAmount);
        return balance;
    }

}
