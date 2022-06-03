package com.techelevator.maps;

import java.util.Map;
import java.util.HashMap;

public class M1D08CollectionsPart2Exercise {

    /*
     * Given an array of Strings, return a Map<String, Integer> with a key for each different String, with the value the
     * number of times that String appears in the array.
     *
     * ** A CLASSIC **
     *
     * M1D08CollectionsPart2Exercise
     *
     */
    public Map<String, Integer> wordCount(String[] words) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            if (wordCount.containsKey(word)) {
                Integer currentCount = wordCount.get(word);
                wordCount.put(word, currentCount + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
        return wordCount;
    }
}
