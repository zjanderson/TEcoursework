package com.techelevator.bankaccount;

public class SavingsAccount extends BankAccount {
    private static final int FEE = 2;
    private static final int MINIMUM_BALANCE = 150;

    public SavingsAccount(String accountHolder, String accountNumber, int balance) {
        super(accountHolder, accountNumber, balance);
    }

    public SavingsAccount(String accountHolder, String accountNumber) {
        super(accountHolder, accountNumber);
    }

    /*
        starting balance 150, input: 1, output: 147
        starting balance 100, input: 99, output: 100
        starting balance 250, input: 100, output: 150
        starting balance 1000, input: -1, output: 1000
        starting balance 1000, input: 0, output: 1000
        starting balance 50, input: 1, output: 47
     */

    @Override
    public int withdraw(int amountToWithdraw) {
        if (amountToWithdraw < 0) {
            return getBalance();
        }

        // only perform transaction of positive $ and room for fee
        if (getBalance() - amountToWithdraw >= FEE) {
            super.withdraw(amountToWithdraw);
            // Assess $2 fee if it goes below $150
            if (getBalance() < MINIMUM_BALANCE) {
                super.withdraw(FEE);
            }
        }
        return getBalance();
    }
}
