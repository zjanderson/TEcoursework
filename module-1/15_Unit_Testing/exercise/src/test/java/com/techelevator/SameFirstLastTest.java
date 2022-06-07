package com.techelevator;

import org.junit.Assert;
import org.junit.*;

public class SameFirstLastTest {
    /*
     Given an array of ints, return true if the array is length 1 or more, and the first element and
     the last element are equal.
     IsItTheSame([1, 2, 3]) → false
     IsItTheSame([1, 2, 3, 1]) → true
     IsItTheSame([1, 2, 1]) → true
     */

    @Test
    public void return_false_when_first_and_last_different() {
        //Arrange
        SameFirstLast testOutput = new SameFirstLast();

        //Act
        boolean isItTheSame = testOutput.isItTheSame(new int[]{1, 2, 3});

        //Assert
        Assert.assertEquals(false, isItTheSame);

    }

    @Test
    public void return_false_when_array_null() {
        //Arrange
        SameFirstLast testOutput = new SameFirstLast();

        //Act
        boolean isItTheSame = testOutput.isItTheSame(null);

        //Assert
        Assert.assertEquals(false, isItTheSame);

    }
}
