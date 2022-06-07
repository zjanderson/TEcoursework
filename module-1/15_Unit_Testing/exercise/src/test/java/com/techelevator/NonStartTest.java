package com.techelevator;

import org.junit.Assert;
import org.junit.*;

public class NonStartTest {

    @Test
    public void omit_first_char_concatenate_one_short() {
        //arrange
        NonStart testNonStart = new NonStart();

        //act
        String getPartialString = testNonStart.getPartialString("B", "ChickeNS");

        //assert
        Assert.assertEquals("hickeNS", getPartialString);
    }

    @Test
    public void two_null_strings_return_blank() {
        //arrange
        NonStart testNonStart = new NonStart();

        //act
        String getPartialString = testNonStart.getPartialString(null, null);

        //assert
        Assert.assertEquals("", getPartialString);
    }
}
