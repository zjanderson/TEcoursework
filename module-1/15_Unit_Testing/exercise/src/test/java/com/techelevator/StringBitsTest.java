package com.techelevator;

import org.junit.Assert;
import org.junit.*;

public class StringBitsTest {
    /*
     * Given a string, return a new string made of every other char starting with
     * the first, so "Hello" yields "Hlo". GetBits("Hello") → "Hlo" GetBits("Hi")
     * → "H" GetBits("Heeololeo") → "Hello"
     */

    @Test
    public void string_has_every_other_char() {
        //arrange
        StringBits testStringBits = new StringBits();

        //act
        String getBits = testStringBits.getBits("Hello");

        //assert
        Assert.assertEquals("Hlo", getBits);
    }
}
