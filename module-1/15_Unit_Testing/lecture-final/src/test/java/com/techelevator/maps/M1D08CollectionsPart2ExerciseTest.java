package com.techelevator.maps;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class M1D08CollectionsPart2ExerciseTest {
    private M1D08CollectionsPart2Exercise sut;
    /*
     * wordCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
     * wordCount(null) -> null
     */

    @Before
    public void setup() {
        sut = new M1D08CollectionsPart2Exercise();
    }

    @Test
    public void wordCount_returns_ba2_black1_sheep1_given_ba_ba_black_sheep() {
        // Arrange

        String[] input = { "ba", "ba", "black", "sheep" };
        Map<String, Integer> expected = Map.of("ba", 2, "black", 1, "sheep", 1);
//        expected.put("ba", 2);
//        expected.put("black", 1);
//        expected.put("sheep", 1);

        // Act
        Map<String, Integer> actual = sut.wordCount(input);

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void wordCount_returns_null_given_null() {
        // Arrange

        // Act
        Map<String, Integer> actual = sut.wordCount(null);

        // Assert
        Assert.assertNull(actual);
    }
}
