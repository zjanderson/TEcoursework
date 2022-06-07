package com.techelevator;

import org.junit.Assert;
import org.junit.*;

public class Less20Test {
    /*
         Return true if the given non-negative number is 1 or 2 less than a multiple of 20. So for example 38
         and 39 return true, but 40 returns false.
         (Hint: Think "mod".)
         less20(18) → true
         less20(19) → true
         less20(20) → false
     */

    @Test
    public void less_than_mult_of_20() {
        Less20 testLess20 = new Less20();

        Assert.assertEquals(true, (testLess20.isLessThanMultipleOf20(78)));
        Assert.assertEquals(true, (testLess20.isLessThanMultipleOf20(79)));
        Assert.assertEquals(false, (testLess20.isLessThanMultipleOf20(80)));

    }
}
