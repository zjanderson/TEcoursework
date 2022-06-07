package com.techelevator;

import org.junit.Assert;
import org.junit.*;

public class Lucky13Test {

    @Test
    public void getLucky_return_true_if_array_contains_1_or_3() {
        //address
        Lucky13 testLucky13 = new Lucky13();


        //act
        //boolean getLucky = testLucky13.getLucky(new int[] {0, 2, 4}); we can make this array in our assertions below


        //assert
        Assert.assertEquals(false, testLucky13.getLucky(new int[] {2, 1, 5, 6, 7, 8}));
        Assert.assertEquals(true, testLucky13.getLucky(new int[] {4}));
    }
}
