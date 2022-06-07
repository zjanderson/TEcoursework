package com.techelevator;

import org.junit.Assert;
import org.junit.*;

public class CigarPartyTest {

    @Test
    public void haveParty_returns_true_on_weekday_with_51_cigars() {
        //Arrange
        CigarParty testCigarParty = new CigarParty();

        //Act
        boolean haveParty = testCigarParty.haveParty(51, false);

        //Assert
        Assert.assertEquals(true, haveParty);

    }

    @Test
    public void haveParty_returns_false_on_weekday_with_0_cigars() {
        //Arrange
        CigarParty testCigarParty = new CigarParty();


        //Act
        boolean haveParty = testCigarParty.haveParty(0, false);



        //Assert
        Assert.assertEquals(false, haveParty);

    }

    @Test
    public void haveParty_returns_true_on_weekend_with_1051_cigars() {
        //Arrange
        CigarParty testCigarParty = new CigarParty();


        //Act
        boolean haveParty = testCigarParty.haveParty(1051, true);



        //Assert
        Assert.assertEquals(true, haveParty);

    }

    @Test
    public void haveParty_returns_false_on_weekend_with_7_cigars() {
        //Arrange
        CigarParty testCigarParty = new CigarParty();


        //Act
        boolean haveParty = testCigarParty.haveParty(7, true);



        //Assert
        Assert.assertEquals(false, haveParty);

    }

}
