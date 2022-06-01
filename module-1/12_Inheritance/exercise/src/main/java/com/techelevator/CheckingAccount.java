package com.techelevator;

public class CheckingAccount extends BankAccount{  //need to call constructor of super!

    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
       super(accountHolderName, accountNumber, balance);
    }
    /*        Fields, Properties, Member Variables, Instance Variables     */

    int maxNegBal = -100;
    int overdraftFee = 10;


    /*        Constructors     */


    /*        Getters and Setters     */


    /*        Methods     */
    public int withdraw(int amountToWithdraw) { //Subtracts amountToWithdraw from the current balance, and returns the new balance of the bank account.
        if (getBalance() - amountToWithdraw > maxNegBal) {
            super.withdraw(amountToWithdraw);

            if (getBalance() < 0) {
                super.withdraw(overdraftFee);
            }
        }
        return getBalance();
    }


}
