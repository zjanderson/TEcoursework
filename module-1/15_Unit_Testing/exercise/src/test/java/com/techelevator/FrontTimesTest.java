package com.techelevator;

import org.junit.Assert;
import org.junit.*;

public class FrontTimesTest {

    @Test
    public void generateString_return_String_given_long_string() {
        //arrange
        FrontTimes testFrontTimes = new FrontTimes();

        //act
        String generateString = testFrontTimes.generateString("Wiggles", 4);


        //assert
        Assert.assertEquals("WigWigWigWig", generateString);

    }

    @Test
    public void generateString_return_PiPiPiPi_given_Pi_4() {
        //arrange
        FrontTimes testFrontTimes = new FrontTimes();

        //act
        String generateString = testFrontTimes.generateString("Pi", 4);


        //assert
        Assert.assertEquals("PiPiPiPi", generateString);

    }

    @Test
    public void generateString_return_empty_given_null_7() {
        //arrange
        FrontTimes testFrontTimes = new FrontTimes();

        //act
        String generateString = testFrontTimes.generateString(null, 7);


        //assert
        Assert.assertEquals("", generateString);

    }
}
