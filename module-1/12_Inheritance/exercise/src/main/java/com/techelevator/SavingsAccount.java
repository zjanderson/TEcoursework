package com.techelevator;

public class SavingsAccount extends BankAccount{ //need to call constructor of super!

    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }
    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }
    /*        Fields, Properties, Member Variables, Instance Variables     */
    int minBalanceFeeFree = 150;
    int lowBalanceServiceFee = 2;


    /*        Constructors     */


    /*        Getters and Setters     */


    /*        Methods     */
    public int withdraw(int amountToWithdraw) {
        if ((getBalance() - amountToWithdraw) >= lowBalanceServiceFee) {
            super.withdraw(amountToWithdraw);
            if (getBalance() < minBalanceFeeFree) {
                super.withdraw(lowBalanceServiceFee);
            }
        }
        return getBalance();
    }


}
