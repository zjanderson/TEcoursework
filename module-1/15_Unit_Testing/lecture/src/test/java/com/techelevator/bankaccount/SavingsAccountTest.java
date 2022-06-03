package com.techelevator.bankaccount;

import org.junit.*;

public class SavingsAccountTest {
    /*
        starting balance 150, input 1 : output 147
        starting balance 100, input 99 : output 100 (withdraw amnt too large, no withdrawal made)
        starting balance 250, input 100 : output 150
        starting balance 1000, input -1 : output 1000 (should not allow, and no withdrawal)
        starting balance 50, input 1 : output 47

     */

    @Test
    public void withdraw_returns_147_given_150_start_and_withdraw_1() {
        //Arrange
        SavingsAccount testSavingsAccount = new SavingsAccount("Walt", "12345", 150);

        //Act
        int remainingBalance = testSavingsAccount.withdraw(1);

        //Assert
        Assert.assertEquals(147, remainingBalance);
    }

    @Test
    public void withdraw_prevented_when_whithdrawing_more_than_net_withdraw_and_fee() {
        //Arrange
        SavingsAccount testSavingsAccount = new SavingsAccount("Walt", "12345", 100);

        //Act
        int remainingBalance = testSavingsAccount.withdraw(99);

        //Assert
        Assert.assertEquals(100, remainingBalance);
    }

    @Test
    public void withdraw_prevented_when_withdraw_negative() {
        //Arrange
        SavingsAccount testSavingsAccount = new SavingsAccount("Walt", "12345", 1000);

        //Act
        int remainingBalance = testSavingsAccount.withdraw(-1);

        //Assert
        Assert.assertEquals(1000, remainingBalance);
    }
}
