package com.techelevator;

import org.junit.Assert;
import org.junit.*;

public class MaxEnd3Test {
    /*
     Given an array of ints length 3, figure out which is larger between the first and last elements
     in the array, and set all the other elements to be that value. Return the changed array.
     MakeArray([1, 2, 3]) → [3, 3, 3]
     MakeArray([11, 5, 9]) → [11, 11, 11]
     MakeArray([2, 11, 3]) → [3, 3, 3]
     */


    @Test
    public void makeArray_largest_num_last() {
        //arrange
        MaxEnd3 testMaxEnd3 = new MaxEnd3();

        //act
        int[] makeArray = testMaxEnd3.makeArray(new int[]{1, 2, 3});


        //assert
        Assert.assertArrayEquals((new int[]{3, 3, 3}), makeArray );
    }
}
