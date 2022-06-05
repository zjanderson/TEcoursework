package com.techelevator.Strings;

import com.techelevator.strings.M1D06IntroObjectsStringsExercise;
import org.junit.*;

public class M1D06IntroObjectsStringsExerciseTest {
    /*
	 Given a string, return true if "bad" appears starting at index 0 or 1 in the string, such as with
	 "badxxx" or "xbadxx" but not "xxbadxx". The string may be any length, including 0. Note: use .equals()
	 to compare 2 strings.
	 hasBad("badxx") → true
	 hasBad("xbadxx") → true
	 hasBad("xxbadxx") → false
	 hasBad(null) -> false
	 hasBad("") -> false
	 */

    @Test
    public void hasBad_returns_false_given_null() {
        //Arrange
        M1D06IntroObjectsStringsExercise sut = new M1D06IntroObjectsStringsExercise();

        //Act
        boolean hasBad = sut.hasBad(null);

        //Assert
        Assert.assertFalse(hasBad);
    }


}
